import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int currentSize = 0;
    public static int getBiggestRegion(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int largest = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    dfs(i, j, matrix, visited);
                    largest = Math.max(largest, currentSize);
                    currentSize = 0;
                }
            }
        }
        return largest;
    }
    
    static void dfs(int row, int col, int[][] matrix, boolean[][] visited){
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        currentSize++;
        for(int k = 0; k < 8; k++){
            int newRow = row + dx[k];
            int newCol = col + dy[k];
            if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length){
                if(matrix[newRow][newCol] == 1 && !visited[newRow][newCol]){
                    dfs(newRow, newCol, matrix, visited);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
