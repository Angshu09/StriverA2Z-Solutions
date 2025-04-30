package III_Arrays.I_Easy;

import java.util.HashMap;

//https://leetcode.com/problems/single-number/
public class XI_SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(findSingleNumberWithSpace(arr));
        System.out.println(findSingleNumber(arr));
    }

    //It uses space
    private static int findSingleNumberWithSpace(int[] arr){
        int n = arr.length;
        if(n == 1) return arr[0];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
        }

        for(Integer key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }

        return -1;
    }

    //Without Space
    private static int findSingleNumber(int[] arr){
        int n = arr.length;
        if(n == 1) return arr[0];

        int ans = arr[0];

        for(int i=1; i<n; i++){
            ans ^= arr[i];
        }

        return ans;
    }

}
