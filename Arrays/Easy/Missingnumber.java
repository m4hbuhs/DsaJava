public class Missingnumber {
    public static int brute(int[] arr, int n){

    for(int i = 1; i <= n; i++){

        boolean found = false;

        for(int j = 0; j < arr.length; j++){

            if(arr[j] == i){
                found = true;
                break;
            }
        }

        if(!found)
            return i;
    }

    return -1;
}
public static int better(int[] arr, int n){

    int[] hash = new int[n + 1];

    for(int num : arr){
        hash[num]++;
    }

    for(int i = 1; i <= n; i++){

        if(hash[i] == 0)
            return i;
    }

    return -1;
}
public static int optimal(int[] arr, int n){

    int expected = n * (n + 1) / 2;

    int actual = 0;

    for(int num : arr){
        actual += num;
    }

    return expected - actual;
}
public static int xorMethod(int[] arr, int n){

    int xor1 = 0;
    int xor2 = 0;

    for(int i = 1; i <= n; i++){
        xor1 ^= i;
    }

    for(int num : arr){
        xor2 ^= num;
    }

    return xor1 ^ xor2;
}
public static void main(String[] args) {

    int[] arr = {1,2,4,5};
    int n = 5;

    System.out.println(brute(arr, n));//Brute Force O(N²) O(1)
    System.out.println(better(arr, n));// Better (Hashing) O(N) O(N)
    System.out.println(optimal(arr, n));//Optimal (Sum Formula)	O(N)	O(1)
    System.out.println(xorMethod(arr, n));//Optimal (XOR)	O(N)	O(1)
}
    
}
