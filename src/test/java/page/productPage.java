package page;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class productPage

{
    private WebDriver driver;
    private final By spamLocator = By.className("close_jsx_svg__svg");
    private final By buttonAddLocator = By.className("button___1WAua");
    private final By exeptionLocator = By.xpath("//*[@class='error___1q9h7']");
    private final By buttonOpenBasketLocator = By.xpath("//*[@href='/ru/cart']");
    private final By favoriteLocator = By.className("favorite___2jmct");
    private final By buttonFavoriteLocator = By.xpath("//*[@href='/ru/favorites']");
    private final By buttonSigin = By.xpath("//*[@href='/ru/entrance']");
    private final By loginMail = By.xpath("//*[@class='button___1YtF2 size-normal theme-default___Eq4qM']");
    private final By enterMail = By.xpath("//*[@class='button___1YtF2 email___3-nIG size-normal']");
    private final By loginSigin = By.xpath("//*[@name='email']") ;
    private final By passwordSigin = By.xpath("//*[@name='password']") ;
    private final By exeptionLogin = By.xpath("//*[@class='fieldLabel___16SEe error___2Xi2C']");
    private final By indicatorWait = By.xpath("//*[@href='/ru/cart']/div/div/span");
    private final By enterButton = By.xpath("//*[@class='caption___3L-qE']");
    private final By loginCloseButton = By.xpath("//*[@class='close___3u6yL']");
    private final By buttonPay = By.xpath("//*[@class='button___3hmfW fill-brand___18fJk padding-normal___2ctfV block___2aWbQ rounded___1J8B1']");
    private final By buttonBuy = By.xpath("//*[@href='/ru/cart']");

public productPage(WebDriver  driver)
{
    this.driver = driver;
}

public productPage closeSpam(String URL)
{
    driver.get(URL);
   // WebElement SearchSpam = (new WebDriverWait(driver, 15))
   //        .until(ExpectedConditions.presenceOfElementLocated(spamLocator));
   // SearchSpam.click();
    return this;
}

public productPage addProduct()
{
    WebElement ButtonAdd  = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(buttonAddLocator));
    new WebDriverWait(driver,25).until(ExpectedConditions.elementToBeClickable(buttonAddLocator));
    ButtonAdd.click();
    return this;
}

public  productPage addFavorite()
{
    WebElement favoriteButton = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(favoriteLocator));
    favoriteButton.click();
    return this;
}

public int checkExepion()
{
    List<WebElement> Exeption = driver.findElements(exeptionLocator);
    return Exeption.size();
}

public basketPage openBasket()
{
    /*try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }*/
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement GoToBasket = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(buttonOpenBasketLocator));
    GoToBasket.click();
    return new basketPage(driver);
}
public productPage signIn()
{
    WebElement siginButton = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(buttonSigin));
    siginButton.click();
    WebElement mailButton = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(loginMail));
    mailButton.click();
    WebElement confirmButton = driver.findElement(enterMail);
    confirmButton.click();
    return this;
}

public productPage inputDataUser (User user)
{
WebElement login = driver.findElement(loginSigin);
login.sendKeys(user.getUsername());
WebElement password = driver.findElement(passwordSigin);
password.sendKeys(user.getPassword());
WebElement enter = (new WebDriverWait(driver, 60))
            .until(ExpectedConditions.presenceOfElementLocated(enterButton));
enter.click();
WebElement sideBar = driver.findElement(By.xpath("//*[@class='content___ZmMAf narrowPopupContent___38WAx']"));
new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(sideBar));
return this;
}

public  int  exepLogin()
{
    List<WebElement> exepLogin = driver.findElements(exeptionLogin);
    return  exepLogin.size();
}

public favoritePage openFavorite()
{
    WebElement GoToFavorite = driver.findElement(buttonFavoriteLocator);
    GoToFavorite.click();
    return new favoritePage(driver);
}

public productPage  closeLogin()
    {
         WebElement close = driver.findElement(loginCloseButton);
         close.click();
         return this;
    }

    public  payPage openPayPage()
    {
        WebElement buy = (new WebDriverWait(driver, 60))
               .until(ExpectedConditions.presenceOfElementLocated(buttonBuy));
        buy.click();
        WebElement payPage = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(buttonPay));
        payPage.click();
        return new payPage (driver);
    }


}
