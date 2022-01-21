package QLY.Leetcode.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/accounts-merge/
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final int n = accounts.size();
        HashSet<String>[] emails = new HashSet[n];
        for (int i = 0; i < emails.length; i++) {
            emails[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                emails[i].add(list.get(j));
            }
        }
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            HashSet<String> emailSet = emails[i];
            for (int j = i + 1; j < n; j++) {
                for (String email :emails[j]) {
                    if (emailSet.contains(email)){
                        unionFind.union(i, j);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            if (root != i)
                emails[root].addAll(emails[i]);
        }

        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == i){
                String[] temp = new String[emails[i].size()];
                emails[i].toArray(temp);
                Arrays.sort(temp);

                List<String> result = new ArrayList<>();
                result.add(accounts.get(i).get(0));
                result.addAll(Arrays.asList(temp));
                results.add(result);
            }
        }

        return results;
    }
}
