package tdtin.algorithm.dynamic.programming.CoinChangeII;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int coinGame(List<Integer> coins, int amount) {
        int numOfCoin = coins.size();
        int[][] dp = new int[numOfCoin + 1][amount + 1];

        for (int[] subSet : dp) {
            Arrays.fill(subSet, 0);
        }
        dp[0][0] = 1;

        return 0;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> coins = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int amount = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = coinGame(coins, amount);
        System.out.println(res);
    }
}
