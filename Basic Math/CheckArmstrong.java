public class CheckArmstrong {
    public static void main(String[] args) {
        int n = 1634;
        int dup = n;
        double Armstrong=0;
        double digits = String.valueOf(n).length();
        while(n>0){
            double ld = n%10;
            Armstrong = Armstrong + Math.pow(ld,digits);
            n=n/10;
        }
        if(Armstrong == dup){
            System.out.println("it is Armstrong");
        }
        else{
            System.out.println("it is not Armstrong");
        }
    }
    
}
