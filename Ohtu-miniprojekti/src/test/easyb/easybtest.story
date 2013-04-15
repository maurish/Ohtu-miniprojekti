import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'EasyBTesting'

scenario "user can login with correct password", {
    given 'given stuff', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
    }

    when 'when stuff', {
    }
 
    then 'then stuff', {
        driver.getPageSource().contains("References").shouldBe true
    }
}
