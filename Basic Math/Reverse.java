public class Reverse {
    public static void main(String[] args) {
        int n = 123003400;
        int Reverse=0;
        while(n>0){
            int lastnumber =n%10;
            Reverse = Reverse*10+lastnumber;
            n=n/10;
        }
        System.out.print(Reverse);
    }
}
