package exceptions;

public class InBuiltExceptions
{
    public static void main(String[] args)
    {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. " + e.getMessage());
        }

        finally {
            System.out.println("Finally block executed.");
        }

        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer encountered. " + e.getMessage());
        }
    }

    public static int divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0)
        {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return numerator / denominator;
    }
}
