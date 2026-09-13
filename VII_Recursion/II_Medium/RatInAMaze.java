package VII_Recursion.II_Medium;
//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        RatInAMazeSolution1 solution1 = new RatInAMazeSolution1();
        RatInAMazeSolution2 solution2 = new RatInAMazeSolution2();
        System.out.println(solution1.ratInMaze(maze));
        System.out.println(solution2.ratInMaze(maze));
    }
}

class RatInAMazeSolution2{
    public ArrayList<String> ratInMaze(int[][] maze){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        if(maze[0][0] == 0){
            return ans;
        }
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        int n  = maze.length;
        int[][] isVisit = new int[n][n];

        helper(0, 0, maze, isVisit, sb, ans,  di, dj);

        return ans;
    }

    public void helper(int i, int j, int[][] maze, int[][] isVisit, StringBuilder sb, ArrayList<String> ans, int[] di, int[]dj){
        if(i==maze.length-1 && j==maze.length-1){
            ans.add(sb.toString());
            return;
        }
        String[] direction = {"D", "L", "R", "U"};
        for(int k=0; k<4; k++){
            int nextI = i+di[k];
            int nextJ = j+dj[k];
            if(nextI >= 0 && nextJ >=0 && nextI < maze.length && nextJ < maze.length && isVisit[nextI][nextJ] == 0 && maze[nextI][nextJ] == 1){
                isVisit[i][j] = 1;
                sb.append(direction[k]);
                helper(nextI, nextJ, maze, isVisit, sb, ans,  di, dj);
                sb.delete(sb.length()-1, sb.length());
                isVisit[i][j] = 0;
            }
        }
    }
}


class RatInAMazeSolution1 {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here

        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        if(maze[0][0] == 0){
            return ans;
        }
        int n  = maze.length;
        int[][] isVisit = new int[n][n];
        isVisit[0][0] = 1;

        helper(0, 0, maze, isVisit, sb, ans);
        return ans;
    }

    public void helper(int i, int j, int[][] maze, int[][] isVisit, StringBuilder sb, ArrayList<String> ans){
        if(i == maze.length-1 && j == maze.length-1){
            ans.add(sb.toString());
            return;
        }

        if(isDownSafe(i+1, j, maze, isVisit)){
            isVisit[i+1][j] = 1;
            sb.append("D");
            helper(i+1, j, maze, isVisit, sb, ans);
            isVisit[i+1][j] = 0;
            sb.delete(sb.length()-1, sb.length());
        }

        if(isLeftSafe(i, j-1, maze, isVisit)){
            isVisit[i][j-1] = 1;
            sb.append("L");
            helper(i, j-1, maze, isVisit, sb, ans);
            isVisit[i][j-1] = 0;
            sb.delete(sb.length()-1, sb.length());
        }

        if(isRightSafe(i, j+1, maze, isVisit)){
            isVisit[i][j+1] = 1;
            sb.append("R");
            helper(i, j+1, maze, isVisit, sb, ans);
            isVisit[i][j+1] = 0;
            sb.delete(sb.length()-1, sb.length());
        }

        if(isUpSafe(i-1, j, maze, isVisit)){
            isVisit[i-1][j] = 1;
            sb.append("U");
            helper(i-1, j, maze, isVisit, sb, ans);
            isVisit[i-1][j] = 0;
            sb.delete(sb.length()-1, sb.length());
        }

    }

    public boolean isDownSafe(int i, int j, int[][] maze, int[][] isVisit){
        if(i < maze.length && maze[i][j] == 1 && isVisit[i][j] == 0){
            return true;
        }

        return false;
    }

    public boolean isLeftSafe(int i, int j, int[][] maze, int[][] isVisit){
        if(j >= 0 && maze[i][j] == 1 && isVisit[i][j] == 0){
            return true;
        }

        return false;
    }

    public boolean isRightSafe(int i, int j, int[][] maze, int[][] isVisit){
        if(j < maze.length && maze[i][j] == 1 && isVisit[i][j] == 0){
            return true;
        }

        return false;
    }

    public boolean isUpSafe(int i, int j, int[][] maze, int[][] isVisit){
        if(i >= 0 && maze[i][j] == 1 && isVisit[i][j] == 0){
            return true;
        }

        return false;
    }

}


