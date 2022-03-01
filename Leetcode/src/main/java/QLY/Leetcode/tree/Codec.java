package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null,";

        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    private int index = 0;
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        else if (index >= data.length())
            return null;

        int sharp = data.indexOf(",", index);
        if (sharp == -1)
            return null;

        String str = data.substring(index, sharp);
        index = sharp + 1;
        if ("null".equals(str))
            return null;

        TreeNode curr = new TreeNode(Integer.parseInt(str));
        curr.left = deserialize(data);
        curr.right = deserialize(data);

        return curr;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("1,2,null,null,3,4,null,null,5,null,null");
        System.out.println(codec.serialize(deserialize));
    }
}
