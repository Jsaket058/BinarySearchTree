class BST10{
    boolean sameBTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        return root1.value==root2.value && sameBTree(root1.left,root2.left) && sameBTree(root1.right,root2.right);
    }
}