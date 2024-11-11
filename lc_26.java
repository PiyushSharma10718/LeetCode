class lc_26 {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for the new position of non-val elements
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++; // Move the index for non-val elements
            }
        }
        // i is the count of elements not equal to val
        return i;
    }

    public static void main(String[] args) {
        lc_26 obj = new lc_26();
        int[] arr = {3, 2, 2, 3};
        int target = 3;
        int newLength = obj.removeElement(arr, target);

        System.out.print("Output: ");
        for (int k = 0; k < newLength; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println("\nLength of array without target elements: " + newLength);
    }
}
