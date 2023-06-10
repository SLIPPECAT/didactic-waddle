package TopCoder.review;

public class KiwiJuiceEasyRev {

    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){

        for (int i = 0; i < toId.length; i++) {

            int f = fromId[i];
            int t = toId[i];
            
            int space = capacities[t] - bottles[t];

            int vol = Math.min(space, bottles[f]);

            bottles[f] -= vol;
            bottles[t] += vol;

            // int total = bottles[f]+bottles[t];
            // if (total > capacities[t]){
            //     bottles[f] -= space;
            //     bottles[t] += space;
            // } else {
            //     bottles[f] = 0;
            //     bottles[t] += bottles[f];
            // }
        }
        return bottles;
    }   
}