package com.imdb.utils;

import org.openqa.selenium.By;

public class Elements {

    // Google Elements
    public static By googleSearchResult     = By.xpath("//h3[@class='LC20lb DKV0Md']");
    public static By googleSearchImdbTitle  = By.cssSelector("[data-attrid='title']");

    // IMDb Home Page Elements
    public static By signInButton           = By.cssSelector("a[href='/registration/signin?ref=nv_generic_lgin']");
    public static By loginTextBox           = By.cssSelector(".imdb-header__account-toggle--logged-in");
    public static By mostPopulars           = By.cssSelector("[href='/what-to-watch/popular/?ref_=hm_watch_pop']");

    // IMDb Registration Page Elements
    public static By signImdbButton         = By.cssSelector(".list-group-item ");

    // IMDb Most Popular Page Elements
    public static By mostPopularHeader      = By.cssSelector(".ipc-title__text");
    public static By seriesContainer        = By.cssSelector(".ipc-lockup-overlay__screen");
    public static By titleOfSeries          = By.cssSelector("[data-testid='title']");

    // IMDb Series Page Elements
    public static By seriesNameInSeriesPage = By.cssSelector("[data-testid='hero-title-block__title']");
    public static By addToWatchlistButton   = By.cssSelector("[data-testid='tm-box-wl-button']");
    public static By goWatchlistButton      = By.cssSelector("a[href='/list/watchlist?ref_=nv_usr_wl_all_0']");

    // IMDb Watch List Page Elements
    public static By editWatchlistButton    = By.cssSelector("[title='Edit']");
    public static By watchlistSettings      = By.cssSelector(".list-edit-settings");
    public static By checkBoxButton         = By.cssSelector(".element-check-wrapper");
    public static By selectedElements       = By.cssSelector(".element-selected-total");
    public static By deleteItemsButton      = By.id("delete_items");
    public static By deletePopUpText        = By.id("delete_items_content");
    public static By acceptRequestButton    = By.cssSelector("input[value='DELETE']");
    public static By emptyWatchListText     = By.cssSelector(".list-number-items");

}
