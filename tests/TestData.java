package tests;

import core.Browsers;
import org.openqa.selenium.By;

public class TestData {

    public static final Browsers driver = Browsers.valueOf("FireFox");
    public static final String rozetkaURL = "http://rozetka.com.ua/";
    public static final int manufactureCount = 9;
    public static final String manufacture = "Apple";
    public static final String filterType = "от дорогих к дешевым";
    public static final By category = By.xpath("//a[.='Ноутбуки']");
    public static final By mac1 = By.cssSelector(".gtile-i-wrap:nth-child(2) .g-tools-to-compare-check");
    public static final By mac2 = By.cssSelector(".gtile-i-wrap:nth-child(4) .g-tools-to-compare-check");

}
