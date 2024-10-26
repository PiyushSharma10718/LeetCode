class lc_11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = currHeight * width;
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        lc_11 obj = new lc_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(obj.maxArea(height));
    }
}
