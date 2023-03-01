package org.itstep;
import java.util.ArrayList;
import java.util.List;

public class ChatGPTDemo {

    public static void main(String[] args) {
        PecsExample.main(null);
    }

    public class PecsExample {

        // Method that takes a list of any subtype of Number and prints its elements
        public static void printNumbers(List<? extends Number> list) {
            for (Number num : list) {
                System.out.println(num);
            }
        }

        // Method that takes a list of any supertype of Integer and adds an Integer to it
        public static void addInteger(List<? super Integer> list) {
            list.add(42);
        }

        public static void main(String[] args) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            integerList.add(2);
            integerList.add(3);

            // The printNumbers method can take any list of any subtype of Number, so we can pass in an Integer list
            printNumbers(integerList);

            List<Number> numberList = new ArrayList<>();
            numberList.add(3.14);
            numberList.add(2.71);
            numberList.add(1.62);

            // The addInteger method can take any list of any supertype of Integer, so we can pass in a Number list
            addInteger(numberList);

            System.out.println(integerList); // Output: [1, 2, 3, 42]
            System.out.println(numberList); // Output: [3.14, 2.71, 1.62, 42]
        }
    }

}
