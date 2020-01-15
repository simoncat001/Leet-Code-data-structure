import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {
    public static int numDecodings(String s) {
        if (s.equals("") || s.equals("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (arr[1] != '0') {
            if ((arr[0] - '1' > 1) || (arr[1] - '1') > 5) {
                dp[2] = 1;
            } else {
                dp[2] = 2;
            }
        } else {
            if (arr[0] - '1' > 5) {
                return 0;
            }
        }
        
        for (int i = 3; i < len + 1; i++) {
            if (arr[i] != '0') {
                if ((arr[i - 2] - '1') > 1 || (arr[i - 1]) - '1' > 5) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                if (arr[i - 2] - '1' > 5) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            }
        }
        return dp[len];
    }
    
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        
        map.put("city", "320500");
        map.put("district", "320513");
        map.put("key", "白塘");
        
        String baseUrl = "http://url/home-guarantee/communities?";
        for (String key : map.keySet()) {
            baseUrl += key + "=" + map.get(key);
        }
        HttpRequest request = new BasicHttpRequest();
        
        try {
            request.doGetRequest(new URL("http://47.103.175.73/home-guarantee/communities?city=320500&district=320508&key=仁恒公园世纪"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
