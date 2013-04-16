import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User gets error messages when adding references with invalid parameters'

def getAddpageAndSelectReference(reference){
    driver = new HtmlUnitDriver()
    driver.get("http://localhost:8090/")
    element = element = driver.findElement(By.linkText("Lisää lähde"))
    element.click()
    WebElement select = driver.findElement(By.id("dropDown"));
    List<WebElement> options = select.findElements(By.tagName("option"));
    for (WebElement option : options) {
        if(reference.equals(option.getText()))
        option.click();
    }

}


scenario "user can't add a book with invalid parameters", {

    given 'book selected as a reference', {
        getAddpageAndSelectReference("Kirja")  
    }

    when 'invalid parameters for a book are given', {
        element = driver.findElement(By.name("author"))
        element.sendKeys("")

        element = driver.findElement(By.name("title"))
        element.sendKeys("")

        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("100")

        element = driver.findElement(By.name("publisher"))
        element.sendKeys("")

        element = driver.findElement(By.xpath("//input[@type='submit']"))
        element.submit();
    }
 
    then 'correct error messages are visible', {
        driver.getPageSource().contains("Listing of all references").shouldBe false
        driver.getPageSource().contains("author must be defined").shouldBe true
        driver.getPageSource().contains("title must be defined").shouldBe true
        driver.getPageSource().contains("must be greater than or equal to 1900").shouldBe true
        driver.getPageSource().contains("may not be empty").shouldBe true
    }
}

scenario "user can't add an improceeding with invalid parameters", {

    given 'improceeding selected as a reference', {
        getAddpageAndSelectReference("Inproceedings")
    }

    when 'valid parameters for an improceeding are given', {

        element = driver.findElement(By.name("author"))
        element.sendKeys("")

        element = driver.findElement(By.name("title"))
        element.sendKeys("")
        
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1000")
        
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("")

        element = driver.findElement(By.xpath("//input[@type='submit']"))
        element.submit()
    }
    
    then 'correct error messages are visible', {

        driver.getPageSource().contains("Pauli Perala").shouldBe true
        driver.getPageSource().contains("Improceedings wait what?").shouldBe true
        driver.getPageSource().contains("2005").shouldBe true
        driver.getPageSource().contains("Big book of improceedings").shouldBe true
    }
}

scenario "user can add an article", {
    given 'article selected as a reference', {
        getAddpageAndSelectReference("Artikkeli")
    }

    when 'valid parameters for an article are given', {
        author = "Anttiina"
        element = driver.findElement(By.name("author"))
        element.sendKeys("")

        element = driver.findElement(By.name("title"))
        element.sendKeys("")
        
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("2050")
        
        element = driver.findElement(By.name("journal"))
        element.sendKeys("")
        
        element = driver.findElement(By.xpath("//input[@type='submit']"))
        element.submit()
    }
    
    then 'correct error messages are visible', {
        driver.getPageSource().contains("must be less than or equal to 2013").shouldBe true
        driver.getPageSource().contains("author must be defined").shouldBe true
        driver.getPageSource().contains("title must be defined").shouldBe true
        driver.getPageSource().contains("length must be between 1 and 35").shouldBe true
    }
}