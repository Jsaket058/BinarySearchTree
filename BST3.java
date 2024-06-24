import java.util.*;
// class TreeNode {
//     int value;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.value = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.value = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class BST3 {
    // Recursive inorder
    static void inorder1(TreeNode root) {
        if (root == null)
            return;
        inorder1(root.left);
        System.out.println(root.value);
        inorder1(root.right);
    }

    // Iterative inorder
    static List<Integer> inorder(TreeNode root) {
        List<Integer> inorder2 = new ArrayList<>();
        if (root == null)
            return inorder2;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty())
                    break;
                node = st.pop();
                inorder2.add(node.value);
                node = node.right;
            }
        }
        return inorder2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(66);
        root.right.left = new TreeNode(36);
        root.left.left = new TreeNode(12);
        inorder1(root);
        System.out.println(inorder(root));
    }
}