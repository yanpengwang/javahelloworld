package leetcode.program;


import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class MaxWidthOfBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return ans;
    }

    private static void dfs(TreeNode Node, Integer deep, Integer seq){
        if (Node == null) return;
        leftMap.computeIfAbsent(deep, x -> seq);
        ans = Math.max(ans, seq - leftMap.get(deep) + 1);
        dfs(Node.left, deep + 1, seq * 2);
        dfs(Node.right, deep + 1, seq * 2 + 1);
    }

    private static Map<Integer, Integer> leftMap = new HashMap<>();
    private static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(widthOfBinaryTree(root));
    }
}




