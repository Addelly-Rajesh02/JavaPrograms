package datatypes.nonpremitive.array;

public class SingleDimensionArray
{

    public static int[] returnArray()
    {
        return new int[]{ 1,2,3,4,5,6,7,8,9};
    }

    public static void main(String[] args)
    {
        int[] arr = { 0,1,2,3,4,5,6,7,8};
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        int[] ar=returnArray();
        System.out.println();
        for(int i=0;i<n;i++) {
            System.out.print(ar[i]+" ");
        }
    }

}
