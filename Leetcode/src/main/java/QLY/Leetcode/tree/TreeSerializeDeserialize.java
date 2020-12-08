package QLY.Leetcode.tree;

import java.util.LinkedList;

public class TreeSerializeDeserialize {
    class TreeNode{
        public String val;
        public TreeNode left;
        public TreeNode right;
    }

    StringBuffer answer = new StringBuffer();

    public void preorderSerialize(TreeNode root){
        if (root == null){
            answer.append('#');
            return;
        }


        answer.append(root.val);
        preorderSerialize(root.left);
        preorderSerialize(root.right);
    }

    public TreeNode preorderDeserialize(String str){
        LinkedList<String> list = new LinkedList<>();
        for (char c: str.toCharArray()) {
            list.add("" + c);
        }
        return preorderDeserialize(list);
    }

    private TreeNode preorderDeserialize(LinkedList<String> list){
        String first = list.pollFirst();
        if (first.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = first;

        root.left = preorderDeserialize(list);
        root.right = preorderDeserialize(list);

        return root;
    }

    public TreeNode postorderDeserialize(String str){
        LinkedList<String> list = new LinkedList<>();
        for (char c: str.toCharArray()) {
            list.add("" + c);
        }
        return postorderDeserialize(list);
    }

    private TreeNode postorderDeserialize(LinkedList<String> list){
        String last = list.pollLast();
        if (last.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = last;
        root.right = postorderDeserialize(list);
        root.left = postorderDeserialize(list);
        return root;
    }

    public void bfsSerialize(TreeNode root){
        if (root == null){
            this.answer.append("#");
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        this.answer.append(root.val);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();

            if (treeNode.left != null){
                this.answer.append(treeNode.left.val);
                queue.add(treeNode.left);
            }else {
                this.answer.append("#");
            }

            if (treeNode.right != null){
                this.answer.append(treeNode.right.val);
                queue.add(treeNode.right);
            }else {
                this.answer.append("#");
            }
        }
    }


    public static void main(String[] args) {
        TreeSerializeDeserialize treeSerializeDeserialize = new TreeSerializeDeserialize();
        TreeNode treeNode = treeSerializeDeserialize.preorderDeserialize("12#4##3##");
        treeSerializeDeserialize.preorderSerialize(treeNode);
        System.out.println("preorder: " + treeSerializeDeserialize.answer);

        treeSerializeDeserialize.answer = new StringBuffer();

        treeNode = treeSerializeDeserialize.postorderDeserialize("###42##31");
        treeSerializeDeserialize.preorderSerialize(treeNode);
        System.out.println("postorder: " + treeSerializeDeserialize.answer);

        treeSerializeDeserialize.answer = new StringBuffer();
        treeSerializeDeserialize.bfsSerialize(treeNode);
        System.out.println("bfsorder: " + treeSerializeDeserialize.answer);

    }
}
