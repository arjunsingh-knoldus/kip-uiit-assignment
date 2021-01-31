name := "utit-assignment"
scalaVersion := "2.12.12"
parallelExecution in Test := false

// Dependecies
val sharedDependencies = Seq(
    // test dependecies
    "org.scalatest" %% "scalatest" % "3.1.1" % Test,
    "org.mockito" %% "mockito-scala" % "1.5.12" % Test
)


// Modules
lazy val one = project.in(file("part-one" ))
                .settings( libraryDependencies ++= sharedDependencies)

lazy val two = project.in(file("part-two"))
                .settings( libraryDependencies ++= sharedDependencies)


lazy val root = project.in(file(".")).aggregate(one, two) 

