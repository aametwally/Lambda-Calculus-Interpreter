import org.junit.Test

/**
  * Created by AhmedMetwally on 11/21/16.
  */
class LambdaParserTest extends org.scalatest.FunSuite {

  @Test
  def testParser {
    var lmbdaExpr : String = "(λx.x) t"
    var expected_output = "A(L(V(x),V(x)),V(t))"
    val prs = new LambdaParser()
    import prs.{Success}
    var e = prs.parse(lmbdaExpr)

    e match {
      case Success(parsedLambda, _) =>
        {
//          println("Parsed Expression =  " + parsedLambda)
          assert(expected_output == parsedLambda.toString)
//          println("class name = " + e.getClass.getName())
        }
    }
      println("Passed Test Parser...")
  }
}
