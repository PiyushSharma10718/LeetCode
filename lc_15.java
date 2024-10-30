import java.util.*;
class lc_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);


        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left]  + nums[right];

                if(sum == target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        lc_15 obj = new lc_15();
        int[] arr = {-1, 0, 1, 2, -1, 4};
        System.out.println(obj.threeSum(arr));x
    }
}