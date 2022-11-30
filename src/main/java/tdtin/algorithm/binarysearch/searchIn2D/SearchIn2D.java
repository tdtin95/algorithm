package tdtin.algorithm.binarysearch.searchIn2D;

public class SearchIn2D {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int numCol = matrix[0].length;

        for (int[] row : matrix) {
            int lastInRow = row[numCol - 1];
            if (lastInRow == target) return true;
            if (lastInRow < target) continue;

            int left = 0;
            int right = numCol - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = row[mid];
                if (target == midValue) return true;
                if (target > midValue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3}}, 1));
    }
}
