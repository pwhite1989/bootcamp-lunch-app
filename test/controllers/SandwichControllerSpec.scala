package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class SandwichControllerSpec extends PlaySpec with GuiceOneAppPerTest {
  "SandwichController" should {
    "inform the user we've run out of sandwiches when there are no sandwiches left" in {
      val request = FakeRequest(GET, "/sandwiches").withHeaders("Host" -> "localHost")
      val home = route(app, request).get
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("<title>Sandwiches</title>")
      contentAsString(home) must include("<h1>Have a look at today's sandwiches</h1>")
      contentAsString(home) must include("<p>Sorry, we're sold out</p>")

    }
    "Have some basic information and be accessible at the correct route" in {
      val request = FakeRequest(GET, "/sandwiches").withHeaders("Host" -> "localHost")
      val home = route(app, request).get
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("<title>Sandwiches</title>")
      contentAsString(home) must include("<h1>Have a look at today's sandwiches</h1>")
    }

    "Give a helpful message when sold out" in {
      val request = FakeRequest(GET, "/sandwiches")
      val result = route(app, request).get
      contentAsString(result)

    }
    
  }
}
