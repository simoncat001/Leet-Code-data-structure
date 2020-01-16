package recursion;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int climbStairs(int n) {
        if (n <=2){
            return n;
        }
        int [] result = new int [n+1];
        for (int i=0; i<=2; i++){
            result[i] = i;
        }
        for(int i = 3; i<=n; i++){
            result [i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
    
    public int climbStairs2(int n) {
        if (n <=1){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        for(int i = 3; i<=n; i++){
            int temp1 = n2;
            n2 = n1 + n2;
            n1 = temp1;
        }
        return n2;
    }
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        generate(0, 0, n, null);
        return result;
    }
    
    private void generate(int left, int right, int terminator, String curr){
        if (left==terminator&&right==terminator){
            result.add(curr);
        }
        if(right>left||left>3){
            return;
        }else {
            generate(left+1, right, terminator, curr+"(");
            generate(left, right+1, terminator, curr+")");
        }
    }
    
    
    
}
