package practiseprograms.conversions;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class AnonymousToLambda {

    @FunctionalInterface
    interface MathOp {
        int apply(int x, int y);
        // NOTE: default or static methods are allowed and do not break @FunctionalInterface
        default MathOp andThen(MathOp after) {
            return (a, b) -> after.apply(this.apply(a, b), b);
        }
    }

    // A helper method for method reference demo
    public static void runTask() {
        System.out.println("Running via method reference");
    }

    public static void main(String[] args) throws Exception {

        // 1) Runnable
        Runnable rAnon = new Runnable() {
            @Override public void run() {
                System.out.println("Runnable: anonymous");
            }
        };
        Runnable rLambda = () -> System.out.println("Runnable: lambda");
        Runnable rMethodRef = AnonymousToLambda::runTask;

        new Thread(rAnon).start();
        new Thread(rLambda).start();
        new Thread(rMethodRef).start();

        // 2) Comparator
        Comparator<String> cmpAnon = new Comparator<String>() {
            @Override public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };
        Comparator<String> cmpLambda = (a, b) -> Integer.compare(a.length(), b.length());
        Comparator<String> cmpMethodRef = Comparator.comparingInt(String::length);

        List<String> list = Arrays.asList("Rajesh", "Anita", "Mohit", "Asha");
        list.stream().sorted(cmpMethodRef).forEach(System.out::println);

        // 3) ActionListener (Swing / AWT)
        Button button = new Button("Click");
        ActionListener lisAnon = new ActionListener() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Clicked (anonymous)");
            }
        };
        ActionListener lisLambda = e -> System.out.println("Clicked (lambda)");
        button.addActionListener(lisAnon);
        button.addActionListener(lisLambda);

        // 4) Callable
        Callable<Integer> callAnon = new Callable<Integer>() {
            @Override public Integer call() {
                return 7;
            }
        };
        Callable<Integer> callLambda = () -> 7;
        System.out.println("Callable anon: " + callAnon.call());
        System.out.println("Callable lambda: " + callLambda.call());

        // 5) Custom functional interface
        MathOp addAnon = new MathOp() {
            @Override public int apply(int x, int y) { return x + y; }
        };
        MathOp add = (x, y) -> x + y;
        MathOp mul = (x, y) -> x * y;

        System.out.println("Add anon: " + addAnon.apply(3, 5));
        System.out.println("Add lambda: " + add.apply(3, 5));
        System.out.println("Mul lambda: " + mul.apply(3, 5));

        // 6) Variable capture (effectively final)
        int factor = 2; // effectively final
        Runnable captured = () -> System.out.println("Captured: " + (factor * 10));
        captured.run();

        // 7) Method references in streams
        list.stream()
                .filter(AnonymousToLambda::isLongerThan4) // method reference to predicate
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static boolean isLongerThan4(String s) {
        return s.length() > 4;
    }
}