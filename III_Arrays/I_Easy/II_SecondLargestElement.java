package III_Arrays.I_Easy;

/*
    Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.


    Examples:
    Input: nums = [8, 8, 7, 6, 5]

    Output: 7

    Explanation: The largest value in nums is 8, the second largest is 7
 */

public class II_SecondLargestElement {
    public static void main(String[] args) {
        System.out.println(findSecondLargest(new int[]{1, 2, 6, 7, 19, 20}));
    }

    private static int findSecondLargest(int[] arr){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }

        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i] > fmax){
                smax = fmax;
                fmax = arr[i];
            }
            else if(arr[i] > smax && arr[i] < fmax){
                smax = arr[i];
            }
        }

        return smax;
    }

    //    Only one loop → O(n)
}
