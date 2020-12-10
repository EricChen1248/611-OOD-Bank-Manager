import java.math.BigDecimal;

//this is the main bank account for the bank manager
public class BankMainAccount extends BankAccount {
    public BankMainAccount(int account_id, int user_id, String currency, BigDecimal balance) {
        super(account_id, user_id, currency, balance, AccountType.BANK);
    }
}
