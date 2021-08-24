package com.imdb.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    public static final int WAIT_TIME = 40;
    public static final String GOOGLE_TITLE     = "Google";
    public static final String IMDB_TITLE       = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    public static final String IMDB_SIGN_IN     = "IMDb Sign-In";
    public static final String SIGN_IN_TEXT     = "Sign in with IMDb";
    public static final String WATCHLIST_TITLE  = "Your Watchlist - IMDb";
    public static String titleOfChosenElement;
    public static int indexOfChosenElement;


    @BeforeScenario
    public void setup () {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/imdb/resources/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("--disable-notifications");


        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        driver = new ChromeDriver(desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterScenario
    public void tearDown () {

        driver.close();
        driver.quit();
    }



    public void scrollToElement (WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public WebElement chooseRandomElementFromList (List <WebElement> elementList) {

        Random findRandom = new Random();
        indexOfChosenElement = findRandom.nextInt(elementList.size());
        return elementList.get(indexOfChosenElement);
    }

    public void deleteElementsFromList (int deleteItemsCount, List <WebElement> elementList) {

        for (int i=0;i<=deleteItemsCount;i++){
            elementList.remove(i);
        }
    }

    public void highlightElement (WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background='yellow'",element);
    }

    public void waitUntilElementLocated (By by) {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickAnElement (By by) {

        waitUntilElementLocated(by);
        WebElement elementToClick = driver.findElement(by);
        elementToClick.click();
    }

    public void clickAndHighlightAnElement(By by) {

        waitUntilElementLocated(by);
        WebElement elementToClick = driver.findElement(by);
        highlightElement(elementToClick);
        elementToClick.click();
    }

    public void sendKeysToElement (By by, String submitText) {

        waitUntilElementLocated(by);
        WebElement submitElement = driver.findElement(by);
        submitElement.clear();
        submitElement.sendKeys(submitText);
    }

    public String getTextFromAnElement (By by) {

        WebElement getTextElement = driver.findElement(by);
        return getTextElement.getText();
    }

    public void waitUntilPageLoaded() {

        new WebDriverWait(driver, WAIT_TIME).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void clickAnElementFromListWithText (List<WebElement> elementList, final String text) {

        boolean isElementHere = false;
        int indexOfElement = 0;
        for (int i=0; i <= elementList.size(); i++){
            if(elementList.get(i).getText().equals(text)) {
                indexOfElement = i;
                isElementHere = true;
                break;
            }
        }
        assertTrue("Item with text is not found in element list", isElementHere);
        highlightElement(elementList.get(indexOfElement));
        elementList.get(indexOfElement).click();
    }

    public String getTextOfAnElementFromList (List<WebElement> elementList, int index) {
        return elementList.get(index).getText().trim();
    }

    public void waitUntilElementVisible (By by) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
