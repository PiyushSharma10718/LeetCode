import java.util.Arrays;

class lc_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence
        result[0] = findBound(nums, target, true);

        // If target doesn't exist, no need to search for the last occurrence
        if (result[0] == -1) {
            return result;
        }

        // Find the last occurrence
        result[1] = findBound(nums, target, false);

        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Record the position
                if (isFirst) {
                    right = mid - 1; // Narrow search to the left part
                } else {
                    left = mid + 1; // Narrow search to the right part
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }

    public static void main(String[] args) {
        lc_34 solution = new lc_34();

        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8))); // Output: [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6))); // Output: [-1, -1]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0))); // Output: [-1, -1]
    }
}
