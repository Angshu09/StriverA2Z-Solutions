package VII_Recursion.II_Medium;
//https://leetcode.com/problems/palindrome-partitioning/description/
import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> p = new ArrayList<>();
        helper(s, 0, p, ans);
        return ans;
    }

    public static void helper(String s, int index, ArrayList<String> p, ArrayList<ArrayList<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                p.add(s.substring(index, i+1));
                helper(s, i+1, p, ans);
                p.remove(p.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
