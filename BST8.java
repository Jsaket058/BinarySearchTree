class BST8{
static int diameterOfBT(TreeNode root,int[] maxi){
if(root==null)return 0;
int lh=diameterOfBT(root.left, maxi);
int rh=diameterOfBT(root.right, maxi);
maxi[0]=Math.max(maxi[0],lh+rh);
return 1+Math.max(lh,rh);
}
public static void main(String[] args){
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(15);
    root.right = new TreeNode(20);
    root.left.right = new TreeNode(66);
    root.right.left = new TreeNode(36);
    root.left.left = new TreeNode(12);
    root.left.left.left=new TreeNode(35);
    int daimeter[]=new int[1];
    diameterOfBT(root, daimeter);
    System.out.println(daimeter[0]);
}
}