import scala.collection.immutable.List
import scala.collection.immutable.Map

object JDoodle {

  // Define Person class
  case class Person(name: String, age: Int, city: String)

  // Filter older people
  def filterPeople(people: List[Person]): List[Person] = {
    people.filter(_.age > 30)
  }

  // Group people by city
  def groupByCity(people: List[Person]): Map[String, List[Person]] = {
    people.groupBy(_.city)
  }

  // Convert people to strings
  def formatPeople(people: List[Person]): List[String] = {
    people.map(p => s"${p.name} is ${p.age} years old and lives in ${p.city}")
  }

  // Sort people by age
  def sortByAge(people: List[Person]): List[Person] = {
    people.sortBy(_.age)
  }

  // Main program execution
  def main(args: Array[String]): Unit = {
    val people: List[Person] = List(
      Person("Alice", 25, "Chennai"),
      Person("Bob", 35, "Mumbai"),
      Person("Charlie", 28, "Chennai"),
      Person("David", 42, "Delhi"),
      Person("Emma", 32, "Mumbai")
    )

    // Display input dataset
    println("Original Dataset: " + people)

    // Display filtered people
    println("People Older Than 30: " + filterPeople(people))

    // Display city groups
    println("People Grouped By City: " + groupByCity(people))

    // Display formatted strings
    println("Formatted People:")
    formatPeople(people).foreach(println)

    // Display sorted people
    println("People Sorted By Age: " + sortByAge(people))
  }
}
