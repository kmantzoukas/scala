package sons.and.normans

class HelloSpec extends munit.FunSuite {
  test("say hello") {
    assertEquals(TypeClassExample.greeting, "hello")
  }
}
