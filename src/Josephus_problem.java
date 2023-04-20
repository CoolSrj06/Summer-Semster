import java.util.ArrayList;
public class Josephus_problem {
    public static void main(String[] args) {
        System.out.println(josephus(3,2));
    }
    public static int josephus(int n, int k)
    {
        boolean[] arr=new boolean[n];
        return function(n,k,arr,0,0,1,0);
    }
    private static int function(int n, int k, boolean[] arr,int killed,int i,int counter,int ans) {
        if (killed != n - 1) {

//            if counter is equal to k-th number and the person is alive(value in the array is false) then it proceeds in the body of 'if'
            if (counter == k&& !arr[i]) {
                arr[i] = true;
                if (i < n-1)//if 'i' is not at the end of the array
                    return function(n, k, arr, killed + 1, i + 1, 1,ans);
                else  //if 'i' is at the end of the array
                    return function(n, k, arr, killed + 1, 0, 1,ans);
            }
//    if counter is equal to k-th number and the person is dead(value in the array is true) then it proceeds in the body of 'if'
            if (counter == k&& arr[i]){
                if (i < n-1)//if 'i' is not at the end of the array
                    return function(n, k, arr, killed, i + 1, counter,ans);
                else//if 'i' is at the end of the array
                    return function(n, k, arr, killed, 0, counter,ans);
            }
//            checks if the value in the array is false
            if (!arr[i]) {
                if (counter < k && i != n-1)//if counter is less than kth value and i is not at the end of the array
                    return function(n, k, arr, killed, i + 1, counter + 1,ans);
                else//if counter is less than kth value and i is at the end of the array
                    return function(n, k, arr, killed, 0, counter + 1,ans);
            } else {//if the value in array is true
                if (counter < k && i != n-1)//if counter is less than kth value and i is not at the end of the array
                    return function(n, k, arr, killed, i + 1, counter,ans);
                else//if counter is less than kth value and i is at the end of the array
                    return function(n, k, arr, killed, 0, counter,ans);
            }
        }
        else
            ans= survivor(arr);//checks for the last value in the array which remains true
        return ans;
    }


    private static int survivor(boolean[] arr){
        int i;
        for (i = 0; i < arr.length; i++) {
            if(!arr[i])
                break;
        }
        return i+1;
    }
}

//class Solution
//{
//    public static int josephus(int n, int k)
//    {
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = 1; i<=n; i++) {
//            al.add(i);
//        }
//        solve(k-1, al, 0);
//        return al.get(0);
//    }
//    static void solve(int k, ArrayList<Integer> al, int index) {
//        if(al.size()==1) return;
//        index = (index+k)%al.size();
//        al.remove(index);
//        solve(k, al,index);
//    }
//}
