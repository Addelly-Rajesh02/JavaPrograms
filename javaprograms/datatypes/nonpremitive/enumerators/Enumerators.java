package datatypes.nonpremitive.enumerators;

public class Enumerators
{
    enum Day
    {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
    public static void main(String[] args)
    {
        Day today = Day.SUNDAY;
        System.out.println("Today is: " + today);
            if (today == Day.SUNDAY)
            {
                System.out.println("It's the weekend!");
            }
            else
            {
                System.out.println("Time to work!");
            }
    }
}
