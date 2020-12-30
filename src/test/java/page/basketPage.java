package page;
import model.Promocode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class basketPage {
    private WebDriver driver;
    private final By deleteItemInBasketButtonLocator = By.xpath("//*[@class='text___183EF']");
    private final By confirmLocator = By.xpath("//*[@class='button___3hmfW button___TbaLj fill-brand___18fJk padding-normal___2ctfV rounded___1J8B1']");
    private final By itemLocator = By.xpath("//*[@class='inner___15C_']");
    private final By inputString = By.xpath("//*[@name='promocode']");
    private  final By submitString = By.xpath("//*[@class='button___2K5HX']");
    private  final By warningLocator = By.className("error___2HIV1");
    private final By OpenBasketLocator = By.xpath("//*[@href='/ru/cart']");

    public basketPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public basketPage deleteFromBasket()
    {
        WebElement DeleteItemButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(deleteItemInBasketButtonLocator));
        DeleteItemButton.click();
        WebElement Confirm = driver.findElement(confirmLocator);
        Confirm.click();
        return this;
    }

    public basketPage inputCode(Promocode promocode)
    {
        WebElement GoToBasket = driver.findElement(OpenBasketLocator);
        GoToBasket.click();
        WebElement stringCode = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(inputString));
      stringCode.sendKeys(promocode.getPromocode());
      WebElement SubmitButton  = driver.findElement(submitString);
      SubmitButton.click();
      return this;
    }

    public int countItemsInBasket()
    {
        List<WebElement> ItemsInBasket = driver.findElements(itemLocator);
        return ItemsInBasket.size();
    }

    public int errorCheck()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(warningLocator));
        List<WebElement> WarningCheck = driver.findElements(warningLocator);
        return WarningCheck.size();
    }



}
