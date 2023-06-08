package chapter1;


public class GCDFinder {
	/**
	 * This method takes two positive integers and finds their gcd using 
	 * Euclid's algorithm
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcd(int a, int b) {
		if (b == 0) return a;
//		System.out.println(a + " " + b);
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			System.out.println(new GCDFinder().gcd(i, 1234)); // should print 5
		}
	}
}
