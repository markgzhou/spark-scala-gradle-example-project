package com.examples;

import org.apache.log4j.{Level, LogManager, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row
import org.apache.spark.rdd.RDD


// define main method (Spark entry point)
object GetStarted {
  def main(args: Array[String]) {

    // initialise spark context
    val conf = new SparkConf().setAppName(GetStarted.getClass.getName)
    val spark: SparkSession = SparkSession.builder.config(conf).getOrCreate()
    val sc: SparkContext = spark.sparkContext

    // Change Logging level
    sc.setLogLevel("ERROR")
    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("akka").setLevel(Level.ERROR)
    LogManager.getRootLogger.setLevel(Level.ERROR)

    // print Hello World
    println("Hello, world!")

    // generate rdd
    val rdd = sc.parallelize(Array(1 to 10))
    rdd.count()

    // generate DataFrame with schema
    val rowsRdd: RDD[Row] = sc.parallelize(
      Seq(
        Row("first", 2.0, 7.0),
        Row("second", 3.5, 2.5),
        Row("third", 7.0, 5.9)
      )
    )

    val schema = new StructType()
      .add(StructField("id", StringType, true))
      .add(StructField("val1", DoubleType, true))
      .add(StructField("val2", DoubleType, true))

    val df = spark.createDataFrame(rowsRdd, schema)

    // parse
    var doWrite = false
    args.foreach{ s:String =>
        if(s=="output") {
            doWrite = true
            println("Specified to write out")
        }
    }

    if(doWrite){
        var filePath = "/tmp/output"
        if (args.length > 0) {
            filePath = args(args.length-1)
            println("Specified output path:" + filePath)
        }

        df.coalesce(1)
          .write.format("com.databricks.spark.csv")
          .option("header", "true")
          .save(filePath)
    }

    // terminate spark context
    spark.stop()

  }
}