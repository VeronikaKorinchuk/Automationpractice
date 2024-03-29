package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{

    static Logger logger = Logger.getLogger(AccountPage.class);
    private static final String ACCOUNT_URL = "index.php?controller=my-account";

    @FindBy(css = "[title='View my customer account']")
    private WebElement accountIcon;

    @FindBy(css = ".lnk_wishlist")
    private WebElement myWishlistButton;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Open account page")
    @Override
    public AccountPage open() {
        super.open(ACCOUNT_URL);
        return this;
    }

    public boolean isAccountIconVisible() {
        logger.info("Definition is account icon visible");
        return accountIcon.isDisplayed();
    }

    @Step(value = "Open wishlists")
    public WishlistPage openWishlists() {
        logger.info("Open wishlists");
        myWishlistButton.click();
        return new WishlistPage(driver);
    }

}
