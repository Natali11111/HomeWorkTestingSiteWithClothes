package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement plusButton;

    @FindBy(xpath = "//span[@class='price' and  @id='product_price_2_7_0']/span")
    private WebElement blousePrice;

    @FindBy(xpath = "//td[@id='total_product']")
    private WebElement totalProductsPrice;

    @FindBy(xpath = "//td[@id='total_shipping']")
    private WebElement totalShippingPrice;

    @FindBy(xpath = "//td[@id='total_price_without_tax']")
    private WebElement totalWithoutTax;

    @FindBy(xpath = "//td[@id='total_tax']")
    private WebElement totalTax;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement generalTotal;

    @FindBy(xpath = "//a[@title='Delete' and  @id='2_7_0_0']")
    private WebElement blouseDeleteButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;

    public CartPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void clickPlusIcon() {
        plusButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='quantity_2_7_0_0_hidden' and @value='2']")));
    }

    public String getBlousePrice() {
        return blousePrice.getText();
    }

    public String getTotalProductsPrice(){
        return totalProductsPrice.getText();
    }

    public String getTotalShippingPrice(){
        return totalShippingPrice.getText();
    }

    public String getTotalWithoutTax(){
        return totalWithoutTax.getText();
    }

    public String getTotalTax(){
        return totalTax.getText();
    }

    public String getGeneralTotal(){
        return generalTotal.getText();
    }

    public void deleteBlouses(){
        blouseDeleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@title='Delete' and  @id='2_7_0_0']")));
    }

    public String getEmptyCartMessageText(){
      return   emptyCartMessage.getText();
    }


}
