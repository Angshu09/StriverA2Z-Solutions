package III_Arrays.II_Medium;

//https://leetcode.com/problems/majority-element/description/

import java.util.HashMap;

public class III_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElementBrute(arr));
        System.out.println(majorityElementBetter(arr));
        System.out.println(majorityElementOptimal(arr));
    }

    private static int majorityElementOptimal(int[] arr){
        //Moore’s voting algo
        //TC - 2n ---> n

        int count = 0;
        int ele = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(count == 0){
                ele = arr[i];
                count = 1;
            }
            else if(arr[i] == ele){
                count++;
            }
            else{
                count--;
            }

        }

        int tempCount = 0;

        for(int num: arr){
            if(num == ele){
                tempCount++;
            }
        }

        if(tempCount > n/2){
            return ele;
        }

        return -1;
    }

    private static int majorityElementBetter(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

         for(int i=0; i<nums.length; i++){ //O(n)
             if(map.containsKey(nums[i])){
                 map.put(nums[i], map.get(nums[i]) + 1);
             }
             else{
                 map.put(nums[i], 1);
             }
         }

         for(int key: map.keySet()){ //O(k) where k is the size of te map
             if(map.get(key) > nums.length/2){
                 max = Math.max(max, key);
             }
         }

         //TC - O(N)+O(K) ---> O(N)
         //SC - O(N) if the k is equal to n

        return max;
    }

    private static int majorityElementBrute(int[] arr){
        //TC - O(n^2)

        for (int num : arr) {

            int count = 0;
            for (int i : arr) {
                if (num == i) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return num;
            }
        }

        return -1;
    }


}
