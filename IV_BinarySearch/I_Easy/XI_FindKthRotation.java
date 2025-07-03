package IV_BinarySearch.I_Easy;

import java.util.ArrayList;

public class XI_FindKthRotation {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: arr){
            list.add(num);
        }
        System.out.println(findKRotation(list));
    }

    public static int findKRotation(ArrayList<Integer> arr) {
        // Code here
        int low = 0;
        int high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(low) <= arr.get(high)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    index = low;
                }
                break;
            }
            else if(arr.get(low) <= arr.get(mid)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    index = low;
                }
                low = mid+1;
            }
            else{
                if(arr.get(mid) < ans){
                    ans = arr.get(mid);
                    index = mid;
                }
                high = mid-1;
            }
        }

        return index;
    }
}
