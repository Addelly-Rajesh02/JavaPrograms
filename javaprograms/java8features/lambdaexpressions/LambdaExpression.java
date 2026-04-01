package java8features.lambdaexpressions;

import java.util.Arrays;
import java.util.List;
public class LambdaExpression{
    public static void main(String[] args) {
        Lambda myLambda = message -> System.out.println("Lambda says: " + message);
        myLambda.UsedForFunctionalInterface("Hello, Java!");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println("Number: " + n));

        ScopeOfVariablesClass scopeOfVariablesClass=new ScopeOfVariablesClass();
        scopeOfVariablesClass.show();
    }
}