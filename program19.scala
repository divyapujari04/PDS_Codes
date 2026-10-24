object JDoodle {
// Square each element
  def squareNumbers(numbers: List[Int]): List[Int] = {
    numbers.map(n => n * n)
  }
// Find set intersection
  def findIntersection(set1: Set[Char], set2: Set[Char]): Set[Char] = {
    set1.intersect(set2)
  }
// Main program execution
  def main(args: Array[String]): Unit = {
    val primes = List(2, 3, 5, 7, 11)
    val characters = "hello world".toSet
    val otherCharacters = Set('h', 'e', 'l', 'd', 'a')
    val details = (25, "Scala", true)
// Display input datasets
  println("Prime Numbers Dataset: " + primes)
  println("Character Dataset: " + characters)
  println("Second Set Dataset: " + otherCharacters)
  println("Tuple Dataset: " + details)
// Display squared numbers
  println("Squared Numbers: " + squareNumbers(primes))
// Display common characters
  println("Intersection: " + findIntersection(characters, otherCharacters))
// Display tuple elements
  println("Integer: " + details._1)
  println("String: " + details._2)
  println("Boolean: " + details._3)
   }
}
