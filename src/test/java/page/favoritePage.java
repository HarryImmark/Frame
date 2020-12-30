package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class favoritePage
{
    private WebDriver driver;
    private final By ItemInFavorite = By.xpath("//*[@href='/ru/products/5f06ad934ca8140106df64a3']");

    public favoritePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public int getItem()
    {
        List<WebElement> searchInFavorits = driver.findElements(ItemInFavorite);
        return  searchInFavorits.size();
    }
}
