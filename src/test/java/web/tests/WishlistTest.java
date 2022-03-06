package web.tests;

import org.testng.annotations.Test;
import web.pages.AuthenticationPage;
import web.pages.WishlistPage;

import static org.testng.Assert.assertEquals;

public class WishlistTest extends BaseTest{

    public static final String EMAIL = "testAccount2102@yandex.by";
    public static final String PASSWORD = "password2102";

    @Test
    public void testAddAutoCreatedWishlistSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        WishlistPage wishlistPage = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                openWishlists();
        int wishlistQuantityBeforeAdding = wishlistPage.
                        getWishlistQuantity();
        assertEquals(wishlistQuantityBeforeAdding, 0, "Wishlist isn't empty");
        wishlistPage.
                openProduct().
                addToWishlist();
        int wishlistQuantityAfterAdding = wishlistPage.
                open().
                getWishlistQuantity();
        assertEquals(wishlistQuantityAfterAdding, 1, "Product isn't added to wishlist");
    }
}
