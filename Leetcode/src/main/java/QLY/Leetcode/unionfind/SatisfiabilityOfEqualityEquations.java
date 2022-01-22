package QLY.Leetcode.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        List<String> notequals = new ArrayList<>();
        UnionFind unionFind = new UnionFind(26);

        boolean result = true;
        for (String equation : equations) {
            if (equation.charAt(1) == '!'){
                notequals.add(equation);
                continue;
            }
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            unionFind.union(left, right);
        }

        for (String noteq : notequals) {
            int left = noteq.charAt(0) - 'a';
            int right = noteq.charAt(3) - 'a';
            if (unionFind.isConnected(left, right))
                return false;
        }

        return true;
    }



    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations s = new SatisfiabilityOfEqualityEquations();
        System.out.println(s.equationsPossible(new String[]{"c==c","f!=a","f==b","b==c"}));
    }
}
