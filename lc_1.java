import java.util.Scanner;

class lc_1 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the Elements of the Array : ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the Target : ");
        int target = sc.nextInt();
        sc.close();
        int[] res = twoSum(nums, target);
        if (res.length == 0) {
            System.out.println("No valid pair found.");
        } else {
            System.out.println("Indices: " + res[0] + ", " + res[1]);
        }
    }
}
