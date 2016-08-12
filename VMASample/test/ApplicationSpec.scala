import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

class ApplicantSpec extends Specification {
  
    import models._

   "Applicant model" should {
     "be retrived by id" in {
       running(FakeApplication()){
         var Some(candidate) = Applicant.findById(1)
         candidate.referenceNo must equalTo("JIT012")
       }
       }
     }
    
    "filter applicants by name" in {
      running(FakeApplication()) {
        
        val result = controllers.Application.list(0, 2, "Velma")(FakeRequest())

        status(result) must equalTo(OK)
        contentAsString(result) must contain("Pope")
        
      }      
    }
    
   }

