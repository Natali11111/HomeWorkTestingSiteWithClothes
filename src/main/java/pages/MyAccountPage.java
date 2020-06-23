package pages;

import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    public MyAccountPage(){
        PageFactory.initElements(this.driver, this);
    }
}
