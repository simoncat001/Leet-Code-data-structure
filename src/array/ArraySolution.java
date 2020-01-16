package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySolution {
    public static void main(String[] args) {
        ArraySolution a = new ArraySolution();
        int[] b = new int[]{9, 9};
    }

//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int count = 0;
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;
//            } while (start != current);
//        }
//    }

    /**
     * 31 下一个排列.
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] <= nums[i + 1]) {
            // 找到字典顺序临界节点
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                //右侧字典顺序临界节点
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if(sum > target) {
                    end--;
                } else if(sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }

    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[i]) {
                result--;
            } else {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return result;
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while(start != current);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {
        int move = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[move] = num;
                move++;
            }
        }
        while(move < nums.length) {
            nums[move] = 0;
            move++;
        }
    }

    public void moveZeroes1(int[] nums) {
        int move = 0;
        int nonZero = 0;
        while(move < nums.length) {
            if(nums[move] != 0) {
                nums[nonZero] = nums[move];
                nonZero++;
            }
            move++;
        }
        while(nonZero < nums.length) {
            nums[nonZero] = 0;
            nonZero++;
        }
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        for(int i = digits.length - 1; i >= 0; i--) {
            if(i == digits.length - 1) {
                result[i] += (digits[i] + 1) / 10;
                result[i + 1] = (digits[i] + 1) % 10;
            } else {
                result[i] += (digits[i] + result[i + 1]) / 10;
                result[i + 1] = (digits[i] + result[i + 1]) % 10;
            }
        }
        if(result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }


    public int longestCommonSubsequence(String text1, String text2) {
        if("".equals(text1) || "".equals(text2) || text1 == null || text2 == null) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

}

