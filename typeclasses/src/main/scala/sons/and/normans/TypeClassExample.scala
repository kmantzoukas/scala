package sons.and.normans

import WithDefaultValue.{WithDefaultValuesOpts, _}

object TypeClassExample  {

  def main(args: Array[String]): Unit = {

    val name: Option[String] = Some("Micheal")
    val middle: Option[String] = None
    val surname: Option[String] = Some("Jordan")
    val salary: Option[Double] = None
    val isAdult: Option[Boolean] = None

    println(Person(
      name = name.orDefault,
      middle = middle.orDefault,
      surname = surname.orDefault,
      salary = salary.orDefault,
      isAdult = isAdult.orDefault
    ))


  }
}