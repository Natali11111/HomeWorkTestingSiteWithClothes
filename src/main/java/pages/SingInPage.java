package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage extends BasePage {

    public SingInPage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailCreateAccountFiled;

    @FindBy(xpath = "//i[@class='icon-user left']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement registeredUserEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement singInButton;

    public BasePage clickSingIn() {
        singInButton.click();
        try {
            driver.findElement(By.xpath("//span[text()='My personal information']"));
            return new MyAccountPage();
        } catch (NoSuchElementException e) {
            return new BasePage();
        }
    }

    public void typeEmail(String email) {
        emailCreateAccountFiled.clear();
        emailCreateAccountFiled.sendKeys(email);
    }

    public BasePage clickCreateAnAccount() {
        createAccountButton.click();
        try {
            driver.findElement(By.xpath("//span[text()='Register']"));
            return new RegistrationPage();
        } catch (NoSuchElementException e) {
            return new BasePage();
        }
    }

    public void typeRegisteredUserEmail(String email) {
        registeredUserEmailField.sendKeys(email);
    }

    public void typePassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean checkForErrorsWhenLoginInWithInvalidValues() {
        try {
            driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[text()='Invalid email address.']"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean checkForErrorWhenSaveAnEmptyEmailField() {
        try {
            driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[text()='An email address required.']"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean checkForErrorWhenSaveAnEmptyPasswordField() {
        try{
            driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[text()='Password is required.']"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean checkForErrorsWhenLoginWithEmptyFields(){
        try {
            driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[text()='An email address required.']"));
            return true;
        }
       catch (NoSuchElementException e){
            return false;
       }
    }


}
