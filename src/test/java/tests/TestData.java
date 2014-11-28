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
    public static final By mac1 = By.xpath("//a[contains(text(),'Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия!')]/../../*[6]/*[1]/*[1]/*[1]");
    public static final By mac2 = By.xpath("//a[contains(text(),'Apple MacBook Air 11\" (MD711UA/B) Официальная гарантия!')]/../../*[6]/*[1]/*[1]/*[1]");


}
