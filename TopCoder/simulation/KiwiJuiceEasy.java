package TopCoder.simulation;

class KiwiJuiceEasy {
    
    public static int[] thePouring(int[] capacities, int[] bottles, int[] toId, int[] fromId){

        for (int i = 0; i < toId.length; i++)
        {
            bottles[toId[i]] += bottles[fromId[i]];
            if (bottles[toId[i]] <= capacities[toId[i]]){
                System.out.println("작을 때");
            }        
            if (bottles[toId[i]] > capacities[toId[i]]){
                System.out.println("클 때");
                bottles[fromId[i]] = bottles[toId[i]] - capacities[toId[i]];
                bottles[toId[i]] = capacities[toId[i]];
                return bottles;

            } else if(bottles[fromId[i]] == 0){
                return bottles;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] capacities = {10, 10};
        int[] bottles = {5, 8};
        int[] fromId = {0};
        int[] toId = {1};

        int[]arr= thePouring(capacities, bottles, toId, fromId);
        
        for (int i : arr){
            System.out.println(i);
        }
    
    }

}
