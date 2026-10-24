object JDoodle {
// Calculate integer sum
  def calculateSum(arr: List[Int]): Int = {
    arr.sum
  }
// Join fruit names
  def concatenateFruits(arr: List[String]): String = {
    arr.mkString(", ")
  }
// Main program execution
  def main(args: Array[String]): Unit = {
    val numbers = List(2, 5, 9, 14, 20) // Integer list
    val fruits = List("Apple", "Banana", "Mango", "Orange", "Grapes") //
Fruit list
  println("Integer Dataset: " + numbers) // Display integers
  println("Fruit Dataset: " + fruits) // Display fruits
  println("Sum of integers: " + calculateSum(numbers)) // Print sum
  println("Concatenated fruits: " + concatenateFruits(fruits)) // Print
fruits
  println("Integer array elements:") // Display heading
  for (num <- numbers) { // Iterate through integers
    println(num) // Print each integer
    }
  }
}
