public class WatterBottels {
     public static int numWaterBottles(int numBottles, int numExchange) {
            int sum = numBottles;
            while(numBottles >= numExchange){
               int temp = numBottles / numExchange;
               int t = numBottles % numExchange;    
               sum += temp;
               numBottles = temp +t ;
            }
            return sum;
        
    }
    public static void main(String[] args) {
        int numBottles =15;
        int numExchange = 4;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }
}
