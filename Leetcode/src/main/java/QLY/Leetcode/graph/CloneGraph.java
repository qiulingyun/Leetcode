package QLY.Leetcode.graph;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // [[2,4],[1,3],[2,4],[1,3]]
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if (node == null)
            return null;

        Node _node = new Node(node.val);
        visited.put(node, _node);
        for (Node neighbor : node.neighbors) {
            if (visited.containsKey(neighbor)){
                Node _neighbor = visited.get(neighbor);
                _node.neighbors.add(_neighbor);
            }else {
                Node _neighbor = cloneGraphDFS(neighbor);
                _node.neighbors.add(_neighbor);

            }
        }

        return _node;
    }

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Node newRoot = new Node(node.val);
        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, newRoot);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node curr = queue.removeFirst();
            Node _curr = visited.get(curr);
            for (Node neighbor: curr.neighbors){
                if (!visited.containsKey(neighbor)){
                    Node _neighbor = new Node(neighbor.val);
                    visited.put(neighbor, _neighbor);
                    _curr.neighbors.add(_neighbor);

                    queue.add(neighbor);
                    visited.put(curr, _curr);
                }else {
                    Node _neighbor = visited.get(neighbor);
                    _curr.neighbors.add(_neighbor);
                }

            }
        }

        return newRoot;
    }
}
