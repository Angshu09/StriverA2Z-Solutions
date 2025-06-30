package IV_BinarySearch.I_Easy;
//https://www.geeksforgeeks.org/problems/implement-upper-bound/1
public class III_ImplementUpperBound {
    public static void main(String[] args) {
         int[] arr = {2, 3, 7, 10, 11, 11, 25};
         int target = 11;
        System.out.println(upperBound(arr, target));
    }

    private static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ub = arr.length;

        while(start <= end){
            int mid = start + (end-start) /2;

            if(arr[mid] > target){
                ub = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ub;

    }
}
