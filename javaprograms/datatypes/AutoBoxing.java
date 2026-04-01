package datatypes;

public class AutoBoxing {
        public static void main(String[] args) {
            int primitiveInt = 10;
            Integer wrapperInteger = primitiveInt;
            System.out.println("Primitive int: " + primitiveInt);
            System.out.println("Wrapper Integer (autoboxed): " + wrapperInteger);
            java.util.List<Integer> integerList = new java.util.ArrayList<>();
            integerList.add(20);
            System.out.println("List element (autoboxed): " + integerList.get(0));
        }
}