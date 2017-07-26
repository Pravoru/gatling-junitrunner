# JUnit wrapper around Gatling simulations

## Goal

Gatling do not has an ability to be run as normal unit test. Gatling team has its reasons for this, however we need to debug simulation before running it under heavy load.

## Instalation

`build.sbt`
```scala
libraryDependencies += "ru.pravo" %% "gatling-junitrunner" % "0.1"
```

## Using

Just add `@RunWith(classOf[JUnitRunner])` annotation to your simulation classes.

```scala
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.junit.runner.RunWith
import ru.pravo.qa.gatling.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExampleSimulation extends Simulation {
  val httpConf = http
    .baseURL("http://google.com")

  val scn = scenario("Positive Scenario")
    .exec(
      http("request_1").get("/")
    )

  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}
```

