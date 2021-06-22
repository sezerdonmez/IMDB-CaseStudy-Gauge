package com.imdb.utils;

import org.openqa.selenium.By;

public class Elements {

    public static By googleSearchResult     = By.xpath("//h3[@class='LC20lb DKV0Md']");
    public static By loginTextBox           = By.xpath("//span[@class='imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle navbar__user-name navbar__user-menu-toggle__name navbar__user-menu-toggle--desktop']");
    public static By mostPopulars           = By.cssSelector("a[href='/what-to-watch/popular/?ref_=hm_watch_pop']");
    public static By seriesContainer        = By.xpath("//a[@class='ipc-lockup-overlay ipc-focusable']");
    public static By signImdbButton         = By.cssSelector("a[href='https://www.imdb.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.imdb.com%2Fregistration%2Fap-signin-handler%2Fimdb_us&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=imdb_us&openid.mode=checkid_setup&siteState=eyJvcGVuaWQuYXNzb2NfaGFuZGxlIjoiaW1kYl91cyIsInJlZGlyZWN0VG8iOiJodHRwczovL3d3dy5pbWRiLmNvbS8_cmVmXz1sb2dpbiJ9&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&tag=imdbtag_reg-20']");
    public static By signInButton           = By.cssSelector("a[href='/registration/signin?ref=nv_generic_lgin']");
    public static By seriesTitle            = By.xpath("a[@href='/title/tt11083552/news?ref_=tt_nwr_sm']");
    public static By addToWatchlistButton   = By.xpath("//button[@class='ipc-button uc-add-wl-button-icon--add watchlist--title-main-desktop-standalone ipc-button--core-base ipc-button--single-padding ipc-button--default-height']");
    public static By goWatchlistButton      = By.cssSelector("a[href='/list/watchlist?ref_=nv_usr_wl_all_0']");
    public static By editWatchlistButton    = By.xpath("//a[@class='button']");
    public static By checkBoxButton         = By.xpath("//div[@class='element-check-wrapper']");
    public static By deleteItemsButton      = By.id("delete_items");
    public static By comboBox               = By.xpath("//div[@class='verify']");
    public static By acceptRequestButton    = By.cssSelector("input[value='DELETE']");

}
