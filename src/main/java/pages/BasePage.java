package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {

    public BasePage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }

}
