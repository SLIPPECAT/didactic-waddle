package TopCoder.FullSearch;

public class Cryptography1{

    public static long encrypt(int[] numbers)
    {
        long min = numbers[0];
        long result = 1;
        for (int i = 0; i < numbers.length; i++) {
               if (min > numbers[i])
                    min = numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 6};

        System.out.println(encrypt(arr));
    }
}