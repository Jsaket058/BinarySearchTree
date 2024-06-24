import java.util.*;
class Pair{
    TreeNode root;
    int idx;
    Pair(TreeNode root,int idx){
        this.root=root;
        this.idx=idx;
    }
}
class BST14{
    static ArrayList<Integer> topview(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            int idx=it.idx;
            TreeNode temp=it.root;

            if(map.get(idx)==null)map.put(idx,temp.value);
            if(temp.left != null){
                q.add(new Pair(temp.left,idx-1));
            }
            if(temp.right != null){
                q.add(new Pair(temp.right,idx+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args){
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
       System.out.println(topview(root));
    }
}