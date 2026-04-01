package simplejavaprogram;
import java.util.Scanner;

public class UserInput
{
    //public static void main(String[] args)
    //public static void main(String... args)
    //public static void main(String args[])
    static public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any numeric value:");
        int a = scanner.nextInt();
        System.out.println("Values of a:" + a);
    }
}
