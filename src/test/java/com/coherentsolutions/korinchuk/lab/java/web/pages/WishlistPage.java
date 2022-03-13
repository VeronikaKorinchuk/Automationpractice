package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class WishlistPage extends BasePage{

    private static final String WISHLIST_URL = "index.php?fc=module&module=blockwishlist&controller=mywishlist";
    private static final String BESTSELLER_ITEM_LINK = "//*[@id='best-sellers_block_right']//a[@class='product-name'][contains(text(), '%s')]";
    private static final String VIEW_WISHLIST_ITEMS_BUTTON = "//a[contains(text(), '%s')]//ancestor::tr//descendant::a[contains(text(), 'View')]";
    private static final String WISHLIST_ITEM = "//ul[contains(@class, 'wlp_bought_list')]//img[contains(@alt, '%s')]";

    @FindBy(xpath = "//div[@id='block-history']//tbody/tr")
    private List<WebElement> wishlistLine;

    @FindBy(css = "#name")
    private WebElement newWishlistNameInput;

    @FindBy(id = "submitWishlist")
    private WebElement saveNewWishlistButton;


    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Open wishlist page")
    @Override
    public WishlistPage open() {
        super.open(WISHLIST_URL);
        return this;
    }

    public int getWishlistQuantity() {
        return wishlistLine.size();
    }

    @Step(value = "Open bestseller {0}")
    public ProductPage openBestseller(String bestsellerName) {
        driver.findElement(By.xpath(String.format(BESTSELLER_ITEM_LINK, bestsellerName))).click();
        return new ProductPage(driver);
    }

    public WishlistPage fillNewWishlistName(String newWishlistName) {
        newWishlistNameInput.sendKeys(newWishlistName);
        return this;
    }

    public WishlistPage saveNewWishlist() {
        saveNewWishlistButton.click();
        return this;
    }

    @Step(value = "Create new wishlist {0}")
    public WishlistPage createNewWishlist(String newWishlistName) {
        return fillNewWishlistName(newWishlistName).
                saveNewWishlist();
    }

    @Step(value = "View wishlist products")
    public WishlistPage viewWishlistProducts(String wishlist) {
        driver.findElement(By.xpath(String.format(VIEW_WISHLIST_ITEMS_BUTTON, wishlist))).click();
        return this;
    }

    public boolean isItemAppearsInWishlist(String itemName) {
        return driver.findElement(By.xpath(String.format(WISHLIST_ITEM, itemName))).isDisplayed();
    }
}
