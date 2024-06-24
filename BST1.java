//BFS

import java.util.*;
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.value=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.value=val;
        this.left=left;
        this.right=right;
    }
}

class BST1{
    static List<List<Integer>> BFS(TreeNode root){
           Queue<TreeNode> queue=new LinkedList<>();
           List<List<Integer>> ans=new ArrayList<>();
           if(root==null)return ans;
           queue.offer(root);
           while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(queue.peek().left!=null)queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                temp.add(queue.poll().value);
            }
            ans.add(new ArrayList<>(temp));
           }
           return ans;
    }
    public static void main(String[] args){
    TreeNode root=new TreeNode(4);
    root.left=new TreeNode(5);
    root.right=new TreeNode(10);
    root.left.left=new TreeNode(14);
    System.out.println(BFS(root));
    }
}