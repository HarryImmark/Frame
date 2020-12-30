package page;

import model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class payPage
{
    private WebDriver driver;
    private final By numberString = By.xpath("//*[@class='form-number']/input");
    private final By cvcString = By.xpath("//*[@name='cvn']");
    private final By monthString = By.xpath("//*[@name='month']");
    private final By yearString = By.xpath("//*[@name='year']");
    private  final  By cardChoose = By.xpath("//*[@class='content___zuiFB hasIcon___11-jW verticalAlign-center']");
    private  final By errorBuy = By.className("form-row form-globalError");
    private final By adressString = By.xpath("//*[@class='edit___uMt-E']");
    private final By chooseAdress = By.xpath("//*[@class='actions___3D_86']/span[1]");
    private  final By inputString = By.xpath("//*[@value='255026']");
    private  final By message = By.xpath("//*[@class='wrapper___1zU2T']");
    private final By cardFrame = By.xpath("//*[@class='iframe___1xxTG']");

    public payPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public payPage inputDataCard(Card testCard)
    {

        WebElement number = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(numberString));
        number.sendKeys(testCard.getNumber());
        WebElement cvc = driver.findElement(cvcString);
        cvc.sendKeys(testCard.getCvc());
        WebElement month = driver.findElement(monthString);
        month.sendKeys(testCard.getDateMonth());
        WebElement year = driver.findElement(yearString);
        year.sendKeys(testCard.getDateYear());
        return this;
    }

    public payPage OpenCard()
    {
        WebElement card = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(cardChoose));
        card.click();
        return this;
    }

    public  int BuyError()
    {
        WebElement errorNumb = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(errorBuy));
        List<WebElement> exepLogin = driver.findElements(errorBuy);
        return exepLogin.size();
    }

    public  payPage openAdress()
    {
        WebElement adress = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(adressString));
        adress.click();
        return this;
    }

    public  payPage editAdress()
    {
        WebElement editAdress = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(chooseAdress));
        editAdress.click();
        return this;
    }

    public  payPage inputNew()
    {
        WebElement input = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(inputString));
        input.sendKeys("6\n");
        return this;
    }

    public  int messageCheck()
    {
        WebElement messageShow = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(message));
        List <WebElement> exeptMessage = driver.findElements(message);
        return exeptMessage.size();
    }

}
