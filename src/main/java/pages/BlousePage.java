package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlousePage extends BasePage {

    public BlousePage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//li[@id='list']")
    private WebElement listButton;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCartButton;

    public void clickListButton() {
        listButton.click();
    }

    public BasePage clickAddToCartButton() {
        addToCartButton.click();
        try {
            driver.findElement(By.xpath("//i[@class='icon-ok']"));
            return new AddToCartPopup();
        }
        catch (NoSuchElementException e){
            return new BasePage();
        }
    }


}
