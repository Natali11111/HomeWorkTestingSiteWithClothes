import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage();
    }

    @Test
    public void testAddingAndDeletingBlousesToCart() {
        BasePage basePage = homePage.searchBlouse();
        Assert.assertTrue(basePage instanceof BlousePage);
        BlousePage blousePage = (BlousePage) basePage;
        blousePage.clickListButton();
        basePage = blousePage.clickAddToCartButton();
        Assert.assertTrue(basePage instanceof AddToCartPopup);
        AddToCartPopup addToCartPopup = (AddToCartPopup) basePage;
        basePage = addToCartPopup.clickProceedToCheckoutButton();
        Assert.assertTrue(basePage instanceof CartPage);
        CartPage cartPage = (CartPage) basePage;
        cartPage.clickPlusIcon();
        Assert.assertEquals(cartPage.getBlousePrice(), "$27.00");
        Assert.assertEquals(cartPage.getTotalProductsPrice(), "$54.00");
        Assert.assertEquals(cartPage.getTotalShippingPrice(), "$2.00");
        Assert.assertEquals(cartPage.getTotalWithoutTax(), "$56.00");
        Assert.assertEquals(cartPage.getTotalTax(), "$0.00");
        Assert.assertEquals(cartPage.getGeneralTotal(), "$56.00");
        cartPage.deleteBlouses();
        Assert.assertEquals(cartPage.getEmptyCartMessageText(), "Your shopping cart is empty.");

    }
}
