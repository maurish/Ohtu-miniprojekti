import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Localized messages throughout product'
def init(){
    driver = new HtmlUnitDriver()
    driver.get("http://localhost:8090/")
}
scenario 'default locale is finnish',{
    given 'Default page is loaded',{
        init()
    }
    when '',{}
    then 'Welcome message should be in finnish',{
        driver.getPageSource().contains("Tervetuloa").shouldBe true
        driver.getPageSource().contains("Welcome").shouldBe false
    }
}

scenario 'after changing locale to en messages should be in english',{
    given 'Default page is loaded',{
        init()
    }
    when 'change locale through url',{
        driver.get("http://localhost:8090/app/list?locale=en")
    }
    then 'Welcome message should be in english',{
        driver.getPageSource().contains("Tervetuloa").shouldBe false
        driver.getPageSource().contains("Welcome").shouldBe true
    }
}
scenario 'after changing locale to sv messages should be in swedish',{
    given 'Default page is loaded',{
        init()
    }
    when 'change locale through url',{
        driver.get("http://localhost:8090/app/list?locale=sv")
    }
    then 'Welcome message should be in swedish',{
        driver.getPageSource().contains("Tervetuloa").shouldBe false
        driver.getPageSource().contains("Välkommen").shouldBe true
    }
}