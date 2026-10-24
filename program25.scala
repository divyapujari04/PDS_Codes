import org.saddle._
import spire.implicits._
import vegas._
import vegas.spec.Spec

object JDoodle {
  def main(args: Array[String]): Unit = {

    val dates = Vec(
      "2026-01-01", "2026-01-02", "2026-01-03",
      "2026-01-04", "2026-01-05", "2026-01-06", "2026-01-07"
    )

    val names = Vec(
      "Apple", "Banana", "Apple", "Banana",
      "Apple", "Orange", "Orange"
    )

    val prices = Vec(120.0, 60.0, 130.0, 70.0, 140.0, 90.0, 100.0)

    val fruitData = Frame(
      "Date" -> dates,
      "Fruit" -> names,
      "Price" -> prices
    )

    println("Original Fruit Dataset:")
    println(fruitData)

    val grouped = names.toSeq.distinct.sorted

    println("\nMean and Variance By Fruit:")

    grouped.foreach { fruit =>
      val fruitPrices = names.toSeq.zip(prices.toSeq)
        .collect { case (name, price) if name == fruit => price }

      val mean = fruitPrices.sum / fruitPrices.size

      val variance = fruitPrices.map(p => math.pow(p - mean, 2)).sum /
        fruitPrices.size

      println(fruit + " | Mean: " + mean + " | Variance: " + variance)
    }

    val chartData = dates.toSeq.zip(names.toSeq).zip(prices.toSeq).collect {
      case ((date, "Apple"), price) =>
        Map("Date" -> date, "Price" -> price)
    }

    val chart = Vegas("Apple Price Trend Over Time")
      .withData(chartData)
      .encodeX("Date", Nom)
      .encodeY("Price", Quant)
      .mark(Line)

    chart.show
  }
}
