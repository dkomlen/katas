// KataMinesweeper: http://codingdojo.org/kata/Minesweeper

import scala.collection.Iterator.continually

object Minesweeper {
  def main(args: Array[String]): Unit = {
    continually(readLine.split(" ").map(_.toInt))
      .takeWhile(x => x(0) != 0 && x(1) != 0).zipWithIndex
      .foreach { case (Array(m,n), o) =>
        val f = for (i <- 1 to m) yield readLine
        def c(i:Int, j:Int) = (for (a <- -1 to 1; b <- -1 to 1 if (i + a >= 0 && i + a < m && j + b >= 0 && j + b < n)) yield if (f(i+a)(j+b) == '*') 1 else 0).sum
        println(s"\nField #${o+1}:")
        println((for (i <- 0 until m) yield { for(j <- 0 until n) yield if (f(i)(j) == '*') "*" else "" + c(i,j) }.mkString).mkString("\n"))
      }
  }
}