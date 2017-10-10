name := "gatling-junitrunner"
organization := "ru.pravo"
sonatypeProfileName := organization.value
version := "2.3.0.0"
scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "io.gatling"            % "gatling-test-framework"    % "2.3.0",
  "junit"                 % "junit"                     % "4.12",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0"
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

publishMavenStyle := true

pomExtra in Global := {
  <url>https://github.com/Pravoru/gatling-junitrunner</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://opensource.org/licenses/MIT</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git@github.com:Pravoru/gatling-junitrunner.git</connection>
      <developerConnection>scm:git:git@github.com:Pravoru/gatling-junitrunner.git</developerConnection>
      <url>github.com/Pravoru/gatling-junitrunner</url>
    </scm>
    <developers>
      <developer>
        <id>elufimov</id>
        <name>Michael Elufimov</name>
        <url>https://github.com/Elufimov</url>
      </developer>
    </developers>
}

enablePlugins(GatlingPlugin)