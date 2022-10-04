package tdtin.algorithm.dynamic.programming.PartitionTwoSum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static boolean canPartition(List<Integer> nums) {
        int sum = nums.stream().mapToInt(Integer::intValue).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.size() + 1][target + 1];

        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }

        dp[0][0] = true;

        for (int i = 1; i <= nums.size(); i++) {
            for (int s = 0; s <= target; s++) {
                if (s < nums.get(i - 1)) {
                    dp[i][s] = dp[i - 1][s];
                } else {
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums.get(i - 1)];
                }
            }
        }

        return dp[nums.size()][target];
    }


    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}

