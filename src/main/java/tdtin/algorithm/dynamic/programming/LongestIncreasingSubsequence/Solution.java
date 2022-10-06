package tdtin.algorithm.dynamic.programming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int longestSubLen(List<Integer> nums) {
        int[] dp = new int[nums.size() + 1];

        dp[0] = 0;
        int len = 0;
        for (int i = 1; i <= nums.size(); i++) {
            int ni = nums.get(i - 1);
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                int nj = nums.get(j - 1);
                if (nj < ni) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);

        }
        return len;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = longestSubLen(nums);
        System.out.println(res);
    }
}
