import scala.util.parsing.combinator.syntactical.StdTokenParsers
import scala.util.parsing.combinator.PackratParsers

/// define Expr as sealed trait, so that it gives an error if it is not one of it's cases
sealed trait Expr
//L-> stands for lambda, V -> stands for variable, A ->  stands for application
case class L(arg: V, body: Expr) extends Expr
case class V(name: String) extends Expr
case class A(fun: Expr, arg: Expr) extends Expr


class LambdaParser extends StdTokenParsers with PackratParsers{
  /// Use Packrat Parser to substitute and eliminate the lambda expression from the left.
  type P[+T] = PackratParser[T]
  lazy val expr: P[Expr]         = lambda | application | variable | parens
  lazy val lambda: P[L]     = "λ" ~> variable ~ "." ~ expr ^^
    { case v ~ "." ~ e  => L(v, e) }
  lazy val application: P[A] = expr ~ expr ^^
    { case left ~ right => A(left, right) }
  lazy val variable: P[V]      = ident ^^ V
  lazy val parens: P[Expr]       = "(" ~> expr <~ ")"

  /// Define the delimieter of the lambda expression
  type Tokens = LambdaLexer
  val lexical = new LambdaLexer
  lexical.delimiters ++= Seq("λ", ".", "(", ")")


  /// Parse the Lambda expression.
  def parse(input: String): ParseResult[Expr] = {
    val tokens = new lexical.Scanner(input)
    println("Parse Func. tokens = " +  tokens)
    phrase(expr)(tokens)
  }
}



//  type P[+T] = PackratParser[T]
//  lazy val expr: P[Expr]         = lambda | application | variable | parens
//  lazy val lambda: P[Lambda]     = "λ" ~> variable ~ "." ~ expr ^^
//    { case v ~ "." ~ e  => Lambda(v, e) }
//  lazy val application: P[Apply] = expr ~ expr ^^
//    { case left ~ right => Apply(left, right) }
//  lazy val variable: P[Var]      = ident ^^ Var.apply
//  lazy val parens: P[Expr]       = "(" ~> expr <~ ")"
