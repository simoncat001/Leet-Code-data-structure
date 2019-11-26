package backTracking;

import java.util.*;

/**
 * @author simoncat
 */
public class BackTrackSolution {
    /**
     * 17. 电话号码的字母组合
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> digitMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> result = new LinkedList<>();
        if(digits.length() == 0) {
            return result;
        }
        backTrack(digits, digitMap, 0, result, "");
        return result;
    }

    public void backTrack(String digits, Map<Character, String> digitMap, int cur, List<String> result, String res) {
        if(cur == digits.length()) {
            result.add(res);
        } else {
            char digit = digits.charAt(cur);
            String currStr = digitMap.get(digit);
            for(int i = 0; i < currStr.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                if(!"".equals(res)){
                    stringBuilder.append(res);
                }
                stringBuilder.append(currStr.charAt(i));
                backTrack(digits, digitMap, cur + 1, result, stringBuilder.toString());
            }
        }
    }

    /**
     * 22. 括号生成
     */
    public List<String> generateParenthesis(int n) {
        int length = n*2;

        return null;
    }

    public void parenthesisBt(int n, Stack<String> stack, String res) {

    }






















}
