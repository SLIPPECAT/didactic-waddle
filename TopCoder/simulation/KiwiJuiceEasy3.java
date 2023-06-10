package TopCoder.simulation;

public class KiwiJuiceEasy3 {
    
    public int[] thePouring(int[] capacities, int[] bottles, int[] toId, int[] fromId){

        for (int i = 0; i < fromId.length; i++) 
        {
            
            int f = fromId[i];
            int t = toId[i];
            // 감탄밖에 안나오네
            int vol = Math.min(bottles[f], capacities[t] - bottles[t]);

            bottles[f] -= vol;
            bottles[t] += vol;

        }
        return bottles;
    }

}
