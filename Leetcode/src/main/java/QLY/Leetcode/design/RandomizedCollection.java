package QLY.Leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 注意: 允许出现重复元素。
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class RandomizedCollection {
    private final HashMap<Integer, HashSet<Integer>> indexMap;
    private final ArrayList<Integer> list;
    private final Random random;

    public RandomizedCollection() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        int index = list.size();
        if (indexMap.containsKey(val)){
            indexMap.get(val).add(index);
            list.add(val);
            return false;
        }

        indexMap.put(val, new HashSet<Integer>(){{add(index);}});
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val))
            return false;

        int removeIndex = indexMap.get(val).iterator().next();
        HashSet<Integer> indexSet = indexMap.get(val);
        indexSet.remove(removeIndex);
        if (indexSet.isEmpty())
            indexMap.remove(val);

        int lastIndex = list.size() - 1;
        if (removeIndex != lastIndex){
            Integer integer = list.get(lastIndex);
            HashSet<Integer> integerIndexSet = indexMap.get(integer);
            integerIndexSet.remove(lastIndex);
            integerIndexSet.add(removeIndex);
            list.set(removeIndex, integer);
        }
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//        System.out.println(collection.insert(1));
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//        System.out.println(collection.insert(1));
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//        System.out.println(collection.insert(2));
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//        System.out.println(collection.getRandom());
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//        System.out.println(collection.remove(1));
//
//// getRandom 应有相同概率返回 1 和 2 。
//        System.out.println(collection.getRandom());

        System.out.println(collection.insert(0));
        System.out.println(collection.insert(1));
        System.out.println(collection.remove(0));
        System.out.println(collection.insert(2));
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }
}
