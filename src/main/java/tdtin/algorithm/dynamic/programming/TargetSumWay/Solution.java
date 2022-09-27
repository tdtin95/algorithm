package tdtin.algorithm.dynamic.programming.TargetSumWay;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int findTargetSumWays(int[] nums, int target) {

        return backtrack(0, 0, new HashMap<>(), nums, target);
    }

    public static int backtrack(int index, int total, Map<String, Integer> cache, int[] nums, int target) {
        if (index == nums.length) {
            if (total == target) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = index + "" + total;
        if (cache.get(key) != null) {
            return cache.get(key);
        }

        int sum = backtrack(index + 1, total + nums[index], cache, nums, target)
                + backtrack(index + 1, total - nums[index], cache, nums, target);
        cache.put(index + "" + sum, sum);

        return cache.get(index + "" + sum);

    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
