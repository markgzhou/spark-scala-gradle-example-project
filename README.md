# spark-java-example-for-databricks

[![Build Status](https://travis-ci.org/markgzhou/spark-scala-gradle-example-project.svg?branch=master)](https://travis-ci.org/markgzhou/spark-scala-gradle-example-project)

A simple example for testing Apache Spark working correctly

Run `./gradlew clean sJ` to build jar file

To test local spark, run `spark-submit --class "com.examples.GetStarted" --master local[2] build/libs/spark-java-example-for-databricks-shadow.jar /tmp/test_output`
