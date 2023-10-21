// import java.util.ArrayList;
import java.util.*;
public class Solution {

    public static int countStudents(ArrayList<Integer> arr, int pages){
         int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        if(arr.size() < m){
            return -1;
        }

        int min = Collections.max(arr);
        int sum = 0;
        for(int x : arr){
            sum+=x;
        }
        int max = sum;

        for(int i=min;i<max ;i++){
            if(countStudents(arr,i)==m){
                return i;
            }
        }

        return -1;
    }
}