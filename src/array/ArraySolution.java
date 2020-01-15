package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
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
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
    
    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {
        int move = 0;
        for(int num: nums){
            if (num!=0){
                nums[move] = num;
                move++;
            }
        }
        while (move<nums.length){
            nums[move] = 0;
            move++;
        }
    }
    
    public void moveZeroes1(int[] nums) {
        int move = 0;
        int nonZero = 0;
        while (move<nums.length){
            if(nums[move]!=0){
                nums[nonZero] = nums[move];
                nonZero++;
            }
            move++;
        }
        while (nonZero<nums.length){
            nums[nonZero] = 0;
            nonZero++;
        }
    }
    
    public int[] plusOne(int[] digits) {
        int [] result = new int[digits.length+1];
        for(int i = digits.length-1; i>=0; i--){
            if (i==digits.length-1){
                result[i] += (digits[i]+1)/10;
                result[i+1] = (digits[i]+1)%10;
            }else {
                result[i] += (digits[i]+result[i+1])/10;
                result[i+1] = (digits[i]+result[i+1])%10;
            }
        }
        if (result[0] == 0){
            return Arrays.copyOfRange(result, 1, result.length);
        }else {
            return result;
        }
    }
    
    /**
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if (indexMap.containsKey(target-nums[i])){
                result[0] = indexMap.get(target-nums[i]);
                result[1] = i;
                return result;
            }else {
                indexMap.put(nums[i], i);
            }
        }
        return null;
    }
}

