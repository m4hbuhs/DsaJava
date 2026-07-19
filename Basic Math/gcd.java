public class gcd {
    // Euclidean Algorithm
    public static void main(String[] args) {
        int n1=30,n2=20;
        while(n1>0 && n2>0){
            if(n1>n2) n1=n1%n2;
            else n2 = n2%n1;
        }
        if(n1==0) System.out.println(n2);
        System.out.println(n1);
    }
    
}
