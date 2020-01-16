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
        if (digits.length() == 0) {
            return result;
        }
        backTrack(digits, digitMap, 0, result, "");
        return result;
    }
    
    public void backTrack(String digits, Map<Character, String> digitMap, int cur, List<String> result, String res) {
        if (cur == digits.length()) {
            result.add(res);
        } else {
            char digit = digits.charAt(cur);
            String currStr = digitMap.get(digit);
            for (int i = 0; i < currStr.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!"".equals(res)) {
                    stringBuilder.append(res);
                }
                stringBuilder.append(currStr.charAt(i));
                backTrack(digits, digitMap, cur + 1, result, stringBuilder.toString());
            }
        }
    }
    
    /**
     * 22. 括号生成
     * 难点在于随时判断括号是否有效
     * 当 left - right > length - cur
     * 或者
     * right > left 时
     */
    public List<String> generateParenthesis(int n) {
        int length = n * 2;
        Queue<Character> queue = new LinkedList<>();
        List<String> result = new LinkedList<>();
        parenthesisBt(0, result, "", 0, 0, length);
        return result;
    }
    
    public void parenthesisBt(int cur, List<String> result, String res, int left, int right, int length) {
        if (cur == length) {
            result.add(res);
        } else {
            cur++;
            for (int i = 0; i < 2; i++) {
                StringBuilder builder = new StringBuilder();
                builder.append(res);
                if (i == 0) {
                    builder.append('(');
                    int cur_left = left + 1;
                    if (cur_left - right <= length / 2) {
                        //在这里检查是否有效
                        parenthesisBt(cur, result, builder.toString(), cur_left, right, length);
                    }
                } else {
                    int cur_right = right + 1;
                    if (cur_right <= left) {
                        //在这里检查是否有效
                        builder.append(')');
                        parenthesisBt(cur, result, builder.toString(), left, cur_right, length);
                    }
                }
            }
        }
    }
    
    /**
     * 40.组合总和 II
     * 难点在于判断重复组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationBt(result, target, candidates, new ArrayList<>(), 0);
        return result;
    }
    
    public void combinationBt(List<List<Integer>> result, int target, int[] candidates, List<Integer> res, int cur) {
        if (0 == target) {
            result.add(res);
        } else {
            for (int i = cur; i < candidates.length; i++) {
                List<Integer> curList = new ArrayList<>(res);
                int temp = target - candidates[i];
                if (temp >= 0) {
                    if (i > cur && candidates[i] == candidates[i - 1]) {
                        //因为这个数和上个数相同，所以从这个数开始的所以情况，在上个数里面都考虑过了，需要跳过
                        continue;
                    }
                    curList.add(candidates[i]);
                    combinationBt(result, temp, candidates, curList, i + 1);
                }
            }
        }
    }
    
    /**
     * 47.全排列 II
     * 难点在于判断重复组合
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rest = new ArrayList();
        Arrays.sort(nums);
        for (int x : nums) {
            rest.add(x);
        }
        permuteUniqueBt(result, rest, new ArrayList<>());
        return result;
    }
    
    public void permuteUniqueBt(List<List<Integer>> result, List<Integer> rest, List<Integer> cur) {
        if (rest.size() == 0) {
            result.add(cur);
        } else {
            for (int x = 0; x < rest.size(); x++) {
                if (x > 0 && rest.get(x) == rest.get(x - 1)) {
                    continue;
                }
                List<Integer> arr = new LinkedList<>(rest);
                arr.remove(x);
                List<Integer> curList = new ArrayList<>(cur);
                curList.add(rest.get(x));
                permuteUniqueBt(result, arr, curList);
            }
        }
    }
    
    
    /**
     * 60. 第k个排列
     * 不用回溯，反而更快。
     */
    public String getPermutation(int n, int k) {
        boolean[] flag = new boolean[n];
        StringBuilder stringBuilder = new StringBuilder();
        int up = 0;
        int down = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < flag.length; j++) {
                if (!flag[j]) {
                    up = down + 1;
                    down = up + factorial(n - 1 - i) - 1;
                    if (up <= k && k <= down) {
                        stringBuilder.append(j + 1);
                        flag[j] = true;
                        break;
                    }
                }
            }
            down = up - 1;
        }
        return stringBuilder.toString();
    }
    
    public int factorial(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++){
            r *= i;
        }
        return r;
    }
    
    public static void main(String[] args) {
        BackTrackSolution bs = new BackTrackSolution();
        String res = bs.getPermutation(3, 3);
        System.out.println(res);
    }
}
