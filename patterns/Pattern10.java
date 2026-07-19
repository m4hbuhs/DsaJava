
public class Pattern10 {


    public static void main(String[] args) {
        int N=5;
         for(int i=1;i<=2*N-1;i++){
        
          int stars = i;
     
          if(i>N) stars = 2*N-i;
          
         
          for(int j=1;j<=stars;j++){
              System.out.print("*");
          }
          
          
          System.out.println();
        }

    }
}
    

// *
// **
// ***
// ****
// *****
// ****
// ***
// **
// *