/**
  * Created by hady on 11/20/16.
  */

//sealed trait Expr
//case class Lambda(arg: Var, body: Expr) extends Expr
//case class Var(name: String) extends Expr
//case class Apply(fun: Expr, arg: Expr) extends Expr
//

//class PrettyPrinter {
//  def apply(expr: Expr): String = expr match {
//    case Lambda(arg, body) => p"λ$arg.$body"
//    case Apply(fun, arg)   => p"$fun $arg"
////    case Var(name,scope)         => s"$name${scope.id}"
//    case Var(name)         => s"$name"
//  }
//
//  implicit class PrettyPrinting(val sc: StringContext) {
//    def p(args: Expr*) = sc.s((args map parensIfNeeded):_*)
//  }
//
//  def parensIfNeeded(expr: Expr) = expr match {
////    case Var(name,scope) => name
//      case Var(name) => name
//    case _         => "(" + apply(expr) + ")"
//  }
//
//}

