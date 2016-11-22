import scala.util.parsing.combinator.syntactical.StdTokenParsers
import scala.util.parsing.combinator.PackratParsers


class LambdaParser extends StdTokenParsers with PackratParsers{
  /// Use Packrat Parser to substitute and eliminate the lambda expression from the left.
  type P[+T] = PackratParser[T]
  lazy val expr: P[LambdaExpr]         = lambda | application | variable | parens
  lazy val lambda: P[L]     = "λ" ~> variable ~ "." ~ expr ^^
    { case v ~ "." ~ e  => L(v, e) }
  lazy val application: P[A] = expr ~ expr ^^
    { case left ~ right => A(left, right) }
  lazy val variable: P[V]      = ident ^^ V
  lazy val parens: P[LambdaExpr]       = "(" ~> expr <~ ")"

  /// Define the delimiters of the lambda expression
  type Tokens = LambdaLexer
  val lexical = new LambdaLexer
  lexical.delimiters ++= Seq("λ", ".", "(", ")")


  /// Parse the Lambda expression.
  def parse(input: String): ParseResult[LambdaExpr] = {
    val tokens = new lexical.Scanner(input)
    println("Parse Func. tokens = " +  tokens)
    phrase(expr)(tokens)
  }
}