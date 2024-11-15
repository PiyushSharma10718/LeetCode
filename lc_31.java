import java.util.Arrays;

class lc_31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) { // There is an element to swap
            int j = n - 1;
            
            // Step 2: Find the element to swap with
            while (nums[j] <= nums[i]) {
                j--;
            }
            
            // Step 3: Swap elements
            swap(nums, i, j);
        }
        
        // Step 4: Reverse the elements from i + 1 to the end
        reverse(nums, i + 1, n - 1);
    }
    
    // Helper function to swap elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Helper function to reverse elements in a range of an array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Test the function with example inputs
    public static void main(String[] args) {
        lc_31 solution = new lc_31();
        
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 2]
        
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [1, 2, 3]
        
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // Output: [1, 5, 1]
    }
}
