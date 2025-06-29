package III_Arrays.III_Hard;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/merge-intervals/description/
public class VII_MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] ans = mergeBrute(arr);
        int[][] ans = mergeOptimal(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(Arrays.toString(ans[i]) + ", ");
        }
    }

    private static int[][] mergeBrute(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> pairs = new ArrayList<>();

        for(int i=0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(!pairs.isEmpty() && end <= pairs.getLast()[1]){
                continue;
            }

            for(int j=i+1; j<n;j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }
                else{
                    break;
                }
            }
            pairs.add(new int[]{start, end});

        }

        int[][] ans = new int[pairs.size()][];
        for(int i=0; i< pairs.size(); i++){
            ans[i] = pairs.get(i);
        }
        return ans;
    }

    private static int[][] mergeOptimal(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> pairs = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(pairs.isEmpty() || arr[i][0] > pairs.getLast()[1]){
                pairs.add(arr[i]);
            }
            else{
                pairs.getLast()[1] = Math.max(arr[i][1], pairs.getLast()[1]);
            }
        }

        int[][] ans = new int[pairs.size()][];
        for(int i=0; i< pairs.size(); i++){
            ans[i] = pairs.get(i);
        }
        return ans;
    }
}
