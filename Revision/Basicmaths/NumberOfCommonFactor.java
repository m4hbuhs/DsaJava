public class NumberOfCommonFactor {
    public static int commonFactors(int a, int b) {
            int count =0;
            int g = GCD(a,b);
        for(int i =1;i*i<=g; i++){
                if(g%i==0){
                  count++;
                  if(i!= g/i) count++;
                }
        }
        return count ;
    }
    private static int GCD(int a ,int b){
            if(b==0) return a ;
            return GCD(b,a%b);
    }
    public static void main(String[] args) {
        int a = 12,b =24;
        System.out.println(commonFactors(a, b));
    }
    
}