package III_Arrays.II_Medium;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/

public class I_TwoSum {
    public static void main(String[] args) {
       int[] arr = {1, 2, 4, 12, 19, 7};
       int target = 9;
        System.out.println(Arrays.toString(find2SumIndexesBrute(arr, target)));
        System.out.println(Arrays.toString(find2SumIndexesBetter(arr, target)));
        System.out.println(Arrays.toString(find2SumIndexesOptimal(arr, target)));
    }


    //This approach takes O(n^2) TC
    private static int[] find2SumIndexesBrute(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return new int[]{-1, -1};
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    //It takes O(n log n) TC and O(n) space, This approach is useful I don't want to use hashmap
    private static int[] find2SumIndexesBetter(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return new int[]{-1, -1};
        }

        int[] temp = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);

        int el1 = -1;
        int el2 = -1;

        int left = 0;
        int right = n-1;

        while(left<right){
            int sum = temp[left] + temp[right];
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                el1 = temp[left];
                el2 = temp[right];
                break;
            }
        }

        if(el1 == -1 && el2 == -1){
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        int idx = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == el1 && idx < 2){
                result[idx] = i;
                idx++;
                continue;
            }
            if(arr[i] == el2 && idx < 2){
                result[idx] = i;
                idx++;
            }
        }

        return result;
    }

    //This approach takes TC-O(N), SC-O(N)
    private static int[] find2SumIndexesOptimal(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int require = target - arr[i];
            if(map.containsKey(require)){
                return new int[]{i, map.get(require)};
            }
            else{
                map.put(arr[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
