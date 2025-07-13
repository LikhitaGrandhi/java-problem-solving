import java.io.*;
import java.util.*;

public class Solution {

    // Function to check if a queen placed at (r, c) is safe from attacks
    public static boolean isSafe(int r, int c, int n, int a[][]) {

        // Check the entire row for other queens
        for (int i = 0; i < n; i++) {
            if (i == c) continue;  // Skip current position
            if (a[r][i] == 1) return false;  // Another queen found in the same row
        }

        // Check the entire column for other queens
        for (int i = 0; i < n; i++) {
            if (i == r) continue;  // Skip current position
            if (a[i][c] == 1) return false;  // Another queen found in the same column
        }

        // Check top-left diagonal (\ direction)
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (a[i][j] == 1) return false;
        }

        // Check top-right diagonal (/ direction)
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (a[i][j] == 1) return false;
        }

        // Check bottom-left diagonal (/ direction)
        for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) {
            if (a[i][j] == 1) return false;
        }

        // Check bottom-right diagonal (\ direction)
        for (int i = r + 1, j = c + 1; i < n && j < n; i++, j++) {
            if (a[i][j] == 1) return false;
        }

        // No attacks found — position is safe
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read board size
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        // Read the chessboard configuration (0 = empty, 1 = queen)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        boolean flag = true;  // To check if all queens are placed safely

        // Check all positions where a queen is placed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    // If any queen is not safe, set flag to false
                    if (isSafe(i, j, n, a) == false) {
                        flag = false;
                    }
                }
            }
        }

        // Output the result based on queen safety
        if (flag == true) {
            System.out.println("N Queens");  // No attacking queens
        } else {
            System.out.println("Danger");    // At least one queen is under attack
        }
    }
}
