package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class WishlistPage extends BasePage{

    private static final String WISHLIST_URL = "index.php?fc=module&module=blockwishlist&controller=mywishlist";

    @FindBy(xpath = "//div[@id='block-history']//tbody/tr")
    private List<WebElement> wishlistLine;

    @FindBy(css = "a.product-name")
    private List<WebElement> products;

    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WishlistPage open() {
        super.open(WISHLIST_URL);
        return this;
    }

    public int getWishlistQuantity() {
        return wishlistLine.size();
    }

    public ProductPage openProduct() {
        products.get(0).click();
        return new ProductPage(driver);
    }
}
