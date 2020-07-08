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

import java.util.List;

public class SingInTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
    }

    @Test(dataProvider = "accountProvider")
    public void registrationTest(Account account) {
        BasePage basePage = homePage.clickSingIn();
        //сравниваем являеться ли ссылка определленого типа(второй параметр)
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        singInPage.typeEmail("ivanivanov123@gmail.com");
        basePage = singInPage.clickCreateAnAccount();
        Assert.assertTrue(basePage instanceof RegistrationPage);
        RegistrationPage registrationPage = (RegistrationPage) basePage;
        registrationPage.fillRegistrationForm(account);
        registrationPage.clickRegisterButton();
        List<String> errorsList = registrationPage.getErrorsTexts();
        Assert.assertTrue(errorsList.contains("This country requires you to choose a State."));
    }

    @Test
    public void authorizationWithEmptyFieldsEmailAndPassword() {
        BasePage basePage = homePage.clickSingIn();
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        basePage = singInPage.clickSingIn();
        Assert.assertTrue(singInPage.checkForErrorsWhenLoginWithEmptyFields(), "An email address required.");
    }

    @Test
    public void authorizationWithAnEmptyEmailField(){
        BasePage basePage = homePage.clickSingIn();
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        singInPage.typePassword("7856h");
        basePage = singInPage.clickSingIn();
        Assert.assertTrue(singInPage.checkForErrorWhenSaveAnEmptyEmailField(), "An email address required.");
    }

    @Test
    public void authorizationWithAnEmptyPasswordField(){
        BasePage basePage = homePage.clickSingIn();
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        singInPage.typeRegisteredUserEmail("vla0704ivanov@gmail.com");
        basePage = singInPage.clickSingIn();
        Assert.assertTrue(singInPage.checkForErrorWhenSaveAnEmptyPasswordField(), "Password is required.");
    }

    @Test
    public void authorizationWithInvalidData(){
        BasePage basePage = homePage.clickSingIn();
        Assert.assertTrue(basePage instanceof SingInPage);
        SingInPage singInPage = (SingInPage) basePage;
        singInPage.typeRegisteredUserEmail("///&%%%+++");
        singInPage.typePassword(">>>>>>>>>");
        basePage = singInPage.clickSingIn();
        Assert.assertTrue(singInPage.checkForErrorsWhenLoginInWithInvalidValues(), "Invalid email address.");
    }


    @DataProvider
    public Object[][] accountProvider() {
        return new Object[][]{
                {new AccountBuilder()
                        .withGender("Mr.")
                        .withFirstCustomerName("Ivan")
                        .withLastCustomerName("Ivanov")
                        .withEmail("ivanivanov123@gmail.com")
                        .withPassword("2398dog")
                        .withAddress1("Bigcommunism")
                        .withCity("Moscow")
                        .withZipCode("12456")
                        .withMobilePhone("+78900897866")
                        .build()
                }
        };

    }
}
