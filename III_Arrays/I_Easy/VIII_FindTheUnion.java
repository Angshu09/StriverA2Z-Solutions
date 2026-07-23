package III_Arrays.I_Easy;

import java.util.HashSet;
import java.util.Arrays;

public class VIII_FindTheUnion {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 2, 2, 2, 10};

        System.out.println(Arrays.toString(findUnionElementsArray(arr1, arr2)));
        System.out.println(findUnionElementsWithoutSpace(arr1, arr2));
    }

    private static int[] findUnionElementsArray(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        int[] ans = new int[set.size()];

        int i=0;
        for(Integer ele: set){
            ans[i] = ele;
            i++;
        }

        return ans;
    }

    private static int findUnionElementsWithoutSpace(int[] arr1, int[] arr2){
        int[] temp = new int[arr1.length +  arr2.length];

        for(int i=0; i< arr1.length; i++){
            temp[i] = arr1[i];
        }

        for(int i=0; i< arr2.length; i++){
            temp[i + arr1.length] = arr2[i];
        }

        Arrays.sort(temp);

        int count = 1;

        for(int i=1; i< temp.length; i++){
            if(temp[i] != temp[i-1]){
                count++;
            }
        }

        return count;
    }


}
