import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can choose references from a drop down menu'

scenario "user can select book as a reference", {

    given 'reference adding page visible', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
        element = element = driver.findElement(By.linkText("Lisää lähde"))
        element.click()     
    }

    when 'book is selected from list', {
        WebElement select = driver.findElement(By.id("dropDown"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Kirja".equals(option.getText()))
            option.click();
        }
    }
 
    then 'attributes unique to books are visible', {
        driver.getPageSource().contains("Editoija:").shouldBe true
    }
}

scenario "user can select an improceeding as a reference", {

    given 'reference adding page visible', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
        element = element = driver.findElement(By.linkText("Lisää lähde"))
        element.click() 
    }

    when 'improceedings is selected from list', {

         WebElement select = driver.findElement(By.id("dropDown"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Inproceedings".equals(option.getText()))
            option.click();
        }
    }
    
    then 'attributes unique to improceedings are visible', {
        driver.getPageSource().contains("Organisaatio:").shouldBe true
    }
}

scenario "user can select an article as a reference", {
    given 'reference adding page visible', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/")
        element = element = driver.findElement(By.linkText("Lisää lähde"))
        element.click()    
    }

    when 'article is selected from list', {

        WebElement select = driver.findElement(By.id("dropDown"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Artikkeli".equals(option.getText()))
            option.click();
        }
    }
    
    then 'attributes unique to articles are visible', {
        driver.getPageSource().contains("Julkaisupaikka:").shouldBe true
        driver.getPageSource().contains("Volume:").shouldBe true
        driver.getPageSource().contains("Julkaisu (journal):").shouldBe true
    }
}