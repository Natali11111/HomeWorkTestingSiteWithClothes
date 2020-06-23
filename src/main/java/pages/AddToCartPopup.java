package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPopup extends BasePage {

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckoutButton;

    public AddToCartPopup() {
        PageFactory.initElements(this.driver, this);
    }

    public BasePage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        try{
            driver.findElement(By.xpath("//h1[@id='cart_title']"));
            return new CartPage();
        }
        catch (NoSuchElementException e){
            return new BasePage();
        }
    }


}
