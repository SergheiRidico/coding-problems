import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        int[] array = {1, 22, 43, -87, -99, 99, 99, 14, 83, -25, 0, 15};

        if (args.length < 3) {
            System.out.println("Number of input arguments is less then 3! Default array is used:");
            System.out.println(Arrays.toString(array));
        } else {
            int[] intArray = new int[args.length];

            for (int i = 0; i < args.length; i++) {
                intArray[i] = Integer.parseInt(args[i]);
            }

            array = intArray;
        }

        findThreeMaximums(array);
    }

    public static void findThreeMaximums(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            if (value > first) {
                third = second;
                second = first;
                first = value;
            } else if (value > second && value != first) {
                third = second;
                second = value;
            } else if (value > third && value != first & value != second) {
                third = value;
            }
        }

        if (third == Integer.MIN_VALUE) {
            System.out.println("There are no three largest distinct numbers in your array. \n" +
                "Or array contains minimal integer value: -2147483648. \n" +
                "Or it contains only duplicates. \n" +
                "Please try again with another input!");

            return;
        }

        System.out.printf("First largest distinct number is: %d\n", first);
        System.out.printf("Second largest distinct number is: %d\n", second);
        System.out.printf("Third largest distinct number is: %d\n", third);
    }
}
