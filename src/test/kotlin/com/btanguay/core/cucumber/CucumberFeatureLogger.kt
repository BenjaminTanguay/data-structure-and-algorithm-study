package com.btanguay.core.cucumber

import com.btanguay.core.log.logger
import com.google.common.base.Strings
import io.cucumber.plugin.ConcurrentEventListener
import io.cucumber.plugin.event.EventHandler
import io.cucumber.plugin.event.EventPublisher
import io.cucumber.plugin.event.HookTestStep
import io.cucumber.plugin.event.PickleStepTestStep
import io.cucumber.plugin.event.Status
import io.cucumber.plugin.event.TestCaseFinished
import io.cucumber.plugin.event.TestCaseStarted
import io.cucumber.plugin.event.TestRunFinished
import io.cucumber.plugin.event.TestRunStarted
import io.cucumber.plugin.event.TestSourceRead
import io.cucumber.plugin.event.TestStepFinished
import io.cucumber.plugin.event.TestStepStarted
import java.util.stream.Stream

class CucumberFeatureLogger: ConcurrentEventListener {
    /*
    Different types of event that can be used to log
    cucumber.api.event.Event - all events.
    cucumber.api.event.TestRunStarted - the first event sent.
    cucumber.api.event.TestSourceRead - sent for each feature file read, contains the feature file source.
    cucumber.api.event.SnippetsSuggestedEvent - sent for each step that could not be matched to a step definition, contains the raw snippets for the step.
    cucumber.api.event.TestCaseStarted - sent before starting the execution of a Test Case(/Pickle/Scenario), contains the Test Case
    cucumber.api.event.TestStepStarted - sent before starting the execution of a Test Step, contains the Test Step
    cucumber.api.event.EmbedEvent - calling scenario.embed in a hook triggers this event.
    cucumber.api.event.WriteEvent - calling scenario.write in a hook triggers this event.
    cucumber.api.event.TestStepFinished - sent after the execution of a Test Step, contains the Test Step and its Result.
    cucumber.api.event.TestCaseFinished - sent after the execution of a Test Case(/Pickle/Scenario), contains the Test Case and its Result.
    cucumber.api.event.TestRunFinished - the last event sent.
     */
    private val featureFilesByUrl: MutableMap<String, String> = HashMap()
    private val seenFeature: MutableSet<String> = HashSet()
    private val log = logger()

    private val printRunStart =
        EventHandler { _: TestRunStarted? ->
            log.info(
                "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ CUCUMBER TEST " + "START ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"
            )
        }

    private val printRunStop =
        EventHandler { _: TestRunFinished? ->
            log.info(
                "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ CUCUMBER TEST " + "END ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑"
            )
        }

    private val saveFeatureName =
        EventHandler { event: TestSourceRead ->
            val source = event.source
            if (!Strings.isNullOrEmpty(source)) {
                val sentences = source.split("\n".toRegex()).toTypedArray()
                val feature = Stream.of(*sentences)
                    .filter { sentence: String ->
                        sentence.trim { it <= ' ' }.startsWith("Feature")
                    }
                    .findFirst()
                feature.ifPresent { sentence: String ->
                    featureFilesByUrl[event.uri.toString()] = sentence.replace("\r".toRegex(), "")
                }
            }
        }

    private val printStepFailure =
        EventHandler { event: TestStepFinished ->
            if (event.result.status == Status.FAILED) {
                val testStep =
                    event.testStep as PickleStepTestStep
                val errorLineNumber = testStep.step.line
                log.error(
                    "Step failed at line {} of file {}",
                    errorLineNumber,
                    testStep.uri,
                    event.result.error
                )
            }
        }

    private val printScenarioResult =
        EventHandler { event: TestCaseFinished ->
            val scenarioName = event.testCase.name
            if (event.result.status == Status.FAILED) {
                log.error("FAILURE!!! Scenario: {}", scenarioName)
            } else {
                log.info("SUCCESS!!! Scenario: {}", scenarioName)
            }
        }

    private val printScenarioName =
        EventHandler { event: TestCaseStarted ->
            val uri = event.testCase.uri.toString()
            if (featureFilesByUrl.containsKey(uri)) {
                val feature = featureFilesByUrl[uri]!!
                if (!seenFeature.contains(feature)) {
                    log.info(feature)
                    seenFeature.add(feature)
                }
            }
            log.info("START Scenario: {}", event.testCase.name)
        }

    private val printStepName =
        EventHandler { event: TestStepStarted ->
            if (event.testStep is PickleStepTestStep) {
                val step =
                    (event.testStep as PickleStepTestStep).step
                log.info("{}{}", step.keyWord, step.text)
            } else if (event.testStep is HookTestStep) {
                val testStep =
                    event.testStep as HookTestStep
                log.info(
                    "{} hook. Executing {}",
                    testStep.hookType,
                    testStep.codeLocation
                )
            }
        }

    override fun setEventPublisher(publisher: EventPublisher) {
        publisher.registerHandlerFor(TestSourceRead::class.java, saveFeatureName)
        publisher.registerHandlerFor(TestCaseStarted::class.java, printScenarioName)
        publisher.registerHandlerFor(TestStepStarted::class.java, printStepName)
        publisher.registerHandlerFor(TestStepFinished::class.java, printStepFailure)
        publisher.registerHandlerFor(TestCaseFinished::class.java, printScenarioResult)
        publisher.registerHandlerFor(TestRunStarted::class.java, printRunStart)
        publisher.registerHandlerFor(TestRunFinished::class.java, printRunStop)
    }
}