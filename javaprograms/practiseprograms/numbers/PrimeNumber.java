package practiseprograms.numbers;

public class PrimeNumber {
    public static int primeNumbers(int n){
        int flag=0;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                flag=1;
                break;
            }
        }
        if(flag==1)
            return 0;
        return 1;
    }

    public static void alternatePrimeNumbers(int n){
        int l=0;
        for(int i=2;i<=n;i++){
            if(primeNumbers(i)==1){
                if(l%2==0){
                    System.out.print(i+" ");
                }
                l++;
            }
        }
    }
}
