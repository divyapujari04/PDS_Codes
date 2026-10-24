import breeze.linalg._
import plotly._, element._, layout._, Plotly._
import scala.io.Source

object Program24_BreezePlotly {

  def main(args: Array[String]): Unit = {

    val src = Source.fromFile("fruit_prices.csv")
    val records = src.getLines().drop(1).map(_.split(",")).toArray
    src.close()

    val fruit = records.map(_(1))
    println("Records loaded : " + records.length)

    val price = DenseVector(records.map(_(2).toDouble))
    val qty = DenseVector(records.map(_(3).toDouble))

    println("Price vector (first 5) : " +
      price(0 until 5).toArray.map(p => f"$p%.2f").mkString(", "))

    println("Quantity vector (first 5) : " +
      qty(0 until 5).toArray.map(q => f"$q%.0f").mkString(", "))

    val revenue = price *:* qty

    println("Revenue vector (first 5) : " +
      revenue(0 until 5).toArray.map(r => f"$r%.2f").mkString(", "))

    val fruitTypes = fruit.distinct.sorted

    val totals = fruitTypes.map { f =>
      val mask = DenseVector(fruit.map(x => if (x == f) 1.0 else 0.0))
      revenue dot mask
    }

    println("\nTotal Revenue by Fruit Type:")
    println(f"${"Fruit"}%-8s ${"Total Revenue (Rs.)"}%20s")

    fruitTypes.zip(totals).foreach {
      case (f, t) => println(f"$f%-8s $t%20.2f")
    }

    println(f"\nOverall revenue (price dot quantity) : Rs. ${price dot qty}%.2f")

    println("Highest revenue fruit : " +
      fruitTypes(totals.indexOf(totals.max)))

    val bar = Bar(fruitTypes.toSeq, totals.toSeq)
      .withName("Total Revenue")
      .withText(totals.toSeq.map(t => f"Rs. $t%.0f"))

    Seq(bar).plot(
      "fruit_revenue.html",
      Layout()
        .withTitle("Total Revenue by Fruit Type")
        .withXaxis(Axis().withTitle("Fruit"))
        .withYaxis(Axis().withTitle("Total Revenue (Rs.)")),
      openInBrowser = false
    )

    println("\nInteractive Plotly chart saved as fruit_revenue.html")
  }
}
