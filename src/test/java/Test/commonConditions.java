package Test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import until.TestListener;


@Listeners({TestListener.class})
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
