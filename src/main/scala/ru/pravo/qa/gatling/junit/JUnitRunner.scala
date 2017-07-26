package ru.pravo.qa.gatling.junit

import io.gatling.app.Gatling
import io.gatling.core.Predef.Simulation
import io.gatling.core.config.GatlingPropertiesBuilder
import org.junit.runner.Description
import org.junit.runner.notification.{Failure, RunNotifier}

final class JUnitRunner(simulationClass: java.lang.Class[_ <: Simulation]) extends org.junit.runner.Runner {

  val getDescription: Description = Description.createSuiteDescription(s"${simulationClass.getCanonicalName}(Gatling)")

  def run(notifier: RunNotifier): Unit = {
    try {
      notifier.fireTestStarted(getDescription)
      val properties = new GatlingPropertiesBuilder
      properties.simulationClass(simulationClass.getCanonicalName)
      properties.noReports()
      val resultCode = Gatling.fromMap(properties.build)
      if(resultCode == 0) {
        notifier.fireTestFinished(getDescription)
      } else {
        notifier.fireTestFailure(new Failure(getDescription, new Exception(s"Simulation ended with result code $resultCode")))
        notifier.fireTestFinished(getDescription)
      }
    } catch {
      case e: Exception =>
        notifier.fireTestFailure(new Failure(getDescription, e))
        notifier.fireTestFinished(getDescription)
    }
  }
}
