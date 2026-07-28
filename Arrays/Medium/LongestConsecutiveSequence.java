import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
     private static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static int brute(int[] nums) {
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 1;

            while (linearSearch(nums, x + 1)) {
                x++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
    public static int better(int[] nums) {

        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
    public static int optimal(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(optimal(nums));
        System.out.println(better(nums));
        System.out.println(brute(nums));
    }

}
