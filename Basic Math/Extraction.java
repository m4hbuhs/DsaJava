class Extraction{
    public static void main(String[] args) {
        int n = 1234;
        int count =0;
        while(n>0){
            int temp =n%10;
            n = n/10;
          count++;
        }
        System.out.println(count);
    }
}