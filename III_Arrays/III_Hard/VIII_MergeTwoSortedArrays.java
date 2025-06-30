package III_Arrays.III_Hard;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class VIII_MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        int m = 3;
        int n = arr2.length;
        merge(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }

//     public static void merge(int[] nums1, int m, int[] nums2, int n) {
////         for(int i=0; i<n; i++){
////             nums1[n+m-1-i] = nums2[i];
////         }
////         Arrays.sort(nums1);
////     }

    //Brute force, using Space, tc-O(n+m)+O(n+m), sc-O(n+m)
//     public static void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] temp = new int[n+m];
//         int left = 0;
//         int right = 0;
//         int index = 0;
//
//         while(left < m && right < n){
//             if(nums1[left]  <= nums2[right]){
//                 temp[index] = nums1[left];
//                 left++;
//                 index++;
//             }
//             else{
//                 temp[index] = nums2[right];
//                 right++;
//                 index++;
//             }
//         }
//
//         while(left < m){
//             temp[index++] = nums1[left++];
//         }
//
//         while(right < n){
//             temp[index++] = nums2[right++];
//         }
//
//         for(int i=0; i<n+m; i++){
//             nums1[i] = temp[i];
//         }
//     }

    //Optimal solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int gap = (len/2) + (len%2);

        while(gap > 0){
            int left = 0;
            int right = left + gap;

            while(right < len){
                //nums1 and nums2
                if(left < m && right >= m){
                    swapIfGreater(nums1, nums2, left, right-m);
                }
                //nums2 and nums2
                else if(left >= m){
                    swapIfGreater(nums2, nums2, left-m, right-m);
                }
                //nums1 and nums1
                else{
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }

        for(int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
    }
    private static void swapIfGreater(int[] nums1, int[] nums2, int i, int j){
        if(nums1[i] > nums2[j] ){
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }
}
