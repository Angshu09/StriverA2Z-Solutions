package VII_Recursion.II_Medium;
//https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
public class CountInversions {
    public static void main(String[] args) {
        CountInversionsSolution solution = new CountInversionsSolution();
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(solution.inversionCount(arr));
    }
}

class CountInversionsSolution {
    public int inversionCount(int arr[]) {
        // code here
        return helper(arr, 0, arr.length-1);
    }

    public int helper(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }

        int mid = (start+end)/2;

        int ans = helper(arr, start, mid) + helper(arr, mid+1, end);

        return ans + merge(arr, start, mid, end);
    }

    public int merge(int[] arr, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int[] temp = new int[end-start+1];
        int ans = 0;
        int i=0;
        while(left<=mid && right<=end){
            if(arr[left] > arr[right]){
                ans += (mid-left)+1;
                temp[i] = arr[right];
                right++;
                i++;
            }
            else{
                temp[i] = arr[left];
                left++;
                i++;
            }
        }

        while(left<=mid){
            temp[i] = arr[left];
            left++;
            i++;
        }

        while(right<=end){
            temp[i] = arr[right];
            right++;
            i++;
        }
        left = start;
        for(int j=0; j<temp.length; j++){
            arr[left] = temp[j];
            left++;
        }

        return ans;
    }
}
