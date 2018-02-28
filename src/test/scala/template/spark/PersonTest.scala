package template.spark

import org.scalatest._
import org.slf4j.LoggerFactory

class PersonTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  val log = LoggerFactory.getLogger(classOf[PersonTest])

  override def beforeEach() {
    log.debug("Setting up tests")
  }

  "First name" should "be set during init" in {
    log.info("Testing First Name")
    val p = Person("John", "Smith", "USA", 100)
    p.firstName should be ("John")
  }

}
