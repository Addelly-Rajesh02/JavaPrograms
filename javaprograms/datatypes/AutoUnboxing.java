package datatypes;

public class AutoUnboxing {
    public static void main(String[] args) {
        Integer wrapperInteger = 50;
        int primitiveInt = wrapperInteger;
        System.out.println("Wrapper Integer: " + wrapperInteger);
        System.out.println("Primitive int (unboxed): " + primitiveInt);

        Double wrapperDouble = 15.5;
        double result = wrapperDouble + 4.5;
        System.out.println("Result of operation (unboxed): " + result);
    }
}