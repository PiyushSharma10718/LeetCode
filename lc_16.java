import java.util.*;
class lc_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - currentSum) < Math.abs(target - closestSum)){
                    closestSum = currentSum;
                }
                if(currentSum < target){
                    left++;
                }else if(currentSum > target){
                    right--;
                }else{
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        lc_16 obj = new lc_16();
        int[] arr = {0, 0, 0};
        int target = 1;
        int res = obj.threeSumClosest(arr, target);
        System.out.println(res);
    }
}