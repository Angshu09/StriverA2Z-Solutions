package V_Strings.I_Easy;

public class I_RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;  // nesting level

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    result.append(ch);
                }
                count++;
            } else {  // ch == ')'
                count--;
                if (count > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
