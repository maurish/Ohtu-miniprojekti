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
        
        driver.findElements(By.id("listPage")).size().shouldNotBe 0
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
        driver.findElements(By.id("addPage")).size().shouldNotBe 0
    }
}

scenario "user sees the bibtex listing page", {
    given 'user enters frontpage url', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
    }

    when 'user navigates to bibtex page', {
        element = driver.findElement(By.linkText("Listaa lähteet bibtexinä"))
        element.click()
    }
    
    then 'reference add page will be visible', {
        driver.findElements(By.id("bibtexPage")).size().shouldNotBe 0
    }
}