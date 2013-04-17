import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'Navigating through pages should yield the right results'

scenario "user sees the correct front page", {
    given 'given prepairing to enter site url', {
        driver = new HtmlUnitDriver()  
    }

    when 'frontpage url is entered', {
        driver.get("http://localhost:8090/")
    }
 
    then 'front page will be visible', {
        driver.getPageSource().contains("Listing of all References").shouldBe true
    }
}

scenario "user sees the reference adding page", {
    given 'user enters frontpage url', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
    }

    when 'user navigates to adding page', {
        element = driver.findElement(By.linkText("Lisää lähde"))
        element.click()
    }
    
    then 'reference add page will be visible', {
        driver.getPageSource().contains("Tässä lisätään lähteitä, huraa!").shouldBe true
    }
}

scenario "user sees the bibtex listing page", {
    given 'user enters frontpage url', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
    }

    when 'user navigates to bibtex page', {
        element = driver.findElement(By.linkText("Listaa kaikki bibtexinä"))
        element.click()
    }
    
    then 'reference add page will be visible', {
        driver.getPageSource().contains("Hello Bibtex").shouldBe true
    }
}