package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers.{status, _}

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {
  "WelcomeController GET" should {
    "return a successful response" in {
      val controller = new WelcomeController
      val result = controller.welcome.apply(FakeRequest())
    status(result) mustBe OK
    }

    "respond to the /welcome url" in {
      val request = FakeRequest(GET, "/welcome").withHeaders("Host" -> "localHost")
      val home = route(app, request).get
      status(home) mustBe OK
    }

    "return some html" in {
      val controller = new WelcomeController
      val result = controller.welcome.apply(FakeRequest())
      contentType(result) mustBe Some("text/html")
    }

//    "have a welcome message and have some content" in {
//      val controller = new WelcomeController
//      val result = controller.welcome.apply
    }
  }
}
