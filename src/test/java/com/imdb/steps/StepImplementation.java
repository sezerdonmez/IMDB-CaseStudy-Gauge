package com.imdb.steps;

import com.imdb.base.BaseTest;
import com.imdb.utils.Elements;
import com.thoughtworks.gauge.Step;
import org.apache.commons.lang.ObjectUtils;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

import static com.imdb.utils.Elements.*;

public class StepImplementation extends BaseTest {

    @Step("<url> adresine git")
    public void openUrl(String url) {

        driver.get(url);
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(GOOGLE_TITLE)) {
            System.out.println("Home page openned");
        } else {
            System.out.println("Home page openning failure: Titles not equal");
        }

    }

    @Step("<saniye> saniye bekle")
    public void staticWait(int sec) {

        try {
            Thread.sleep(sec * 1000);
            System.out.println("Waited " + sec + " seconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<name> nameli input nesnesini bul ve <text> textini gir")
    public void findElementByName(String name, String text) {

        WebElement googleSearchInput = driver.findElement(By.name(name));
        googleSearchInput.clear();
        highlightElement(googleSearchInput);
        googleSearchInput.sendKeys(text);
    }

    @Step("<name> nameli butona tikla")
    public void findButtonByName(String name) {

        WebElement googleSearchButton = driver.findElement(By.name(name));
        highlightElement(googleSearchButton);
        googleSearchButton.click();
    }

    @Step("ilk siradaki arama sonucuna tikla")
    public void clickFirstSearch() {

        waitUntilElementLocated(googleSearchResult);
        WebElement firstSearchResult = driver.findElement(googleSearchResult);
        firstSearchResult.click();
    }

    @Step("imdb web sitesine gidildigini dogrula")
    public void checkTitles() {

        String actualTitle = driver.getTitle();
        if (actualTitle.equals(IMDB_TITLE)) {
            System.out.println("IMDb web site opened");
        } else {
            System.out.println("Web site opening failure: Titles not equal");
        }
    }

    @Step("Sign in butonuna tikla")
    public void clickSignIn(){

        WebElement imdbSignInButton = driver.findElement(signInButton);
        highlightElement(imdbSignInButton);
        imdbSignInButton.click();
    }

    @Step("<email> adresini <id> li alana ve <password> bilgisini <idpass> li alana gir ve <button> ile giris yap")
    public void login(String eMail, String id, String password, String idp, String button){

        waitUntilElementLocated(signImdbButton);
        WebElement signInWithIMDb = driver.findElement(signImdbButton);
        highlightElement(signInWithIMDb);
        signInWithIMDb.click();
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(IMDB_SIGN_IN)){
            System.out.println("IMDb sign in page opened");
        }
        else {
            System.out.println("Web site opening failure: Titles not equal");
        }

        waitUntilElementLocated(By.id(id));
        WebElement inputEmail = driver.findElement(By.id(id));
        inputEmail.clear();
        inputEmail.sendKeys(eMail);

        WebElement inputPassword = driver.findElement(By.id(idp));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id(button));
        signInButton.click();

    }

    @Step("<text> isimli Kullanici girisi yapildi mi kontrol et")
    public void checkLogin(String name){

        WebElement checkLogin = driver.findElement(loginTextBox);
        String actualTitle = checkLogin.getText();
        if (actualTitle.equals(name)){
            System.out.println("User logged in");
        }
        else {
            System.out.println("User logging failure");
        }
    }

    @Step("En populer filmlere git")
    public void openMostPopularMovies(){

        waitUntilElementLocated(mostPopulars);
        WebElement mostPopularButton = driver.findElement(mostPopulars);
        scrollToElement(mostPopularButton);
        mostPopularButton.click();
    }

    @Step("Dizilerden rastgele dizi sec")
    public void chooseRandomSeri(){

        List <WebElement> series = driver.findElements(seriesContainer);
        deleteFirst12ElementsFromList(series);
        WebElement randomSerie = chooseRandomElementFromList(series);
        scrollToElement(randomSerie);
        randomSerie.click();
    }

    @Step("Dizi sayfasina gidildigini kontrol et")
    public void controlSeriesPage(){

        WebElement seriesNameTitle = driver.findElement(seriesTitle);
        String titleText = seriesNameTitle.getText();
        if(!titleText.isEmpty()){
            System.out.println("Dizi sayfasi acildi");
        }
        else {
            System.out.println("Dizi sayfasi acilamadi");
        }
    }

    @Step("Diziyi Watchliste ekle")
    public void addWatchList(){

        waitUntilElementLocated(addToWatchlistButton);
        WebElement addWatchlist = driver.findElement(addToWatchlistButton);
        scrollToElement(addWatchlist);
        highlightElement(addWatchlist);
        addWatchlist.click();
    }

    @Step("Watchlist sayfasina git")
    public void controlWatchList(){

        waitUntilElementLocated(goWatchlistButton);
        WebElement watchListButton = driver.findElement(goWatchlistButton);
        scrollToElement(watchListButton);
        highlightElement(watchListButton);
        watchListButton.click();
    }

    @Step("Watchlist sayfasini temizle")
    public void deleteWatchListMovie(){

        waitUntilElementLocated(editWatchlistButton);
        WebElement editButton = driver.findElement(editWatchlistButton);
        editButton.click();
        WebElement checkBox = driver.findElement(checkBoxButton);
        checkBox.click();
        WebElement deleteItems = driver.findElement(deleteItemsButton);
        deleteItems.click();
        waitUntilElementLocated(acceptRequestButton);
        WebElement acceptRequest = driver.findElement(acceptRequestButton);
        acceptRequest.click();
    }
}
