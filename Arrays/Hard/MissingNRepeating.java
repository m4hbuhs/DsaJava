public class MissingNRepeating {
    private static int[] brute(int[] arr) {
        int n = arr.length;
        int repeating=-1;
        int missing=-1;
        for(int i =1;i<=n;i++){
            int count=0;
            for(int j =0;j<n;j++){
                if(arr[j]==i){
                   count++;
                }
            }
            if(count==2) repeating=i;
            else if(count==0) missing=i;
            if(missing!=-1 && repeating!=-1) break;
        }
        return new int[]{repeating,missing};
    }
    private static int[] better(int[] arr) {

        int n = arr.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {

            if (hash[i] == 2) {
                repeating = i;
            }
            else if (hash[i] == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }
    public static int[] optimal(int[] arr){
        int n = arr.length;
        int sn=(n*(n+1))/2;
        int sn2=(n*(n+1)*(2*n+1))/6;
        int x=0,y=0;
        int sum=0,sum2=0;
        for(int i =0;i<n;i++){
                sum+=arr[i];
                sum2+=arr[i]*arr[i];
        }
        int val1 = sum-sn;
        int val2 = sum2-sn2;
        val2=val2/val1;
        x=(val1+val2)/2;
        y=x-val1;
        return new int[]{x,y};
    }
    public static int[] optimalbetter(int[] arr){
        int n = arr.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }

        int bit = xor & ~(xor - 1);

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {

            if ((arr[i] & bit) != 0)
                x ^= arr[i];
            else
                y ^= arr[i];

            if (((i + 1) & bit) != 0)
                x ^= (i + 1);
            else
                y ^= (i + 1);
        }


        for (int num : arr) {
            if (num == x) {
                return new int[]{x, y}; 
            }
        }

        return new int[]{y, x}; 
    }

    public static void main(String[] args) {
        int[] arr={1,4,6,3,2,1};
        int[] temp=optimal(arr);//better(arr);//brute(arr);
        System.out.print(temp[0]+" "+temp[1]);

    }
    
}