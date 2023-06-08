package lab6;

import java.util.Scanner;

public class Queen {
    private int n, count;
    private boolean cl[], ld[], rd[];
    private int x[];

    public Queen(int n) {

        this.n = n;
        count = 0;

        x = new int[n + 1];
        for (int i = 1; i <= n; i++) x[i] = -1;

        cl = new boolean[n + 1];
        for (int i = 1; i <= n; i++) cl[i] = true;

        ld = new boolean[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) ld[i] = true;

        rd = new boolean[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) rd[i] = true;

    }

    /**
     * Utility method to print result for testUtil
     */
    private void result() {
        System.out.printf("Solution %-5d:", ++count);
        for (int i = 1; i <= n; i++) System.out.printf("%3d", x[i]);
        System.out.println();
    }

    /**
     * Recursive method to find safe position in a column to place queen
     * Reference: https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
     * @param col
     */
    private void solveUtil(int col) {

        /* If recursive reach column (last + 1)
        means queens are places each column.
        Then print the result and return. */
        if (col > n) {
            result();
            return;
        }

        /* Check for each row in argument column */
        for (int row = 1; row <= n; row++) {

            /* If row is safe */
            if (cl[row] && ld[row - col + n] && rd[row + col]) {

                /* Mark queen is placed */
                cl[row] = ld[row - col + n] = rd[row + col] = false;
                x[col] = row;

                /* Recursive call for next column */
                solveUtil(col + 1);

                /* Back tracking, mark queen is not placed */
                cl[row] = ld[row - col + n] = rd[row + col] = true;
                x[col] = -1;
            }
        }
    }

    private void solveUtil() {


        /* Check for each row in argument column */
        for (int row = 1; row <= (n+1)/2; row++) {

            /* If row is safe */
            if (cl[row] && ld[row - 1 + n] && rd[row + 1]) {

                /* Mark queen is placed */
                cl[row] = ld[row - 1 + n] = rd[row + 1] = false;
                x[1] = row;

                /* Recursive call for next column */
                solveUtil(2);

                /* Back tracking, mark queen is not placed */
                cl[row] = ld[row - 1 + n] = rd[row + 1] = true;
                x[1] = -1;
            }
        }
    }

    /**
     * Wrapper for recursive solveUtil method,
     * always start testing from column one
     */
    public void solve() {
        solveUtil();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter number of columns: ");
            int n = Integer.parseInt(console.nextLine());
            Queen queen = new Queen(n);
            queen.solve();
            System.out.print("Enter 1 to continue...");
            int e = Integer.parseInt(console.nextLine());
            if (e != 1) {
                System.out.println("\nGoodbye!");
                break;
            }
        }

    }

}
