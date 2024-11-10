class lc_25 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer for the position of last unique element
        for (int j = 1; j < nums.length; j++) {
            // Check if the current element is different from the last unique element
            if (nums[j] != nums[i]) {
                i++; // Move the unique pointer forward
                nums[i] = nums[j]; // Update the unique position with the new unique element
            }
        }
        // `i + 1` is the number of unique elements
        return i + 1;
    }

    public static void main(String[] args) {
        lc_25 sol = new lc_25();
        
        // Test case 1
        int[] nums1 = {1, 1, 2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("Output: k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        System.out.println("]");

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("Output: k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        System.out.println("]");
    }
}
