class Solution {
    boolean palindrome(int i ,String s){
        if(i>=s.length()/2) return true;
        s = s.toLowerCase(); 
        if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return palindrome(i+1,s);
    }


}
public class Stringpalindrom {
    public static void main(String[] args) {
        Solution obj=new Solution();
        String a= "madAm";
        boolean res = obj.palindrome(0,a);
        System.out.print(res);


    }
    
}
