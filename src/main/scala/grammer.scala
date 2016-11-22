/**
  * Created by hady on 11/20/16.
  */
//class grammer {
//
//type P[+T] = PackratParser[T]
//lazy val expr: P[Expr]         = lambda | application | variable | parens
//lazy val lambda: P[Lambda]     = "λ" ~> variable ~ "." ~ expr ^^
//  { case v ~ "." ~ e  => Lambda(v, e) }
//lazy val application: P[Apply] = expr ~ expr ^^
//  { case left ~ right => Apply(left, right) }
//lazy val variable: P[Var]      = ident ^^ Var
//lazy val parens: P[Expr]       = "(" ~> expr <~ ")"
//}
