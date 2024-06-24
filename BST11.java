import java.util.*;
class BST11{
    static List<List<Integer>> zigZag(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int cnt=1;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            if(cnt%2==0){
                for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                temp.add(q.poll().value);
            }
        }
            else{
                for(int i=0;i<size;i++){
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                temp.add(q.poll().value);
            }
        }    
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
    public static void main(String[] ra){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(5);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(14);
        System.out.println(zigZag(root));
    }
}