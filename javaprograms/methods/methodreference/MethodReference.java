package methods.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReference {

    //Type 1: static method reference
    public static Boolean isPalindrome(int number){
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;         // get last digit
            reversed = reversed * 10 + digit; // build reversed number
            number = number / 10;            // remove last digit
        }
        return original == reversed;
    }

    public static void main(String[] args){
        List<Integer> numbers=List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14);

        System.out.println("Palindromes in the list are: "+numbers.stream()
                .filter(MethodReference::isPalindrome)//Method 1: implemented in filter()
                .toList());

        //Type 2: method reference to instance method of a specific object
        InstanceMethod instanceMethod= new InstanceMethod();
        Consumer<String> consumer=instanceMethod::display;
        consumer.accept("Hii Iam instance method of specific object");

        //Type 3: method reference of an arbitrary object of a particular type
        String names[]={"Rajesh","Ramu","Ammu"};
        Arrays.sort(names,String::compareToIgnoreCase);
        System.out.println("Sorted names: ");
        for(String name: names){
            System.out.println(name);
        }

        //Type 4: Constructor reference
        Supplier<ConstructorReference> supplier=ConstructorReference::new;
        ConstructorReference constructorReference=supplier.get();
    }

}
