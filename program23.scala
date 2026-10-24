import org.saddle._
import org.saddle.io._
import vegas._
import java.nio.file.{Files, Paths}

object Main {

  // Define a case class to store fruit dataset records
  case class FruitRecord(
    date: String,
    fruit: String,
    price: Double,
    quantity: Int
  )

  def main(args: Array[String]): Unit = {

    // Create the fruit dataset
    val dataset = List(
      FruitRecord("2026-01-01", "Apple", 120.0, 10),
      FruitRecord("2026-01-01", "Banana", 40.0, 20),
      FruitRecord("2026-01-02", "Apple", 125.0, 12),
      FruitRecord("2026-01-02", "Mango", 100.0, 8),
      FruitRecord("2026-01-03", "Apple", 115.0, 15),
      FruitRecord("2026-01-03", "Banana", 45.0, 18),
      FruitRecord("2026-01-04", "Apple", 130.0, 9),
      FruitRecord("2026-01-04", "Orange", 60.0, 14),
      FruitRecord("2026-01-05", "Apple", 128.0, 11),
      FruitRecord("2026-01-05", "Mango", 110.0, 7)
    )

    // Print the complete dataset with column headings
    println("Original Dataset:")
    println(f"${"Date"}%-12s ${"Fruit"}%-10s ${"Price"}%8s ${"Quantity"}%10s")

    dataset.foreach { record =>
      println(f"${record.date}%-12s ${record.fruit}%-10s ${record.price}%8.2f ${record.quantity}%10d")
    }

    // Filter the dataset to select only Apple records
    val apples = dataset.filter(_.fruit == "Apple")

    // Print the filtered Apple records
    println("\nApple Records:")
    apples.foreach { record =>
      println(f"${record.date}%-12s ${record.price}%8.2f ${record.quantity}%10d")
    }

    // Extract the prices of all Apple records
    val prices = apples.map(_.price)

    // Calculate the average, minimum, and maximum Apple prices
    val average = prices.sum / prices.size
    val minimum = prices.min
    val maximum = prices.max

    // Display the calculated statistics
    println("\nNumber of Apple records: " + apples.size)
    println(f"Average Apple price: Rs. $average%.2f per kg")
    println(f"Minimum Apple price: Rs. $minimum%.2f")
    println(f"Maximum Apple price: Rs. $maximum%.2f")

    // Print the data points for the Apple price trend
    println("\nApple Price Trend Data:")
    apples.foreach { record =>
      println(record.date + " -> Rs. " + record.price)
    }
  }
}
