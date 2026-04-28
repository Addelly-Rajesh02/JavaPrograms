package java8features.functionalinterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };
        System.out.println(p.test(1));
        System.out.println(p.test(3));
        System.out.println(p.test(2));
        System.out.println(p.test(4));

//        Function<Integer,String> f=new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) {
//                if(integer==1)
//                    return "Hello";
//                return "chalo";
//            }
//        };
//        System.out.println(f.apply(1));
//        System.out.println(f.apply(2));
//
//        Consumer<String> c=new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
//        c.accept("Hello");
//
//        Supplier<String> s=new Supplier<String>() {
//            @Override
//            public String get() {
//                return "Iam Supplier";
//            }
//        };
    }
}