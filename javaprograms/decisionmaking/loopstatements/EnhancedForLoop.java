package decisionmaking.loopstatements;

public class EnhancedForLoop {
    public static void main(String[] args)
    {
        String[] names = { "C Language", "Java", "C++" };
        for (String name : names)
        {
            System.out.println("Name: " + name);
        }

        int[] number={1,2,3,4,5,6,7,8,9};
        for(int p:number)
        {
            System.out.print(" "+p);
        }

    }
}
