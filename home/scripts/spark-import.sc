import $ivy.{
  `org.apache.spark::spark-core:2.4.4`,
  `org.apache.spark::spark-sql:2.4.4`,
  `org.apache.spark::spark-hive:2.4.4`,
  `org.apache.spark::spark-yarn:2.4.4`,
  `org.apache.spark::spark-mllib:2.4.4`
}
import org.apache.spark._
import org.apache.spark.sql._
import ammonite.ops._

val spark =
  SparkSession.builder
    .master("local[*]")
    .appName("ammonite-local")
    .getOrCreate

def sc = spark.sparkContext
