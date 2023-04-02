import java.util.Arrays;

public class Code {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, -3, -54, 54, 54, 92, 99, 99};

        if (args.length < 2) {
            System.out.println("Number of input arguments is less then 2! Default array is used:");
            System.out.println(Arrays.toString(array));
        } else {
            int[] passedArray = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
            array = passedArray;
        }

        findMaximums(array);
    }

    public static void findMaximums(int[] array) {
        int firstMaximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];

            if (currentNumber > firstMaximum) {
                secondMaximum = firstMaximum;
                firstMaximum = currentNumber;
            } else if (currentNumber < firstMaximum && currentNumber > secondMaximum) {
                secondMaximum = currentNumber;
            }
        }

        if (secondMaximum == Integer.MIN_VALUE) {
            System.out.println("There is no second largest number in array. \n" +
                "Or array contains minimal integer value: -2147483648. \n" +
                "Or it contains only duplicates. \n" +
                "Please try again with another input!");
            return;
        }

        System.out.println("First maximum is: " + firstMaximum);
        System.out.println("Second maximum is: " + secondMaximum);
    }
}
