package com.imdb.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.krb5.internal.crypto.Des;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.imdb.utils.Elements.comboBox;

public class BaseTest {

    protected static WebDriver driver;
    public static int WAIT_TIME = 40;
    public static final String GOOGLE_TITLE = "Google";
    public static final String IMDB_TITLE = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    public static final String IMDB_SIGN_IN = "IMDb Sign-In";

    @BeforeScenario
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/java/com/imdb/resources/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("--disable-notifications");


        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        driver = new ChromeDriver(desiredCapabilities); ;

        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
 }

    @AfterScenario
    public void tearDown(){
        driver.quit();
 }



    public void scrollToElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
    public WebElement chooseRandomElementFromList(List <WebElement> elementList){

        Random findRandom = new Random();
        WebElement randomElement = elementList.get(findRandom.nextInt(elementList.size()));
        return randomElement;

    }
    public void deleteFirst12ElementsFromList(List <WebElement> elementList){

        for (int i=0;i<24;i++){
            elementList.remove(i);
        }

    }
    public void highlightElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background='yellow'",element);

    }

    public void waitUntilElementLocated(By by){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

}
