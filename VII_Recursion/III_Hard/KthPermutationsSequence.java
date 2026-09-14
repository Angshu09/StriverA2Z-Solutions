package VII_Recursion.III_Hard;
//https://leetcode.com/problems/permutation-sequence/description/
import java.util.ArrayList;

public class KthPermutationsSequence {
    public static void main(String[] args) {
        int n = 3;
        int k = 1;

        KthPermutationsSequenceSolution solution = new KthPermutationsSequenceSolution();
        System.out.println(solution.getPermutation(n, k));
    }
}

class KthPermutationsSequenceSolution {
    public String getPermutation(int n, int k) {
        k = k-1; //0 based indexing

        ArrayList<Integer> list = new ArrayList<>();

        int fact = 1;

        for(int i=1; i<n; i++){
            fact *= i; //calculate fact of n-1 numbers
            list.add(i);
        }
        list.add(n); //at last added n

        StringBuilder sb = new StringBuilder();

        while(true){
            String ans = Integer.toString(list.get(k/fact));
            sb.append(ans);
            list.remove(k/fact);

            if(list.size() == 0){
                break;
            }

            k %= fact;
            fact /= list.size();
        }

        return sb.toString();
    }
}
