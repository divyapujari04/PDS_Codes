import scala.collection.immutable.List

object JDoodle {

  // Main program execution
  def main(args: Array[String]): Unit = {
    val numbers: List[Int] = (1 to 10).toList

    // Display input dataset
    println("Original Dataset: " + numbers)

    // Filter even numbers
    val evenNumbers: List[Int] = numbers.filter(n => n % 2 == 0)
    println("Even Numbers: " + evenNumbers)

    // Multiply by three
    val tripledNumbers: List[Int] = numbers.map(n => n * 3)
    println("Tripled Numbers: " + tripledNumbers)

    // Pair numbers with squares
    val squaredTuples: List[(Int, Int)] =
      numbers.flatMap(n => List((n, n * n)))
    println("Number-Square Tuples: " + squaredTuples)

    // Calculate product
    val product: Int = numbers.foldLeft(1)((acc, n) => acc * n)
    println("Product of All Elements: " + product)
  }
}
