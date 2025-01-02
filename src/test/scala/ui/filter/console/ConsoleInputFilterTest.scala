package ui.filter.console

import org.scalatest.funsuite.AnyFunSuite


class ConsoleInputFilterTest extends AnyFunSuite {

  test("filter should remove patterns from input string") {
    val filter = new ConsoleInputFilter(Seq("pattern1", "pattern2"))
    val input = "This is pattern1 and pattern2 in the input."
    val result = filter.filter(input)
    assert(result == "This is  and  in the input.")
  }

  test("No patterns test") {
    val filter = new ConsoleInputFilter(Seq("pattern1", "pattern2"))
    val input = "No patterns here."
    val result = filter.filter(input)
    assert(result == "No patterns here.")
  }

  test("filterSplitter should handle multiple lines and patterns correctly") {
    val input = Seq("pattern1 test line", "another pattern2 test")
    val patterns = Seq("pattern1", "pattern2")
    val result = ConsoleInputFilter.filterSplitter(patterns, input)
    assert(result == Seq(("pattern1", "test line"), ("pattern2", "another  test")))
  }

  test("filterSplitter should handle empty input") {
    val input = Seq("")
    val patterns = Seq("pattern1", "pattern2")
    val result = ConsoleInputFilter.filterSplitter(patterns, input)
    assert(result == Seq(("", "")))
  }
}
