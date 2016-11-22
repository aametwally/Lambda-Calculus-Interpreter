/**
  * Created by AhmedMetwally on 11/19/16.
  */


//import scala.util.parsing.combinator.PackratParser
import scala.util.parsing.combinator.syntactical.StdTokenParsers
import scala.util.parsing.combinator.lexical.StdLexical

object Main{
  def main(args: Array[String]) {

    var lmbdaExpr : String = scala.io.StdIn.readLine("Enter the lambda expression > ")
    println("Lambda Expression = " + lmbdaExpr)

    val prs = new LambdaParser()
    import prs.{Success, NoSuccess}

//    var lmbdaExpr : String = "λx.x t"
    prs.parse(lmbdaExpr) match {
      case Success(expr, _)
      => println("Parsed Expression =  " + expr)
      case err: NoSuccess
      => println("Ops! you got Error " + err)
    }
  }
}