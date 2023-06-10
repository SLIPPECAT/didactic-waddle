package TopCoder.simulation;

public class KiwiJuiceEasy2 {
    
    public int[] thePouring(int[] capacities, int[] bottles, int[] toId, int[] fromId){

        for (int i = 0; i < fromId.length; i++) 
        {
            
            int f = fromId[i];
            int t = toId[i];
            int space = capacities[t] - bottles[t];

            if (space >= bottles[f]){
                int vol = bottles[f];
                bottles[t] += vol;
                bottles[f] = 0;
            } else {
                int vol = space;
                bottles[t] += vol;
                bottles[f] -= vol;
            }
        }
        return bottles;
    }

}
