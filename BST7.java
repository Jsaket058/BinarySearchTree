class BST7 {
static boolean checkBalancedBinaryTree(TreeNode root){
    return dfsHeight(root) != -1;
} 
static int dfsHeight(TreeNode root){
    if(root==null)return 0;
    int lh=dfsHeight(root.left);
    int rh=dfsHeight(root.right);
    if(lh==-1 || rh==-1)return -1;
    if(Math.abs(lh-rh)>1)return -1;
    return Math.max(lh,rh)+1;
}
public static void main(String[] args){
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(15);
    root.right = new TreeNode(20);
    root.left.right = new TreeNode(66);
    root.right.left = new TreeNode(36);
    root.left.left = new TreeNode(12);
    root.left.left.left=new TreeNode(35);
    // root.left.left.left.left=new TreeNode(49);
    System.out.println(checkBalancedBinaryTree(root));
}
}