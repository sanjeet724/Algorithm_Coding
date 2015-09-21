package HashLab;

public class RollHash {
	static long base = 256;
	static long prime = 23;
	StringBuilder s;
	long numericValue;
	long hashValue;
	
	public RollHash() {
		this.s = new StringBuilder();
		this.numericValue = this.getNumericValue();
	}
	
	public long getNumericValue(){
		//System.out.println("Creating a blank String");
		long sum = 0;
		for (int i = this.s.length()-1 ; i >= 0; i--){
			sum = (sum + (long) this.s.charAt(i) * (long) Math.pow(base,i-(this.s.length()-1)));
		}
		System.out.println("Numeric Value of String: " + sum);
		this.HashIndex(sum);
		return sum;
	}
	
	// updates the numeric value during an append operation
	private void appendUpdate(char c) {
		this.numericValue = this.numericValue * base + (long)c;
		// System.out.println("Numeric Value of String updated to : " + this.numericValue);
		// System.out.println(this.s + " : " + this.numericValue);
		this.HashIndex(this.numericValue);
	}
	
	private int HashIndex(long numericValue) {
		long index = Math.abs(this.numericValue % prime);
		this.hashValue = index;
		System.out.println(this.s + " : " + this.hashValue);
		return (int) index;
	}
	
	public void appendChar(char c){
		this.s.append(c);
		this.appendUpdate(c);
	}
	
	// updates the numeric value during an skip operation
	// check notes for this formula
	private void skipUpdate(char c){
		// long power = Math.abs(this.hashValue) - 1;
		 // this.numericValue = this.numericValue - ((long)c * (long)Math.pow(base, this.hashValue - 1));
		// this.numericValue = this.numericValue - (Math.abs(((this.numericValue/base) % prime))  * (long)c);
		this.numericValue = this.numericValue - (this.numericValue/base)*(long)c ;
	    // System.out.println(this.s + " : " + this.numericValue);
		this.HashIndex(this.numericValue);
	}
	
	public void skipChar() {
		char c = this.s.charAt(0);
		this.s.deleteCharAt(0);
		this.skipUpdate(c);
	}
	
}
