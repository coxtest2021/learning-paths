package nicebank.actors;

import nicebank.actors.Account;
import nicebank.actors.CashSlot;

public class Teller {

    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot)
    {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars)
    {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
