package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.TestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//configurations before and after our tests
public class BaseConfig {
    //making field protected for child classes could inherit it
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() throws IOException
    {
            //get driver from TestData class
            driver = DriverFactory.getWebDriver(TestData.driver);
            driver.manage().window().maximize();
            //timeouts settings
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
    protected WebDriver getDriver() {
        if (driver == null)
            driver = new FirefoxDriver();
        return driver;
    }

    @AfterSuite
    public void closeDown()
    {
        driver.quit();
    }


}
