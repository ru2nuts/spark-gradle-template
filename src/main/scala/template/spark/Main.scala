package template.spark

import java.io.InputStream

import org.apache.spark.sql.functions._

final case class Person(firstName: String, lastName: String,
                        country: String, age: Int)

object Main extends InitSpark {
  def main(args: Array[String]) = {
    import spark.implicits._

    val version = spark.version
    println("SPARK VERSION = " + version)

    val sumHundred = spark.range(1, 101).reduce(_ + _)
    println(f"Sum 1 to 100 = $sumHundred")

    println("Reading from csv file: people-example.csv")

    val persons = reader.csv(Main.getClass.getResource("/people-example.csv").getPath).as[Person]
    persons.show(2)
    val averageAge = persons.agg(avg("age"))
                     .first.get(0).asInstanceOf[Double]
    println(f"Average Age: $averageAge%.2f")

    close
  }
}
