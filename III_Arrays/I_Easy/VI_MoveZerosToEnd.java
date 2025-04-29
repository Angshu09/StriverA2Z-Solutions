package III_Arrays.I_Easy;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class VI_MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 4, 0, 5};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    //TC - O(N)

    private static void moveZeros(int[] arr){
        int n = arr.length;
        if(n == 1) return;

        int j=-1;

        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1) return;

        for(int i=j+1; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
