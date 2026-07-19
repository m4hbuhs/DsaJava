public class temp {

    public static void tailCountdown(int n) {
        // Base Case
        if (n == 0) {
            System.out.println("Liftoff!");
            return;
        }
        
        // Process first
        System.out.print(n+" ");
        
        // Recursive call is the absolute last step
        tailCountdown(n - 1);
    }

    public static void main(String[] args) {
        tailCountdown(3);
        // Output: 3, 2, 1, Liftoff!
    }
}