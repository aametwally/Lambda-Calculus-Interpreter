/**
  * Created by hady on 11/21/16.
  */

/// define Expr as sealed trait, so that it gives an error if it is not one of it's cases
sealed trait LambdaExpr
//L-> stands for lambda, V -> stands for variable, A ->  stands for application
case class L(arg: V, body: LambdaExpr) extends LambdaExpr
case class V(name: String) extends LambdaExpr
case class A(fun: LambdaExpr, arg: LambdaExpr) extends LambdaExpr