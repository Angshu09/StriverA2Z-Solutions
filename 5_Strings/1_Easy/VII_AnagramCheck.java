package V_Strings.I_Easy;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram/description/
public class VII_AnagramCheck {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // Create a frequency array to count characters (assuming lowercase English letters)
        int[] freq = new int[26];

        // Increment the count for each character in string s
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;  // 'a' maps to index 0, 'b' to 1, ..., 'z' to 25
        }

        // Decrement the count for each character in string t
        for(char ch: t.toCharArray()){
            freq[ch - 'a']--;
        }

        // If all elements in the frequency array are 0,
        // then s and t have the same character counts, so they are anagrams
        for(int el: freq){
            if(el != 0){
                return false;  // Mismatch found in character counts
            }
        }

        return true;  // All counts matched — s and t are anagrams
    }

    public static boolean isAnagramBrute(String s, String t) {
        // Step 1: If lengths are not equal, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Convert both strings to character arrays
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // Step 3: Sort both arrays
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Step 4: Compare sorted arrays element by element
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false; // Found a mismatch, not anagrams
            }
        }

        return true; // All characters matched, strings are anagrams
    }
}
