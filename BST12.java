import java.util.*;

class BST12 {
    static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    static void leftBoundary(TreeNode root,ArrayList<Integer> ans){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr))ans.add(curr.value);
            if(curr.left!=null)curr=curr.left;
            else curr=curr.right;
        }
    }
    static void leafBoundary(TreeNode root,ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.value);
            return;
        }
        if(root.left!=null)leafBoundary(root.left,ans);
        if(root.right!=null)leafBoundary(root.right,ans);
    }
    static void rightBoundary(TreeNode root,ArrayList<Integer> ans){
        TreeNode curr=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr))temp.add(curr.value);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    static ArrayList<Integer> printBoundary(TreeNode root) {
    ArrayList<Integer> ans=new ArrayList<>();
    if(isLeaf(root)==false)ans.add(root.value);
    leftBoundary(root,ans);
    leafBoundary(root,ans);
    rightBoundary(root,ans);
    return ans;
    }

    public static void main(String[] args) {
       TreeNode root=new TreeNode(1);
       root.left=new TreeNode(2);
       root.right=new TreeNode(7);
       root.left.left=new TreeNode(3);
       root.left.left.right=new TreeNode(4);
       root.left.left.right.left=new TreeNode(5);
       root.left.left.right.right=new TreeNode(6);
       root.right.right=new TreeNode(8);
       root.right.right.left=new TreeNode(9);
       root.right.right.left.left=new TreeNode(10);
       root.right.right.left.right=new TreeNode(11);
       System.out.println(printBoundary(root));
    }
}