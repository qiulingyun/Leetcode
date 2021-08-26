package QLY.Leetcode.twopointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 *
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int count = 0;
        while (left <= right){
            if (left == right)
                return count + 1;
            if (people[left] + people[right] <= limit){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        System.out.println(boatsToSavePeople.numRescueBoats(new int[]{1,2}, 3));
        System.out.println(boatsToSavePeople.numRescueBoats(new int[]{3,5,3,4}, 5));
        System.out.println(boatsToSavePeople.numRescueBoats(new int[]{3}, 5));
        System.out.println(boatsToSavePeople.numRescueBoats(new int[]{1,1,1,1}, 3));
    }
}
