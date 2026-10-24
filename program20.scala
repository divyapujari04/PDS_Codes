import scala.collection.mutable

object JDoodle {

  // Merge student maps
  def mergeHashMaps(
    map1: mutable.HashMap[String, Int],
    map2: mutable.HashMap[String, Int]
  ): mutable.HashMap[String, Int] = {
    val merged = mutable.HashMap[String, Int]()
    merged ++= map1

    map2.foreach { case (name, grade) =>
      merged(name) = math.max(merged.getOrElse(name, grade), grade)
    }

    merged
  }

  // Handle chained collisions
  def addToChain(
    chains: mutable.HashMap[Int, List[String]],
    key: Int,
    value: String
  ): Unit = {
    chains(key) = chains.getOrElse(key, List()) :+ value
  }

  // Main program execution
  def main(args: Array[String]): Unit = {

    // Create student datasets
    val studentEntries = List(
      ("Alice", 85),
      ("Bob", 78),
      ("Charlie", 92),
      ("Alice", 95),
      ("David", 88)
    )

    val students = mutable.HashMap[String, Int]()

    // Display original dataset
    println("Original Student Dataset: " + studentEntries)

    // Insert student grades
    studentEntries.foreach { case (name, grade) =>
      students.put(name, grade)
    }

    val secondStudents = mutable.HashMap(
      "Alice" -> 90,
      "Bob" -> 82,
      "Eve" -> 89,
      "Frank" -> 76
    )

    // Display input datasets
    println("First Student HashMap: " + students.toList.sortBy(_._1))
    println("Second Student Dataset: " + secondStudents.toList.sortBy(_._1))

    // Merge student grades
    val merged = mergeHashMaps(students, secondStudents)
    println("Merged Student Dataset: " + merged.toList.sortBy(_._1))

    // Create collision dataset
    val chainEntries = List(
      (1, "Apple"),
      (1, "Apricot"),
      (2, "Banana"),
      (2, "Blueberry"),
      (3, "Cherry")
    )

    val chains = mutable.HashMap[Int, List[String]]()

    // Display original collision dataset
    println("Original Chaining Dataset: " + chainEntries)

    // Add chained entries
    chainEntries.foreach { case (key, value) =>
      addToChain(chains, key, value)
    }

    // Display chained dataset
    println("Chaining Result: " + chains.toList.sortBy(_._1))
  }
}
