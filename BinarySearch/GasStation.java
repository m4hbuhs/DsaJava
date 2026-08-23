import java.util.PriorityQueue;

public class GasStation {
    public static double brute(int[] arr, int k) {

        int n = arr.length;
        // howMany[i] = number of extra stations
        // placed inside gap arr[i] -> arr[i+1]
        int[] howMany = new int[n - 1];

        for (int gasStations = 1; gasStations <= k; gasStations++) {

            double maxSection = -1;
            int maxIndex = -1;

            // Find the current largest section
            for (int i = 0; i < n - 1; i++) {

                double gap = arr[i + 1] - arr[i];

                double sectionLength =
                        gap / (howMany[i] + 1.0);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }

            // Put one station in the largest section
            howMany[maxIndex]++;
        }

        // Find final maximum section
        double maxAns = -1;

        for (int i = 0; i < n - 1; i++) {

            double gap = arr[i + 1] - arr[i];

            double sectionLength =
                    gap / (howMany[i] + 1.0);

            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }
     public static double better(int[] arr, int k) {

        int n = arr.length;

        // Number of stations placed in each gap
        int[] howMany = new int[n - 1];

        // Max heap
        // [sectionLength, index]
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // Initially insert all gaps
        for (int i = 0; i < n - 1; i++) {

            double gap = arr[i + 1] - arr[i];

            pq.offer(new double[]{gap, i});
        }

        // Add k gas stations
        for (int gasStations = 1;
             gasStations <= k;
             gasStations++) {

            // Get largest section
            double[] top = pq.poll();

            int index = (int) top[1];

            // Add one station to this gap
            howMany[index]++;

            // Calculate new section length
            double gap = arr[index + 1] - arr[index];

            double newSection = gap / (howMany[index] + 1.0);

            // Put updated section back
            pq.offer(new double[]{newSection,index});
        }

        return pq.peek()[0];
    }
     private static int numberOfGasStationsRequired(int[] arr,double dist) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            int numberInBetween = (int) (gap / dist);
            // If gap is exactly divisible by dist,
            // we don't need an extra station
            // for the final endpoint.
            if (Math.abs(gap -numberInBetween * dist) < 1e-12) numberInBetween--;
            

            count += numberInBetween;
        }

        return count;
    }

    public static double optimal(int[] arr, int k) {
        int n = arr.length;
        // Maximum possible answer
        double high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high,arr[i + 1] - arr[i]);
        }
        double low = 0;

        // Required precision
        double diff = 1e-6;

        while (high - low > diff) {

            double mid =
                    low + (high - low) / 2.0;

            int required = numberOfGasStationsRequired(arr, mid);

            if (required > k) low = mid;
                // Too many stations required.
                // dist is too small.
            else {
                // Possible with k stations.
                // Try smaller distance.
                high = mid;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        int[] arr={};
        int k =0;
        System.out.println(brute(arr, k));
        System.out.println(better(arr, k));
        System.out.println(optimal(arr, k));
    }
}
