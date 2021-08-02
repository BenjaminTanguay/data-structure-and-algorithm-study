package com.btanguay

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    plugin = [
        "com.btanguay.core.cucumber.CucumberFeatureLogger",
        "json:target/report.json",
        "html:target/cucumber-html",
        "de.monochromata.cucumber.report.PrettyReports:build/cucumber"]
)
class RunCucumberTest {
}