package HashLab;

public class Tester {
	static long base = 256;
	static long prime = 23;

	public Tester () {

	}
	
	// returns an integer equivalent to the string
	public long getNumericValue(String s){
		System.out.println("Input String: " + s);
		long sum = 0;
		for (int i = 0 ;i < s.length(); i++){
			sum = (sum + (long) s.charAt(i) * (long) Math.pow(base,i));
		}
		System.out.println("Numeric Value of String: " + sum);
		this.HashIndex(sum);
		return sum;
	}
	
	private int HashIndex(long numericValue) {
		long index = numericValue % prime;
		System.out.println("Hash Index of String: " + index);
		return (int) index;
	}
}
