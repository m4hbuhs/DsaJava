import java.util.ArrayList;

public class AternateRearrangebysign {
     public static int[] alternateNumbers(int[] arr) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();


        for (int num : arr) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        if (pos.size() > neg.size()) {

            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;

            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }
        else {

            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;

            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }

        return arr;
    }
     public static void main(String[] args) {
        
        int[] arr = {1, 2, -4, -5, 3, 6};

        int[] ans = alternateNumbers(arr);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}


