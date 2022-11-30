package tdtin.algorithm.binarysearch.searchInRotateArray;

public class SearchInRotatedArray {


    public static int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;


        int rotatePos = findRotatePos(nums);
        if (nums[rotatePos] == target) return rotatePos;
        int m = nums.length;
        int left = (target <= nums[m - 1]) ? rotatePos : 0;
        int right = (target > nums[m - 1]) ? rotatePos : m - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findRotatePos(int[] nums) {
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
        System.out.println(search(new int[]{3, 1}, 3));
    }
}
