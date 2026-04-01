package typecastings;

public class NarrowTypeCasting
{
    public static void main(String[] args)
    {
        int num = 1;
        System.out.println("The value of " + num + " after converting to the double is " + (double) num);
        int convertedInt = (int) (double) num;
        System.out.println("The value of " + (double) num + " after converting to the int again is " + convertedInt);
    }
}
