// Print Sum of Elements Except Itself
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int s=0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s=s+a[i];
        }
      for (int i = 0; i < n; i++) {
            System.out.println((s - a[i]));
        }
        
        
    }
}
