class ReverseInteger{
    //leetcode number 7
    private static int reverse(int x){
        long rev = 0;

        while( x != 0 ){
            int ld = x % 10;// storing last number in evryiteration
            rev = rev*10 + ld; //adding last number in very iteration
            x=x/10; // removinf=g last number iteraton by iteration
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) { // compariving if our value is going beyoonf the limit or not 
            return 0; 
        }
        return (int)rev ; // returning the value
    }
    public static void main(String[] args) {
        int[] n ={321,-1234,123446} ;
        for(int i : n ){
            System.out.println(reverse(i)+" ");
        }
    }
}