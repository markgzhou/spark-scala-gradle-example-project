# spark-java-example-for-databricks

A simple example for testing Apache Spark working correctly

Run `./gradlew clean sJ` to build jar file

To test local spark, run `spark-submit --class "com.examples.GetStarted" --master local[2] build/libs/spark-java-example-for-databricks-shadow.jar /tmp/test_output`
