package nicebank.steps;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nicebank.Money;
import nicebank.support.KnowsTheDomain;
import nicebank.transforms.MoneyConverter;
import org.junit.Assert;

public class AccountSteps {

    private KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper)
    {
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount)
            throws Throwable
    {
        helper.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        Assert.assertEquals("Incorrect account balance - ",
                amount, helper.getMyAccount().getBalance());
    }

}
