class lc_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (nums[left] <= nums[mid]) { // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target lies in the sorted left part
                } else {
                    left = mid + 1; // Target lies in the unsorted right part
                }
            } else { // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target lies in the sorted right part
                } else {
                    right = mid - 1; // Target lies in the unsorted left part
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        lc_33 solution = new lc_33();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // Output: 4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // Output: -1
        System.out.println(solution.search(new int[]{1}, 0)); // Output: -1
    }
}
