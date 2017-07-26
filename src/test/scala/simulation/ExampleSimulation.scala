package simulation

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
