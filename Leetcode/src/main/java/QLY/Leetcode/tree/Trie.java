package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {
    Trie[] children;
    boolean end;

    public Trie() {
        this.children = new Trie[26];
        this.end = false;
    }

    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new Trie();
            curr = curr.children[index];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Trie end = searchWord(word);
        return end != null && end.end;
    }

    public boolean startsWith(String prefix) {
        Trie end = searchWord(prefix);
        return end != null;
    }

    private Trie searchWord(String word){
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null)
                return null;
            curr = curr.children[index];
        }
        return curr;
    }

    public static void main(String[] args) {
        //["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
        //[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ad"));
        System.out.println(trie.search("applepie"));
        System.out.println(trie.search("rest"));
        System.out.println(trie.search("jan"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
