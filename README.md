# Spark-Scala-Example-Project

[![Build Status](https://travis-ci.org/markgzhou/spark-scala-gradle-example-project.svg?branch=master)](https://travis-ci.org/markgzhou/spark-scala-gradle-example-project)

A simple Scala project that you can build and run in Spark immediately.

Here are the steps to run:

Run `./gradlew clean sJ` to build jar file.

To test local spark, run `spark-submit --class "com.examples.GetStarted" --master local[2] build/libs/spark-java-example-for-databricks-shadow.jar /tmp/test_output`
