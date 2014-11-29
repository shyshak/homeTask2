package tests;

import core.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.MainPage;
import pages.NoteBookPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UITests extends BaseConfig{
    MainPage mainPage = new MainPage();
    NoteBookPage noteBookPage = new NoteBookPage();
    ComparePage comparePage = new ComparePage();

    @Test
    public void isOpenedPageTest() {
        //opens main page
        mainPage.open(TestData.rozetkaURL);
        //checking correction of current URL
        Assert.assertTrue(mainPage.isOpened(TestData.rozetkaURL));
    }

    @Test(dependsOnMethods = "isOpenedPageTest")
    public void isOpenedCategoryTest()
    {
        //opens page with category described in TestData class
        mainPage.openCategory(TestData.category);
        //checking correction of current URL
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://rozetka.com.ua/notebooks/c80004/");
    }

    @Test(dependsOnMethods = "isOpenedCategoryTest")
    public void ManufacturesTest()
    {
        //compares amount of found manufactures with the value described in TestData class
        Assert.assertEquals(noteBookPage.countManufactures(), TestData.manufactureCount);
        //select manufacture that is described in TestData class
        noteBookPage.chooseManufactures(TestData.manufacture);

    }

    @Test(dependsOnMethods = "ManufacturesTest")
    public void AddToCompareTest() throws InterruptedException {
        //filter devices according to filter type in TestData class
        noteBookPage.filterDevices(TestData.filterType);
        //add devices to comparison

        noteBookPage.addDevicesToComparison(TestData.mac1);

        noteBookPage.addDevicesToComparison(TestData.mac2);

        Thread.sleep(2000);

        //check compare list
        Assert.assertTrue(noteBookPage.verifyCompareList());
        //go to comparison
        noteBookPage.compare();
    }

    @Test(dependsOnMethods = "AddToCompareTest")
    public void compareTest()
    {
        //checking if the page with comparison of devices is opened
        Assert.assertTrue(mainPage.isOpened("comparison"));
        //click on link that returns to page with devices for adding a new one
        comparePage.addModel();
    }

    @Test(dependsOnMethods = "compareTest")
    public void compareNewTest()
    {
        //checking if driver returns to the page with devices for adding to comparison
        Assert.assertEquals(getDriver().getCurrentUrl().contains("http://rozetka.com.ua/notebooks/c80004/"),true);
        //checking the presence of the comparison list
        Assert.assertTrue(noteBookPage.verifyCompareList());
    }
}
