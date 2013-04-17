import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

def getAddpageAndSelectReference(reference){
    driver = new HtmlUnitDriver()
    driver.get("http://localhost:8090/")
    element = driver.findElement(By.linkText("Lisää lähde"))
    element.click()
    WebElement select = driver.findElement(By.id("dropDown"));
    List<WebElement> options = select.findElements(By.tagName("option"));
    for (WebElement option : options) {
        if(reference.equals(option.getText()))
        option.click();
    }

}

def clickBibtexPage() {
    element = driver.findElement(By.linkText("Listaa kaikki bibtexinä"))
    element.click()
}

description 'User can see added references bibtex'

scenario "user sees book's bibtex", {

    given 'book has been added to references', {
        getAddpageAndSelectReference("Kirja")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Antti")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Do you even code?")

        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1995")

        element = driver.findElement(By.name("publisher"))
        element.sendKeys("Otava")

        element = driver.findElement(By.id("bookSubmit"))
        element.submit();
    }

    when 'bibtex listing page link is pressed', {
        clickBibtexPage()
    }
 
    then 'bibtex of the submitted book will be visible', {
        driver.getPageSource().contains("Hello Bibtex").shouldBe true
        driver.getPageSource().contains("book").shouldBe true
    }
}

scenario "user sees inproceeding's bibtex", {

    given 'inproceeding is added to references', {
        getAddpageAndSelectReference("Inproceedings")

        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='author']"))
        element.sendKeys("Pauli Perala")

        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='title']"))
        element.sendKeys("Improceedings wait what?")
        
        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='pubYear']"))
        element.sendKeys("2005")
        
        element = driver.findElement(By.xpath("//form[@id='inprocForm']/input[@name='bookTitle']"))
        element.sendKeys("Big book of improceedings")

        element = driver.findElement(By.id("inprocSubmit"))
        element.submit();
    }

    when 'bibtex listing page link is pressed', {
        clickBibtexPage()
    }
    
    then 'bibtex of the submitted inproceeding will be visible', {
        driver.getPageSource().contains("Hello Bibtex").shouldBe true
        driver.getPageSource().contains("Inproceedings").shouldBe true
    }
}

scenario "user can add an article", {
    given 'article is added as a reference', {
        getAddpageAndSelectReference("Artikkeli")

        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='author']"))
        element.sendKeys("Anniina Sallinen")

        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='title']"))
        element.sendKeys("Coding and modern society")
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='pubYear']"))
        element.sendKeys("2011")
        
        element = driver.findElement(By.xpath("//form[@id='articleForm']/input[@name='journal']"))
        element.sendKeys("People magazine")
        
        element = driver.findElement(By.id("articleSubmit"))
        element.submit()
    }

    when 'bibtex listing page link is pressed', {
        clickBibtexPage()
    }
    
    then 'bibtex of the submitted article will be visible', {
        driver.getPageSource().contains("Hello Bibtex").shouldBe true
        driver.getPageSource().contains("Article").shouldBe true
    }
}