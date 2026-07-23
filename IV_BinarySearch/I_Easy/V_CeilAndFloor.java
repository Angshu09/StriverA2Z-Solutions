package IV_BinarySearch.I_Easy;
//https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401?leftPanelTabValue=PROBLEM
//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
//https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
import java.util.Arrays;

public class V_CeilAndFloor {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 8, 8, 10};
        int target = 5;
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, target)));
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {

        int start = 0;
        int end = n-1;
        int floor = -1;
        int ceil = -1;
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(a[mid] == x){
                floor = ceil = x;
                break;
            }
            else if(a[mid] <= x){
                floor = a[mid];
                start = mid+1;
            }
            else{
                ceil = a[mid];
                end = mid-1;
            }
        }
        return new int[]{floor, ceil};
    }
}
