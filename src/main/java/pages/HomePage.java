package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement singInButton;

    public HomePage(){
        PageFactory.initElements(this.driver, this);
    }

    public BasePage clickSingIn() {
        singInButton.click();
        try {
            driver.findElement(By.xpath("//i[@class='icon-user left']"));
            return new SingInPage();
        }//если мы будем пытаться найти драйвером элемент а его там не будет
        catch (NoSuchElementException e){
            return new BasePage();
        }

    }

    public BasePage searchBlouse() {
        searchField.sendKeys("Blouse");
        searchButton.click();
        try{
            driver.findElement(By.xpath("//a[@title='Blouse' and @class='product-name']"));
            return new BlousePage();
        }
        catch (NoSuchElementException e){
            return new  BasePage();
        }
    }
}
