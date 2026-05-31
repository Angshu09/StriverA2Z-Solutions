package IV_BinarySearch.I_Easy;
//https://www.geeksforgeeks.org/problems/implement-lower-bound/1
public class II_ImplementLowerBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;
        System.out.println(lowerBound(arr, target));

    }
    private static int lowerBound(int[] arr, int target) {
        // code here
        int start = 0;
        int end = arr.length-1;
        int lb = arr.length;

        while(start <= end){
            int mid = start + (end-start) /2;

            if(arr[mid] >= target){
                lb = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return lb;
    }
}
