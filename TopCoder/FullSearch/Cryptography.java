package TopCoder.FullSearch;

public class Cryptography{

    public long encrypt(int[] numbers)
    {
        long result = 0;
        for (int i = 0; i < numbers.length; i++) 
        {
            long temp = 1;
            for (int j = 0; j < numbers.length; j++) 
            {
                if ( i == j){
                    temp *= (numbers[j + 1]);
                } else {
                    temp *= numbers[j];
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}