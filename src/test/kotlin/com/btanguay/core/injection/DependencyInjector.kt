package com.btanguay.core.injection

import com.btanguay.core.log.logger
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Stage
import io.cucumber.guice.CucumberModules
import io.cucumber.guice.InjectorSource

class DependencyInjector: InjectorSource {

    private val log = logger()


    override fun getInjector(): Injector {
        val mainModule = MainModule()
        return Guice.createInjector(
            Stage.PRODUCTION, CucumberModules.createScenarioModule(), mainModule
        )
    }
}