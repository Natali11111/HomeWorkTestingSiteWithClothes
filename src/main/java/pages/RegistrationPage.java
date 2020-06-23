package pages;

import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class RegistrationPage extends BasePage {
    //чтобы работала анотация FindBy
    public RegistrationPage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@id='uniform-id_gender1']")
    private WebElement gender1RadioButton;

    @FindBy(xpath = "//div[@id='uniform-id_gender2']")
    private WebElement gender2RadioButton;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement customerFirstNameField;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement customerLastNameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daysDropDownList;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthsDropDownList;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearsDropDownList;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

   @FindBy(xpath = "//input[@id='company']")
   private WebElement companyField;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address1Field;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2Field;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement stateDropDownList;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcodeField;

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement countryDropDownList;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement homePhoneField;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement mobilePhoneField;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement aliasField;

    @FindBy(xpath = "//span[text()='Register']")
    private WebElement registerButton;

    private void selectGender(String gender) {
        if (gender.equals("Mr.")) {
            gender1RadioButton.click();
        } else {
            gender2RadioButton.click();
        }
    }

    private void typeCustomerFirstName(String firstName) {
        customerFirstNameField.sendKeys(firstName);
    }

    private void typeCustomerLastName(String lastName) {
        customerLastNameField.sendKeys(lastName);
    }

    private void typeEmail(String email) {
        if (emailField.getText().equals("")) {
            emailField.clear();
            emailField.sendKeys(email);
        }
    }

    private void typePassword(String password) {
        passwordField.sendKeys(password);
    }

    private void setBirthday(String day, String month, String year) {
        selectBirthDay(day);
        selectBirthMonth(month);
        selectBirthYear(year);

    }

    private void selectBirthDay(String day) {
        Select value = new Select(daysDropDownList);
        value.selectByValue(day);
    }

    private void selectBirthMonth(String month) {
        Select value = new Select(monthsDropDownList);
        value.selectByValue(month);
    }

    private void selectBirthYear(String year) {
        Select value = new Select(yearsDropDownList);
        value.selectByValue(year);
    }

    private void typeFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    private void typeLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    private void typeCompany(String company){
        companyField.sendKeys(company);
    }

    private void typeAddress1(String address1) {
        address1Field.sendKeys(address1);
    }

    private void typeAddress2(String address2){
        address2Field.sendKeys(address2);
    }

    private void typeCity(String city) {
        cityField.sendKeys(city);
    }

    private void selectState(String state) {
        Select value = new Select(stateDropDownList);
        value.selectByVisibleText(state);
    }

    private void typePostCode(String postcode) {
        postcodeField.sendKeys(postcode);
    }

    private void selectCountry(String country) {
        Select value = new Select(countryDropDownList);
        value.selectByVisibleText(country);
    }

    private void typeHomePhone(String phoneNumber){
        homePhoneField.sendKeys(phoneNumber);
    }

    private void typeMobilePhone(String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
    }

    private void typeAlias(String alias){
        aliasField.sendKeys(alias);
    }

    public BasePage clickRegisterButton() {
        registerButton.click();
        try{
         driver.findElement(By.xpath("//a[@title='Orders']"));
            return new MyAccountPage();
        }
        catch (NoSuchElementException e){
            return new BasePage();
        }
    }

    public void fillRegistrationForm(Account account) {
        selectGender(account.getGender());
        typeCustomerFirstName(account.getFirstCustomerName());
        typeCustomerLastName(account.getLastCustomerName());
        typeEmail(account.getEmail());
        typePassword(account.getPass());
        setBirthday(account.getDay(), account.getMonth(), account.getYear());
        typeFirstName(account.getFirstName());
        typeLastName(account.getLastName());
        typeCompany(account.getCompany());
        typeAddress1(account.getAddress1());
        typeAddress2(account.getAddress2());
        typeCity(account.getCity());
        selectState(account.getState());
        typePostCode(account.getPostcode());
        selectCountry(account.getCountry());
        typeHomePhone(account.getHomePhone());
        typeMobilePhone(account.getMobilePhone());
        typeAlias(account.getAlias());
    }


    public List<String> getErrorsTexts() {
        //мы одидаем присутствие всех элементов по локатору
        List<WebElement> listErrors = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-danger']//li")));
        String errorText = "";
        List<String> errorsTexts = new ArrayList<String>();
        //для перебора элементов
        for (WebElement element : listErrors) {
            try {
                errorText = element.findElement(By.tagName("b")).getText();
            } catch (NoSuchElementException ignored) {
            }
            errorText += element.getText();
            errorsTexts.add(errorText);
        }
        return errorsTexts;
    }
}




