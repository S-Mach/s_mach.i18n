name := "i18n"

// Turn these off in Test for tests that need to eval code
scalacOptions in Test ~= (_ filterNot {
  case "-Xlint" | "-Ywarn-unused" => true
  case _ => false
})

libraryDependencies ++= Seq(
  "net.s_mach" %% "codetools" % "2.1.0",
  "net.s_mach" %% "string" % "2.1.0"
)
