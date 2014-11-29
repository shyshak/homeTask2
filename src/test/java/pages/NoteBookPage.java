package pages;

import core.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class NoteBookPage extends BaseConfig {

    public int countManufactures()
    {
        List<WebElement> manufList = getDriver().findElements(By.cssSelector(".m-cat-l-i:nth-child(2)>ul>li"));
        return manufList.size();
    }

    public void chooseManufactures(String manufacture)
    {
        driver.findElement(By.linkText(manufacture)).click();

    }

    public void filterDevices(String typeOfFilter)
    {
        //click icon that shows filter types list
        driver.findElement(By.xpath("//a[@name='drop_link']/*[1]")).click();
        //choose filter type
        driver.findElement(By.linkText(typeOfFilter)).click();
    }

    public void addDevicesToComparison(By comparedElem)
    {
        waitForLoad(driver);
        WebElement checkMB = driver.findElement(comparedElem);
        if(!checkMB.isSelected()){
            checkMB.click();}
        waitForLoad(driver);
    }

     void waitForLoad(WebDriver driver) {
         ExpectedCondition<Boolean> pageLoadCondition = new
                 ExpectedCondition<Boolean>() {
                     public Boolean apply(WebDriver driver) {
                         return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                     }
                 };
         WebDriverWait wait = new WebDriverWait(driver, 30);
         wait.until(pageLoadCondition);
     }

     public boolean verifyCompareList()
     {
         Boolean isRight = false;
         //creates list of links to chosen devices
        List<WebElement> compareDevices = driver.findElements(By.cssSelector(".block>ul>li>a:nth-child(2)"));

        if(compareDevices.get(1).getText().contains("Apple MacBook Air 11\" (MD711UA/B) Официальная гарантия!")
                &&compareDevices.get(0).getText().contains("Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия!"))
            return true;
        else return false;
    }

    public void compare()
    {
        driver.findElement(By.xpath("//a[contains(text(),'сравнении')]")).click();
    }
}
