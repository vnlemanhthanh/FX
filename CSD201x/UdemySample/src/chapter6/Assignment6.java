package chapter6;

public class Assignment6 {
	
	/**
	 * PROBLEM 1
	 * We are assuming that the parameters are positive integer numbers
	 * @param args
	 */
	public int add(int a, int b) {
		if (b == 0) return a;
		return add(a+1, b-1);
	}
		
	/**
	 * PROBLEM 2
	 * @param n - a positive integer
	 * @return the sum of squares of first n numbers
	 */
	public int sumOfSquares(int n) {
		if (n==1) return 1;
		return n*n + sumOfSquares(n-1);
	}
	
	/**
	 * PROBLEM 3
	 * See the code in TowerOfHanoi class (have added a variable named numOfMoves)
	 */
	
	public static void main(String[] args) {
		Assignment6 prob = new Assignment6();
		System.out.println(prob.sumOfSquares(3));
	}

}
