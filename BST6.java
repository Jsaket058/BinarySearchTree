import java.util.*;
class BST6{
    static int maxDepth(TreeNode root){
        if(root==null)return 0;
        int lh=1+maxDepth(root.left);
        int rh=1+maxDepth(root.right);
        return Math.max(lh,rh);
    }
    static int maxDepth1(TreeNode root){
        if(root==null)return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int ans=0;
        while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            if(q.peek().left!=null)q.offer(q.peek().left);
            if(q.peek().right!=null)q.offer(q.peek().right);
            q.poll();
        }
        ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(66);
        root.right.left = new TreeNode(36);
        root.left.left = new TreeNode(12);
        root.left.left.left=new TreeNode(35);
        System.out.println(maxDepth1(root));
        System.out.println(maxDepth(root));
    }
}