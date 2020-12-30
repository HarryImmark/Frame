package page;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class mainPage
{
    private WebDriver driver;

    private final By seachString = By.xpath("//*[@class='input___3wRUz']");
    private final By nullTrigger = By.xpath("//*[@class='column___1WRbZ marginBottom___lo7lp md-8___2qmmU lg-9___6qUD3']");


    public mainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public mainPage openMainPage(String URL)
    {
        driver.get(URL);
        return this;
    }

    public mainPage  inputData(String s)
    {
        WebElement search_string= (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(seachString));
        search_string.sendKeys(s + "\n");
        return this;
    }

    public int itemsCount()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(nullTrigger));
        List<WebElement> trigger = driver.findElements(nullTrigger);
        return trigger.size();
    }

    public mainPage inputTypeSort()
    {
        
        return this;
    }
}
