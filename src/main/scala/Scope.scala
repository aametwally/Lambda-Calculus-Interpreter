/**
  * Created by hady on 11/20/16.
  */
//object Scope {
//  var id = 0
//  def nextId = { val i = id; id += 1; i }
//  val TOP = new Scope(None, Set())
//}
//
//
//class Scope(val parent: Option[Scope], val boundNames: Set[String]) {
//  val id = Scope.nextId
//
//  def closestBinding(name: String): Option[Scope] =
//    if (boundNames contains name)
//      Some(this)
//    else
//      parent flatMap (_ closestBinding name)
//}
