public class DynamicProgramming {
    public static int numDecodings(String s) {
        if(s.equals("") || s.equals("0")){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char [] arr = s.toCharArray();
        int len = arr.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 1;
        if(arr[1]!='0'){
            if((arr[0]-'1'> 1) || (arr[1]-'1')>5){
                dp[2] = 1;
            }else {
                dp[2] = 2;
            }
        }else {
            if(arr[0]-'1'>5){
                return 0;
            }
        }
        
        for(int i=3; i<len+1; i++){
            if(arr[i]!='0'){
                if((arr[i-2]-'1') >1 || (arr[i-1])-'1'>5){
                    dp[i] = dp[i-1];
                } else {
                    dp[i] = dp[i-1]+dp[i-2];
                }
            } else {
                if(arr[i-2]-'1'>5){
                    return 0;
                }else {
                    dp[i] = dp[i-2];
                }
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        System.out.println(DynamicProgramming.numDecodings("226"));
    }
}
