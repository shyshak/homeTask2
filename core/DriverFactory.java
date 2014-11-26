package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 18.11.14
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */

//implements Factory Pattern.
// Helps to make general solution for different objects  (drivers in our case)

public class DriverFactory {

    //returns a driver by its name
    public static WebDriver getWebDriver(Browsers browser) throws IOException
    {
        switch (browser)
        {
            case FireFox: return new FirefoxDriver();
            case Chrome: return new ChromeDriver();
            case IE: return new InternetExplorerDriver();
            default: throw new InvalidParameterException("Incorrect browser name. Check again");
        }
    }
}
