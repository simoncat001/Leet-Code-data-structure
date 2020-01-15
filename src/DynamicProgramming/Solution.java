package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Executors;

public class Solution {
    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
    
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }
    
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int dp[] = new int[len];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
    
    public int uniquePaths1(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i = 0; i<m; i++) dp[i][0]=1;
        for(int i = 0; i<n; i++) dp[0][i]=1;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                dp[j] +=dp[j-1] ;
            }
        }
        return dp[n-1];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        char [] arr1 = text1.toCharArray();
        char [] arr2 = text2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        int [][] result = new int[m+1][n+1];
        for(int i = 0; i<=m; i++) result[i][0]=0;
        for(int i = 0; i<=n; i++) result[0][i]=0;
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(arr1[i-1] == arr2[j-1]){
                    result[i][j] = result[i-1][j-1]+1;
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }
        return result[m][n];
    }
    
    public int climbStairs(int n) {
        if (n<=2) return n;
        int pre=1;
        int cur=1;
        for(int i = 3; i<=n; i++){
            int temp = cur;
            cur = pre+cur;
            pre = temp;
        }
        return cur;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int [] dp = new int[height];
        for (int i = 0; i < height; i++) dp[i] = triangle.get(height - 1).get(i);
        for (int i = height - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];
    }
    
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
