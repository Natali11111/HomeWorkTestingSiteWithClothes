package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage extends BasePage {

    public SingInPage(){
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailCreateAccountFiled;

    @FindBy(xpath = "//i[@class='icon-user left']")
    private WebElement createAccountButton;

    public void typeEmail(String email){
        emailCreateAccountFiled.clear();
        emailCreateAccountFiled.sendKeys(email);
    }

    public BasePage clickCreateAnAccount(){
       createAccountButton.click();
       try {
       driver.findElement(By.xpath("//span[text()='Register']"));
       return new RegistrationPage();
       }
       catch (NoSuchElementException e){
           return new BasePage();
       }
    }

}
