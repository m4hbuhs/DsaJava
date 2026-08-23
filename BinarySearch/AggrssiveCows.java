import java.util.Arrays;

public class AggrssiveCows {
    private static boolean CanWePlace(int[] position,int mid,int cows){
        int countcow=1,last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                countcow++;
                last = position[i];
            }
            if (countcow >= cows) return true;
        }

        return false;
    }
    private static int maxDistance(int[] position,int cows){
        int n = position.length;
        Arrays.sort(position);
        int low =0,high =position[n-1] - position[0];
        while(low <= high){
            int mid = low + (high -low)/2;
            if(CanWePlace(position,mid,cows)) low  = mid +1;
            else high =mid -1;
        }
        return high;
    }
    public static void main(String[] args) {
        int[] position ={0,3,4,7,9,10};
        int cows =4;
        System.out.println(maxDistance(position, cows));

    }
}
