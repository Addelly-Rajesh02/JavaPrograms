package exceptions.customexceptions;

public class BankAccount {
    double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds to withdraw " + amount);
        }
        balance -= amount;
    }

}
