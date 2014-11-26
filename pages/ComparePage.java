package pages;

import core.BaseConfig;
import org.openqa.selenium.By;

public class ComparePage extends BaseConfig{

    public void addModel()
    {
        //click button that goes to noteBook page for choosing new device to compare list
        driver.findElement(By.xpath("//a[contains(text(),'Добавить модель')]")).click();
    }
}
