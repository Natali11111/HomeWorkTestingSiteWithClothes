package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static final String PATH_TO_CHROME_DRIVER = "src/main/resources/browsers/chromedriver.exe";

    private static final DriverManager INSTANCE = new DriverManager();

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public DriverManager createWebDriver(){
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        driver.set(new ChromeDriver());
        return this;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
