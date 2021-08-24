package com.imdb.steps;

import com.imdb.base.BaseTest;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static com.imdb.utils.Elements.*;

public class StepImplementation extends BaseTest {

    @Step("Go to <url> address")
    public void openUrl (String url) {

        driver.get(url);
        String actualTitle = driver.getTitle();
        assertThat(actualTitle, equalTo(GOOGLE_TITLE));

    }

    @Step("Wait <second> seconds before next scenario")
    public void staticWait (int sec) {

        try {
            Thread.sleep(sec * 1000L);
            System.out.println("Waited " + sec + " seconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Find <name> input field submit <text> text")
    public void findElementByName (String name, String text) {
        WebElement googleSearchInput = driver.findElement(By.name(name));
        sendKeysToElement(By.name(name), text);
        googleSearchInput.sendKeys(Keys.ESCAPE);
        assertThat(googleSearchInput.getAttribute("value"), equalTo(text));
    }

    @Step("Click <name> named google search button")
    public void clickButtonByName (String name) {

        clickAndHighlightAnElement(By.name(name));
        waitUntilPageLoaded();
        assertThat(getTextFromAnElement(googleSearchImdbTitle), equalTo("IMDb"));
    }

    @Step("Click first searching result")
    public void clickFirstSearch () {

        clickAnElement(googleSearchResult);
        waitUntilPageLoaded();
    }

    @Step("Confirm that successfully viewed IMDb web site")
    public void checkTitles () {

        String actualTitle = driver.getTitle();
        assertThat(actualTitle, equalTo(IMDB_TITLE));
    }

    @Step("Click Sign-In button")
    public void clickSignIn () {

        clickAnElement(signInButton);
        waitUntilPageLoaded();
        String actualTitle = driver.getTitle();
        assertThat(actualTitle, equalTo("Sign in with IMDb - IMDb"));
    }

    @Step("Go to Sign-In Page")
    public void goToSignIn () {

        List<WebElement> registrationPageItems = driver.findElements(signImdbButton);
        clickAnElementFromListWithText(registrationPageItems, SIGN_IN_TEXT);
        String actualTitle = driver.getTitle();
        assertThat(actualTitle, equalTo(IMDB_SIGN_IN));
    }

    @Step("Submit the <email> adress to <id> and <password> to <idpass> and click <button> for sign-in")
    public void login (String eMail, String id, String password, String idp, String button) {

        sendKeysToElement(By.id(id), eMail);

        sendKeysToElement(By.id(idp), password);

        clickAnElement(By.id(button));

        waitUntilPageLoaded();
    }

    @Step("Check that can <username> named user sign in")
    public void checkLogin (String name) {

        List<WebElement> loginTextBoxList = driver.findElements(loginTextBox);
        String actualName = getTextOfAnElementFromList(loginTextBoxList, 1);
        assertThat(actualName, equalTo(name));
    }

    @Step("Go most popular films")
    public void openMostPopularMovies () {

        clickAndHighlightAnElement(mostPopulars);
        waitUntilPageLoaded();
        assertThat(getTextFromAnElement(mostPopularHeader), equalTo("What to Watch"));
    }

    @Step("Choose a series randomly from series list")
    public void chooseRandomSeries () {

        List <WebElement> series = driver.findElements(seriesContainer);
        List <WebElement> titleSeries = driver.findElements(titleOfSeries);
        deleteElementsFromList(12, series);
        deleteElementsFromList(12, titleSeries);
        WebElement randomSeries = chooseRandomElementFromList(series);
        titleOfChosenElement = titleSeries.get(indexOfChosenElement).getText();
        scrollToElement(randomSeries);
        randomSeries.click();
    }

    @Step("Control series page opened successfully")
    public void controlSeriesPage () {

        waitUntilPageLoaded();
        assertThat(titleOfChosenElement, equalTo(getTextFromAnElement(seriesNameInSeriesPage)));

    }

    @Step("Add series to watch list")
    public void addWatchList () {

        clickAndHighlightAnElement(addToWatchlistButton);
        waitUntilPageLoaded();
    }

    @Step("Go users watch list page")
    public void controlWatchList () {

        clickAndHighlightAnElement(goWatchlistButton);
        waitUntilPageLoaded();
        assertThat(driver.getTitle(), equalTo(WATCHLIST_TITLE));
    }

    @Step("Click edit button in watchlist page")
    public void clickEditWatchlist () {

        clickAnElement(editWatchlistButton);
        waitUntilElementVisible(watchlistSettings);
    }

    @Step("Click item selection check box button for select all items")
    public void clickCheckBox () {

        clickAnElement(checkBoxButton);
        assertThat(1, equalTo(Integer.parseInt(driver.findElement(selectedElements).getText())));
    }

    @Step("Click DELETE button on watchlist edit page")
    public void clickDeleteButton () {


        clickAndHighlightAnElement(deleteItemsButton);
        waitUntilElementVisible(deletePopUpText);

    }
    @Step("Clear the users watch list page")
    public void deleteWatchListChoices () {

        clickAnElement(acceptRequestButton);
        driver.navigate().refresh();
        assertThat("0", equalTo(driver.findElement(emptyWatchListText).getText()));
    }
}
