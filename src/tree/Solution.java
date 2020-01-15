package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (curr != null || !nodeStack.isEmpty()) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode pre = null;
        while (curr != null || !nodeStack.isEmpty()) {
            if (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            } else {
                curr = nodeStack.peek();
                if (curr.right == null || curr.right == pre) {
                    result.add(curr.val);
                    nodeStack.pop();
                    pre = curr;
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
        }
        return result;
    }
    
    Integer last = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if (last != null && root.val>=last){
            return false;
        }else {
            boolean left = isValidBST(root.left);
            last = root.val;
            boolean right = isValidBST(root.right);
            return left&&right;
        }
    }
}
