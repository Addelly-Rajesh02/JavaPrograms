package datatypes;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing {
        public static void main(String[] args) {
            int primitiveInt = 10;
            Integer wrapperInteger = primitiveInt;
            System.out.println("Primitive int: " + primitiveInt);
            System.out.println("Wrapper Integer (auto boxed): " + wrapperInteger);
            List<Integer> integerList = new ArrayList<>();
            integerList.add(20);
            System.out.println("List element (auto boxed): " + integerList.get(0));
        }
}