package java8features.lambdaexpressions;

public class ScopeOfVariablesClass {
    int temp=0;

    public void show(){
        int count=0; // this must be final

        ScopeOfVariables check=()-> {
            int countt=1;
            System.out.println("Hii");
            System.out.println("Temp:"+(++temp));
            System.out.println("Bye"+count);
            System.out.println("Bye"+(++countt));
            //System.out.println("Count++ is not allowed"+(++count));
        };
        check.display();
        //count++; This is also not allowed
    }
}
