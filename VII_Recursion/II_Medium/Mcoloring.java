package VII_Recursion.II_Medium;
//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
import java.util.HashMap;

public class Mcoloring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int v = 4;
        int m = 3;
        int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};

        boolean ans = solution.graphColoring(v, edges, m);
        System.out.println(ans);
    }
}

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<v; i++) {
            map.put(i, -1);
        }
        return helper(v, 0, edges, m, map);
    }

    boolean helper(int v, int node, int[][] edges, int m, HashMap<Integer, Integer> map) {
        if (node == v) {
            return true;
        }

        for (int color = 1; color <= m; color++) {

            if (possible(node, color, edges, map)) {
                map.put(node, color);
                if(helper(v, node + 1, edges, m, map)){
                    return true;
                }
                map.put(node, -1);
            }

        }

        return false;
    }

    boolean possible(int node, int color, int[][] edges, HashMap<Integer, Integer> map) {
        for (int i = 0; i<edges.length; i++) {
            for (int j = 0; j<2; j++) {
                if (edges[i][j] == node) {
                    if (j == 1) {
                        if (map.get(edges[i][0]) == color)
                            return false;
                    }
                    if (map.get(edges[i][1]) == color)
                        return false;
                }
            }
        }

        return true;
    }
}






