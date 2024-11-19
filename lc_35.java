class lc_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If the target is not found, `left` will be the correct insertion point
        return left;
    }

    public static void main(String[] args) {
        lc_35 solution = new lc_35();

        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5)); // Output: 2
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2)); // Output: 1
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7)); // Output: 4
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0)); // Output: 0
    }
}
