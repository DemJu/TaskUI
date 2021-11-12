package steps;

import com.codeborne.selenide.*;
import exceptions.CheckingSiteResults;
import exceptions.ErrorSiteProcessing;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.MyStorePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class MyStoreSteps {
    private static WebDriver driver;

    @Given("^I open my store search page$")
    public void openSearchPage() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);

        driver = new ChromeDriver(capabilities);

        driver.manage()
                .window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS);

        WebDriverRunner.setWebDriver(driver);
        Selenide.open(MyStorePage.getBASE_URL());
    }


    @Given("^I click on the basket button$")
    public void clickBasketIcon() {
        MyStorePage myStore = new MyStorePage();
        myStore.getButtonBasket()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        assertNotEquals(MyStorePage.getBASE_URL(), driver.getCurrentUrl());
    }

    @When("^I write text \"(.+)\" to search input$")
    public void setTextToInput(String searchText) {
        MyStorePage myStore = new MyStorePage();
        myStore.getSearchInputElements()
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .setValue(searchText);
    }

    @And("^I click button to search it$")
    public void clickToSearch() {
        MyStorePage myStore = new MyStorePage();
        myStore.getSearchButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        assertNotEquals(MyStorePage.getBASE_URL(), driver.getCurrentUrl());
    }

    @Then("^I click on the found product$")
    public void clickToProduct() {
        MyStorePage myStore = new MyStorePage();
        myStore.getFoundProduct()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        assertNotEquals(MyStorePage.getBASE_URL(), driver.getCurrentUrl());
    }

    @And("^I click on the buy product button$")
    public void clickBuyProductButton() {
        MyStorePage myStore = new MyStorePage();
        myStore.getPurchaseButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @And("I click the button to close the order preview window$")
    public void clickClosingPreviewWindow() {
        Selenide.sleep(10000);
        MyStorePage myStore = new MyStorePage();
        myStore.getButtonCloseOrderWindow()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @And("^I check that the basket is not empty$")
    public void emptinessBasket() {
        MyStorePage myStore = new MyStorePage();
        try {
            System.out.println(
                    ErrorSiteProcessing.basketNotEmpty(Integer.valueOf(myStore.getContentsBasket()
                            .shouldBe(Condition.enabled, Condition.visible)
                            .getText())));
        } catch (CheckingSiteResults e) {
            e.printStackTrace();
            fail();
        }
    }

    @Then("^Deleting an item from the shopping cart$")
    public void deletingItem() {
        MyStorePage myStore = new MyStorePage();
        myStore.getButtonDeletingItemShoppingCart()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @And("^I will check that the basket is empty$")
    public void emptyBasket() {
        //Selenide.sleep(5000);
        MyStorePage myStore = new MyStorePage();
        try {
            System.out.println(
                    ErrorSiteProcessing.basketEmpty(myStore.getEmpty()
                            .shouldBe(Condition.enabled, Condition.visible)
                            .getText()));
        } catch (CheckingSiteResults e) {
            e.printStackTrace();
            fail();
        }
    }

    @And("^I click on the increase the quantity of goods button$")
    public void increaseQuantityGoods() {
        MyStorePage myStore = new MyStorePage();
        myStore.getProductAdditionButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @And("^I click on the button to reduce the number of products$")
    public void reduceQuantityGoods() {
        MyStorePage myStore = new MyStorePage();
        myStore.getProductDecreaseButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        Selenide.sleep(30000);
    }

    @And("^Let's check that there is \"(.+)\" product in the basket$")
    public void quantityGoodsBasket(Integer count) {
        MyStorePage myStore = new MyStorePage();
        try {
            System.out.println(
                    ErrorSiteProcessing.productСart(Integer.valueOf(myStore.getContentsBasket()
                            .shouldBe(Condition.enabled, Condition.visible)
                            .getText()), count));
        } catch (CheckingSiteResults e) {
            e.printStackTrace();
            fail();
        }
    }

    @After
    public void closeDriver() {
        Selenide.sleep(5000);
        driver.quit();
    }
}
