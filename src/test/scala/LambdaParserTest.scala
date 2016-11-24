import org.junit.{Assert, Test}

/**
  * Created by AhmedMetwally on 11/21/16.
  */
class LambdaParserTest extends Assert {

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
          assert(expected_output == parsedLambda.toString)
        }
    }
      println("Passed Parser Test ...")
  }
}
