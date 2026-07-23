package IV_BinarySearch.I_Easy;
//https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
public class VII_CountTheTotalNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 3, 3, 4, 7};
        int target = 3;
        System.out.println(countFreq(arr, target));
    }

    private static int countFreq(int[] arr, int target) {
        // code here

        //we have to just find first and last occurrence  and + 1
        int first = search(arr, target, true);
        if(first == -1){
            return 0;
        }
        int last = search(arr, target, false);

        return (last-first)+1;
    }

    private static int search(int[] arr, int target, boolean isFirst){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(arr[mid] == target){
                ans = mid;
                if(isFirst){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}
