package sons.and.normans

// Interface i.e. what do we want to expose to the client code
trait WithDefaultValue[T] {
  def default(value: Option[T]): T
}

object WithDefaultValue {

  /*
  Implementations of the base interface/trait defined as implicits i.e. they can be implicitly
  passed from the compiler to functions/object constructors as required
   */
  implicit val stringWithDefaultValue: WithDefaultValue[String] = (_: Option[String]) => "N/A"
  implicit val intDefaultValue: WithDefaultValue[Integer] = (_: Option[Integer]) => 0
  implicit val floatDefaultValue: WithDefaultValue[Float] = (_: Option[Float]) => 0.0f
  implicit val doubleDefaultValue: WithDefaultValue[Double] = (_: Option[Double]) => 0.0d
  implicit val defaultBoolean: WithDefaultValue[Boolean] = (_: Option[Boolean]) => false

  /*
  Here is where the magic happens. An Ops class defined as implicit i.e. it's constructor can
  be used to take an Option of type T, for which the we have an implementation of WithDefaultValue
  and augment it with additional functionality. In our case with a orDefault() function that either
  returns the value wrapped in the option if it is not empty or a default value if it is empty
   */
  implicit class WithDefaultValuesOpts[T](value: Option[T])(implicit evidence: WithDefaultValue[T]) {
    def orDefault: T = value match {
      case Some(value) => value
      case None => evidence.default(value)
    }
  }
}