package TopCoder.FullSearch;

public class InterestingParty {

    public static int bestInvitation(String[] first, String[] second){
        String ft = first[0];
        String st = second[0];
        int result = 0;

        for (int i = 0; i < second.length; i++) {
            if(ft.equals(first[i]) || st.equals(second[i]))
                result ++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] first = {"a", "b", "c", "d"};
        String[] second = {"e", "e", "f", "e"};  
        

        int result = bestInvitation(first, second);
        System.out.println(result);
    }
}
