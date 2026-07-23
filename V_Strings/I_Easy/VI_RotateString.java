package V_Strings.I_Easy;

public class VI_RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "bcdea";
        System.out.println(rotateString(s, goal));
    }

    //Optimal solution
    //Important NOTE - If a concatenate  a string with itself, it will contain all rotations as a substring in it...

    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        s = s+s;
        if(s.contains(goal)){
            return true;
        }
        return false;
    }

    //Brute force solution
    //O(m) times (for loop) × [O(m) for rotate + O(m) for equals]
    // = O(m × (m + m))
    // = O(m × 2m)
    // = O(m²)
    // public boolean rotateString(String s, String goal) {
    //     int m = s.length();
    //     int n = goal.length();

    //     for(int i=1; i<=m; i++){ //
    //         String rotated = rotate(s, i);
    //         if(rotated.equals(goal)){
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    // public String rotate(String str, int d){
    //     d = d%str.length();
    //     return str.substring(d) + str.substring(0, d);
    // }
}
