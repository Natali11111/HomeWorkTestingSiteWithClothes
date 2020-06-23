import model.Account;
import model.AccountBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SingInPage;

public class FillingInAllFieldsInTheRegistrationFormTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
    }

    @Test(dataProvider = "accountProvider2")
    public void fillingInAllFieldsInTheRegistrationFormTest(Account account) {
        BasePage basePage = homePage.clickSingIn();
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        singInPage.typeEmail("mariabelokurova54@gmail.com");
        basePage = singInPage.clickCreateAnAccount();
        Assert.assertTrue(basePage instanceof RegistrationPage);
        RegistrationPage registrationPage = (RegistrationPage) basePage;
        registrationPage.fillRegistrationForm(account);
        registrationPage.clickRegisterButton();
    }
    @DataProvider
    public Object[][] accountProvider2() {
        return new Object[][]{
                {new AccountBuilder()
                        .withGender("Mrs.")
                        .withFirstCustomerName("Maria")
                        .withLastCustomerName("Belokurova")
                        .withPassword("67885456")
                        .withEmail("mariabelokurova54@gmail.com")
                        .withBirthdayDay("4")
                        .withBirthdayMonth("11")
                         .withBirthdayYear("1987")
                        .withFirstName("Maria")
                        .withLastName("Belokurova")
                        .withCompany("Google")
                        .withAddress1("Cherry Hill")
                        .withAddress2("Birch Grove")
                        .withCity("Atlanta")
                        .withState("Georgia")
                        .withZipCode("00456")
                        .withCountry("United States")
                        .withHomePhone("+478358573835")
                        .withMobilePhone("+578587855")
                        .withAliasAddress("Marinka")
                        .build()
                }
        };

    }
}
