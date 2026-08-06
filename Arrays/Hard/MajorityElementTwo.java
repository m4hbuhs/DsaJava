import java.util.*;

class MajorityElementTwo{
    private static List<Integer> brute(int[] arr ){
        ArrayList<Integer> list =new ArrayList<>();

        int n = arr.length;

        for(int i =0;i<n;i++){

            if (list.contains(arr[i])) continue;

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (arr[j] == arr[i]) count++;

            }

            if (count > n / 3)

                list.add(arr[i]);

            if (list.size() == 2) break;
                
        }
        return list;
    }
    public static List<Integer> better(int[] arr){
        ArrayList<Integer> list =new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length,mm=(n/3)+1;
        for(int i =0;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i])==mm){
                list.add(arr[i]);
            }
        }
        return list ;
    }
    public static List<Integer> optimal(int[] arr){
        ArrayList<Integer> list =new ArrayList<>();

        int n = arr.length;

        int count1 =0,count2=0;

        int el1=0,el2=0;

        for(int i=0;i<n;i++){

            if(count1 ==0 && arr[i]!=el2){
                
                count1=1;el1=arr[i];
                
            }else if(count2 == 0 && arr[i]!=el1){

                count2=1;el2=arr[i];

            }else if(el1==arr[i]){

                count1++;

            }else if(el2==arr[i]){

                count2++;

            }else{

                count1--;
                count2--;

            }
        }
    
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == el1) count1++;
            else if (num == el2) count2++;
        }

        if (count1 > n / 3) list.add(el1);
        if (count2 > n / 3) list.add(el2);

        return list;
}
    public static void main(String[] args) {
        int[] arr ={1,1,1,1,2,2,3,3,3,3,3,3};
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}