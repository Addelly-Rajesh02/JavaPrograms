package exceptions.customexceptions;

public class CustomException
{
    public static void main(String[] args)
    {
        //BankAccount account = new BankAccount(100.0);
        BankAccount account = new BankAccount(150.0);
        try {
            account.withdraw(10.0);
            System.out.println("Withdrawal successful.");
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
