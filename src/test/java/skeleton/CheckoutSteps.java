package skeleton;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by thiru on 5/15/17.
 */
public class CheckoutSteps {
    Checkout checkout = new Checkout();
    int bananaPrice = 0;

    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        bananaPrice = price;
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //checkout = new Checkout();
        checkout.add(itemCount, bananaPrice);
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //checkout = new Checkout();

        assertEquals(total, checkout.total());
    }

    class Checkout {
        int runningTotal = 0;
        public void add(int count, int price) {
            runningTotal += (count * price);
        }

        public int total() {
            return runningTotal;
        }
    }
}
