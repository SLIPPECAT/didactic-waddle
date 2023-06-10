package TopCoder.simulation;

public class KiwiJuiceEasy4 {
    
    public int[] thePouring(int[] capacities, int[] bottles, int[] toId, int[] fromId)
    {
        for (int i = 0; i < fromId.length; i++) 
        {
            int f = fromId[i];
            int t = toId[i];

            int sum = bottles[f] + bottles[t];
            bottles[t] = Math.min(sum, capacities[t]);
            bottles[f] = sum - bottles[t];

        }
        return bottles;
    }
}
