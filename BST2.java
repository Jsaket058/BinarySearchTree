import java.util.*;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.value = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }
}

class BST2 {
    // Recursive preorder
    static void preorder1(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.value);
        preorder1(root.left);
        preorder1(root.right);
    }
    //Iterative preorder
    static List<Integer> preorder(TreeNode root){
        List<Integer> preorder2 = new ArrayList<>();
        if(root==null)return preorder2;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.empty()){
            root=st.pop();
            preorder2.add(root.value);
            if(root.right!=null){
               st.push(root.right);
            }
            if(root.left!=null){
               st.push(root.left);
            }
        }
        return preorder2;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.right=new TreeNode(66);
        root.right.left=new TreeNode(36);
        root.left.left=new TreeNode(12);
        preorder1(root);
        System.out.println(preorder(root));
    }
}