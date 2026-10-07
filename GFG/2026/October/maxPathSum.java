/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {

    int maxSum = Integer.MIN_VALUE;
    int leafCount = 0;

    public int maxPathSum(Node root) {

        getMax(root);

        if (leafCount < 2) {
            return -1;
        }

        return maxSum;
    }

    private int getMax(Node root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.left == null && root.right == null) {
            leafCount++;
            return root.data;
        }

        if (root.left == null) {
            return root.data + getMax(root.right);
        }

        if (root.right == null) {
            return root.data + getMax(root.left);
        }

        int leftSum = getMax(root.left);
        int rightSum = getMax(root.right);

        maxSum = Math.max(maxSum,
                leftSum + root.data + rightSum);

        return root.data + Math.max(leftSum, rightSum);
    }
}
