package pages;

import core.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


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
        WebElement checkMB = driver.findElement(comparedElem);
        if(checkMB.getAttribute("checked")==null)

            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", checkMB);

    }

    public boolean verifyCompareList()
    {
        Boolean isRight = false;
        //creates list of links to chosen devices
        List<WebElement> compareDevices = driver.findElements(By.cssSelector(".block>ul>li>a:nth-child(2)"));
        /*if(compareDevices.get(0).getAttribute("href").equals("http://rozetka.com.ua/apple_macbook_pro_retina_15_z0rd000af/p1330562/")&&
                compareDevices.get(1).getAttribute("href").equals("http://rozetka.com.ua/apple_macbook_pro_retina_13_z0rb000b5/p1330177/"))
            isRight = true;  */


        for(WebElement device:compareDevices)      {
            boolean isRight1 = device.getText().contains("Apple MacBook Air 11\" (MD711UA/B) Официальная гарантия!");
            boolean isRight2 = device.getText().contains("Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия!");
            if(isRight1&&isRight2) break;
            isRight = isRight1&&isRight2;
        }

        return isRight;
    }

    public void compare()
    {
        driver.findElement(By.xpath("//a[contains(text(),'сравнении')]")).click();
    }
}
