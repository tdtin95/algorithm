package tdtin.algorithm.binarysearch.findMinimumInRotateArray;

public class Solution {

    public static int findMin(int[] nums) {
        return findRotatePos(nums);
    }

    public static int findRotatePos(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
