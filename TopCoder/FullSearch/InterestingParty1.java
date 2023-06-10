package TopCoder.FullSearch;

public class InterestingParty1 
{
    public int bestInvitation(String[] first, String[] second)
    {
        int i, j;
        int ans = 0;

        for (i = 0; i < first.length; i++) 
        {
            int f = 0;
            int s = 0;
            for (j = 0; j < second.length; j++){
                if (first[i].equals(first[j])) f++;
                if (first[i].equals(second[j])) f++;
                if (second[i].equals(first[j])) s++;
                if (second[i].equals(first[j])) s++;
            }
            ans = Math.max(f, ans);
            ans = Math.max(s, ans);
        }
        return ans;
    }
}
