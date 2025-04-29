package III_Arrays.I_Easy;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

public class III_CheckSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5};

        int[] arr2 = {3, 4, 5, 1, 2};

        System.out.println(isSorted(arr));

        System.out.println(isSortedRotated1(arr2));

        System.out.println(isSortedRotated2(arr2));
    }

    //This will simply check the array is sorted or not
    private static boolean isSorted(int[] arr){
        int n = arr.length;
        if(n == 1){
            return true;
        }

        for(int i=1; i<n; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }

        return true;
    }

    //This will simply check if the array is sorted and rotated or not
    //Approach 1
    private static boolean isSortedRotated1(int[] arr){
        int n = arr.length;
        if(n == 1){
            return true;
        }

        int count = 0;

        for(int i=1; i<n; i++){
            if(arr[i-1] > arr[i]){
                count++;
            }
        }

        if(arr[n-1] > arr[0]) {
            count++;
        }

        return count <= 1; //if count remains 0 or 1 then it is sorted or rotated sorted
    }

    //This will also simply check if the array is sorted and rotated or not...
    //Approach 2
    private static boolean isSortedRotated2(int[] arr){
        int n = arr.length;
        if(n == 1){
            return true;
        }

        int count = 0;

        for(int i=0; i<n; i++){
            //It checks the adjacent and first & last elemnt also...
            if(arr[i] > arr[(i +1) % n]){
                count++;
            }

            if(count > 1){
                return false;
            }
        }

        return true;
    }


}
