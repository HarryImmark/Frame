package Test;

import model.Card;
import model.Promocode;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mainPage;
import page.productPage;
import service.CardCreator;
import service.PromocodeCreator;
import service.UserCreator;


public class WebDriverJoom_Test extends commonConditions
{

    private static final String URL1 = "https://www.joom.com/ru/products/5f06ad934ca8140106df64a3";
    private static final String URL2 = "https://www.joom.com/ru/products/5f1a841fcd239a0106798bd2";
    private static final String URL3 = "https://www.joom.com/ru";

    private static final String testSearchWrong = "dsfdsfdsfsdfdsf";
    private static final String testSearchItem = "куртка";


    @Test(priority = 1)
    public void checkEmptyBasket ()
    {
        int SearchProductsInBasket = new productPage(driver)
                .closeSpam(URL2)
                .addProduct()
                .openBasket()
                .deleteFromBasket()
                .countItemsInBasket();
        Assert.assertTrue(SearchProductsInBasket == 0,"Basket not empty");
    }

    @Test(priority = 2)
    public void checkBuyWithoutColor ()
    {
         int checkForExeption = new productPage(driver)
                 .closeSpam(URL1)
                 .addProduct()
                 .checkExepion();
         Assert.assertTrue(checkForExeption > 0,"The item was delete from basket");
    }

    @Test(priority = 3)
    public void AddFavorite()
    {
      int addFavorite = new productPage(driver)
              .closeSpam(URL1)
              .addFavorite()
              .openFavorite()
              .getItem();
      Assert.assertEquals(addFavorite, 1);
    }

    @Test(priority = 4)
    public void WrongCode()
    {
        Promocode testCode = PromocodeCreator.withCredentialsCode();
             int WarningAfter = new productPage(driver)
             .closeSpam(URL2)
             .addProduct()
             .openBasket()
             .inputCode(testCode)
             .errorCheck();
        Assert.assertEquals(WarningAfter, 1);
    }

    @Test(priority = 5)
    public void LoginTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        int LoginTest = new productPage(driver)
                .closeSpam(URL2)
                .signIn()
                .inputDataUser(testUser)
                .exepLogin();
        Assert.assertEquals(LoginTest, 0);
    }

    @Test(priority = 6)
    public void CardTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        Card testCard = CardCreator.withCredentialsFromProperty();
        int TestIndex = new productPage(driver)
                .closeSpam(URL2)
                .signIn()
                .inputDataUser(testUser)
                .openPayPage()
                .OpenCard()
                .inputDataCard(testCard)
                .BuyError();
        Assert.assertEquals(TestIndex, 1);
    }

    @Test(priority = 7)
    public void SearchTest()
    {
        int zeroItemsTrigger = new mainPage(driver)
                .openMainPage(URL3)
                .inputData(testSearchWrong)
                .itemsCount();
        Assert.assertEquals(zeroItemsTrigger, 1);
    }


    @Test(priority = 8)
    public void indexCheck ()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        int IndexErr = new productPage(driver)
                .closeSpam(URL2)
                .signIn()
                .inputDataUser(testUser)
                .openPayPage()
                .openAdress()
                .editAdress()
                .inputNew()
                .messageCheck();
        Assert.assertEquals(IndexErr, 1);
    }

/*    @Test
    public void sortHight()
    {
        String sort = new mainPage(driver)
                .openMainPage(URL3)
                .inputData(testSearchItem)
                .inputTypeSort()
    }
*/
}
