package III_Arrays.I_Easy;
//https://leetcode.com/problems/max-consecutive-ones/description/
public class X_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr= {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    private static int findMaxConsecutiveOnes(int[] arr){
        int n = arr.length;
        if(n == 1 && arr[0] == 1){
            return 1;
        }

        int max = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                ++count;
            }
            else{
                count = 0;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
