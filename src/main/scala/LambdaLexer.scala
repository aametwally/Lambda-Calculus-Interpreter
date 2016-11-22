/**
  * Created by hady on 11/20/16.
  */
import scala.util.parsing.combinator.lexical.StdLexical


class LambdaLexer extends StdLexical {
  override def letter = elem("letter", c => c.isLetter && c != 'λ')
}