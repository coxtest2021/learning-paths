package nicebank.actors;

import nicebank.Money;

public class Account {
    private Money balance = new Money();

    public void credit(Money amount)
    {
        balance = balance.addMoney(amount);
    }

    public Money getBalance()
    {
        return balance;
    }

    public void debit(int dollars) {
        balance = balance.minus(new Money(dollars, 0));
    }
}
