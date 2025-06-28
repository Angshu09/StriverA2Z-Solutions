package III_Arrays.III_Hard;
//https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

import java.util.HashMap;

public class VI_CountTheSubArraysWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subArrayXor(arr, k));
    }

    public static int subArrayXor(int arr[], int k) {
        // code here
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            xr ^= arr[i];
            int y = xr^k;

            if(xr == k){
                count++;
            }
            if(map.get(y)!=null){
                count += map.get(y);
            }

            if(map.get(xr) != null){
                map.put(xr, map.get(xr)+1);
            }
            else{
                map.put(xr, 1);
            }
        }

        return count;
    }
}
