package QLY.Leetcode.design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/solution/
 * 170. 两数之和 III - 数据结构设计
 * 设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
 *
 * 实现 TwoSum 类：
 * TwoSum() 使用空数组初始化 TwoSum 对象
 * void add(int number) 向数据结构添加一个数 number
 * boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
 */
public class TwoSum3DataStructureDesign {

    private final HashMap<Integer, Integer> map;

    public TwoSum3DataStructureDesign() {
        this.map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (value - next.getKey() == next.getKey()) {
                if (next.getValue() > 1)
                    return true;
            } else {
                if (map.containsKey(value - next.getKey())) {
                    return true;
                }
            }

        }
        return false;
    }
}
