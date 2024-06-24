import java.util.*;
// class TreeNode {
//     int value;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.value = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.value = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class BST4 {
    // Recursive postorder
    static void postorder1(TreeNode root) {
        if (root == null)
            return;
        postorder1(root.left);
        postorder1(root.right);
        System.out.println(root.value);
    }

    // Iterative postorder with 2 stack
    static List<Integer> postorder(TreeNode root) {
        List<Integer> postorder2 = new ArrayList<>();
        if (root == null)
            return postorder2;
        Stack<TreeNode> st1 = new Stack<>();   
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root=st1.pop();
            st2.push(root);
            if(root.left!=null)st1.push(root.left);
            if(root.right!=null)st1.push(root.right);
        }
        while(!st2.isEmpty()){
            postorder2.add(st2.pop().value);
        }
        return postorder2;
    }
    
    //Iterative postorder with one stack
    static List<Integer> postorder3(TreeNode root) {
    List<Integer> ans=new ArrayList<>();
    if(root==null)return ans;
    Stack<TreeNode> st=new Stack<>();
    TreeNode curr=root;
    while(curr!=null || !st.isEmpty()){
        if(curr!=null){
            st.push(curr);
            curr=curr.left;
        }
        else{
            TreeNode temp=st.peek().right;
            if(temp==null){
                temp=st.pop();
                ans.add(temp.value);
                while(!st.isEmpty() && temp==st.peek().right){
                    temp=st.pop();
                    ans.add(temp.value);
                }
            }
            else{
                curr=temp;
            }
        }
    }
    return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(66);
        root.right.left = new TreeNode(36);
        root.left.left = new TreeNode(12);
        postorder1(root);
        System.out.println(postorder(root));
        System.out.println(postorder3(root));
    }
}

