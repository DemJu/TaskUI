package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class MyStorePage {
    @Getter
    private static final String BASE_URL = "http://automationpractice.com";

    private final SelenideElement buttonBasket = $(By.cssSelector("a[title='View my shopping cart']"));
    private final SelenideElement searchInputElements = $(By.cssSelector("input[name='search_query']"));
    private final SelenideElement searchButton = $(By.cssSelector("button[name='submit_search']"));
    private final SelenideElement foundProduct = $(By.cssSelector("img[class='replace-2x img-responsive']"));
    private final SelenideElement purchaseButton = $(By.cssSelector("button[name='Submit'] span"));
    private final SelenideElement buttonCloseOrderWindow = $(By.cssSelector("span[title='Close window']"));
    private final SelenideElement contentsBasket = $(By.cssSelector("a[title='View my shopping cart'] span"));
    private final SelenideElement empty = $(By.cssSelector(".ajax_cart_no_product"));
    private final SelenideElement buttonDeletingItemShoppingCart = $(By.cssSelector(".icon-trash"));
    private final SelenideElement productAdditionButton = $(By.cssSelector(".icon-plus"));
    private final SelenideElement productDecreaseButton = $(By.cssSelector(".icon-minus"));
}
