package pages;

import core.BaseConfig;
import org.openqa.selenium.By;



//The main page of Rozetka
public class MainPage extends BaseConfig {

    //open Rozetka
    public void open(String url)
    {
        getDriver().get(url);
    }
    public boolean isOpened(String url)
    {
        if(getDriver().getCurrentUrl().contains(url)) return true;
        else return false;
    }

    //opens page with your category
    public void openCategory(By deviceCategory)
    {
        getDriver().findElement(deviceCategory).click();
    }
}
