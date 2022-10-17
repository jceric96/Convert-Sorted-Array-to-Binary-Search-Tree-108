import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

public class ConvertSortedArrToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int rootIndex = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = buildTree(nums, left, rootIndex - 1);
        root.right = buildTree(nums, rootIndex + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrToBST m = new ConvertSortedArrToBST();
        int[] nums = new int[] { -10, -3, 0, 5, 9 };

        TreeNode root = m.sortedArrayToBST(nums);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null) {
                    queue2.offer(current.left);
                }
                if (current.right != null) {
                    queue2.offer(current.right);
                }
            }
            queue = queue2;
        }
    }
}
