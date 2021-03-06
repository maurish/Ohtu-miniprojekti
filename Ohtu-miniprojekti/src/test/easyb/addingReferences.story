import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can use the offered functionality'

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


scenario "user can add a book", {

    given 'book selected as a reference', {
        getAddpageAndSelectReference("Kirja")  
    }

    when 'valid parameters for a book are given', {
        element = driver.findElement(By.xpath("//form[@id='bookForm']/input[@name='author']"))
        element.sendKeys("Antti KooKoski")

        element = driver.findElement(By.xpath("//form[@id='bookForm']/input[@name='title']"))
        element.sendKeys("Do you even code?")
        
        element = driver.findElement(By.xpath("//form[@id='bookForm']/input[@name='pubYear']"))
        element.sendKeys("1995")
        
        element = driver.findElement(By.xpath("//form[@id='bookForm']/input[@name='publisher']"))
        element.sendKeys("Otava")
        
        element = driver.findElement(By.xpath("//form[@id='bookForm']/input[@name='refId']"))
        element.sendKeys("Ak89")

        element = driver.findElement(By.id("bookSubmit"))
        element.submit();   
    }
 
    then 'submitted book will be visible', {
        driver.getPageSource().contains("Antti KooKoski").shouldBe true
        driver.getPageSource().contains("Do you even code?").shouldBe true
        driver.getPageSource().contains("1995").shouldBe true
        driver.getPageSource().contains("Otava").shouldBe true
    }
}

scenario "user can add an inproceeding", {

    given 'inproceeding selected as a reference', {
        getAddpageAndSelectReference("Inproceedings")
    }

    when 'valid parameters for an inproceeding are given', {

        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='author']"))
        element.sendKeys("Pauli Perala")

        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='title']"))
        element.sendKeys("Improceedings wait what?")
        
        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='pubYear']"))
        element.sendKeys("2005")
        
        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='bookTitle']"))
        element.sendKeys("Big book of improceedings")
        
        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='refId']"))
        element.sendKeys("pp89")

        element = driver.findElement(By.id("inprocSubmit"))
        element.submit();
    }
    
    then 'submitted inproceeding will be visible', {
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
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='author']"))
        element.sendKeys("Anniina Sallinen")

        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='title']"))
        element.sendKeys("Coding and modern society")
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='pubYear']"))
        element.sendKeys("2011")
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='journal']"))
        element.sendKeys("People magazine")
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='refId']"))
        element.sendKeys("as91")
        
        element = driver.findElement(By.id("articleSubmit"))
        element.submit()
    }
    
    then 'submitted article will be visible', {
        driver.getPageSource().contains("Anniina Sallinen").shouldBe true
        driver.getPageSource().contains("Coding and modern society").shouldBe true
        driver.getPageSource().contains("2011").shouldBe true
        driver.getPageSource().contains("People magazine").shouldBe true
    }
}