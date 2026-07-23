package III_Arrays.I_Easy;

public class VII_LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 12, 78, 12, 5, 10};
        System.out.println(linearSearch(arr, 12));
    }

    private static int linearSearch(int[] arr, int target){
        for(int i=0 ; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
