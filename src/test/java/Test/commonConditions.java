package Test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class commonConditions
{
    protected WebDriver driver;

    @BeforeTest()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void close(){ DriverSingleton.deleteAllCookies(); }
    @AfterTest(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
