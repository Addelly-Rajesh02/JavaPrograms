package datatypes.nonpremitive.array;

public class TwoDimensionArray
{
    public static void main(String[] args)
    {
        int[][] arr;
        arr = new int[1][3];
        arr[0][0] = 3;
        arr[0][1] = 5;
        arr[0][2] = 7;
        System.out.println("arr[0][0] = " + arr[0][0]);
        System.out.println("arr[0][1] = " + arr[0][1]);
        System.out.println("arr[0][2] = " + arr[0][2]);
    }
}
