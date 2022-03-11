package com.coherentsolutions.korinchuk.lab.java.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{

    private static final String ACCOUNT_URL = "index.php?controller=my-account";

    @FindBy(css = "[title='View my customer account']")
    private WebElement accountIcon;

    @FindBy(css = ".lnk_wishlist")
    private WebElement myWishlistButton;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AccountPage open() {
        super.open(ACCOUNT_URL);
        return this;
    }

    public boolean isAccountIconVisible() {
        return accountIcon.isDisplayed();
    }

    public WishlistPage openWishlists() {
        myWishlistButton.click();
        return new WishlistPage(driver);
    }

}
