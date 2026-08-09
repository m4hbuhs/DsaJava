import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeoverlappingIntervals {
    public static int[][] brute(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // If already covered by previous merged interval
            if (!ans.isEmpty() && start <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static int[][] optimal(int[][] arr) {

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // No overlap
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            }

        
            else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        int[][] num1=brute(arr);
        int[][] num2=optimal(arr);
        System.out.println("Brute:   " + Arrays.deepToString(num1));
        System.out.println("Optimal: " + Arrays.deepToString(num2));
        
    }
    
}