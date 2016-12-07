import AssemblyKeys._ // put this at the top of the file

assemblySettings

jarName in assembly := "kafka-assembly.jar"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
}
