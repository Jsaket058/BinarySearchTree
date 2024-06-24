class BST9{
    static int maxPathSum(TreeNode root, int[]max){
        if(root==null)return 0;
        int leftsum=Math.max(0,maxPathSum(root.left,max));
        int rightsum=Math.max(0,maxPathSum(root.right,max));
        max[0]=Math.max(max[0],root.value+leftsum+rightsum);
        return root.value + Math.max(leftsum,rightsum);
    }
    public static void main(String[] args){
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(15);
    root.right = new TreeNode(20);
    root.left.right = new TreeNode(66);
    root.right.left = new TreeNode(36);
    root.left.left = new TreeNode(12);
    root.left.left.left=new TreeNode(35);
    int max[]=new int[1];
    max[0]=Integer.MIN_VALUE;
    maxPathSum(root,max);
    System.out.println(max[0]);
    }
}