package tdtin.algorithm.dynamic.programming.MinimalPathSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int minPathSum(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[n][m];
        dp[0][0] = grid.get(0).get(0);


        for (int c = 1; c < n; c++) {
            dp[0][c] = dp[0][c - 1] + grid.get(0).get(c);
        }

        for (int r = 1; r < m; r++) {
            dp[r][0] = dp[r - 1][0] + grid.get(r).get(0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid.get(i).get(j);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < gridLength; i++) {
            grid.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = minPathSum(grid);
        System.out.println(res);
    }
}
