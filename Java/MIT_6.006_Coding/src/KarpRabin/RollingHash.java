package KarpRabin;

// Rolling Hash ADT

public class RollingHash {
	static long base = 256;
	static long prime = 997;
	StringBuilder s;
	long numericValue;
	long hashValue;
	long skipMultiplier; // skipMultiplier's cache
	
	public RollingHash(){
		this.s = new StringBuilder();
		this.numericValue = this.getNumericValue();
	}
	
	// treat the string as an array of numbers
	// hash[d3,d2,d1,d0] = (d3*a^3 + d2*a^2 + d1*a^1 + d0*a^0) mod m
	public long getNumericValue(){
		long sum = 0;
		for (int i = this.s.length()-1 ; i >= 0; i--){
			sum = (sum + (long) this.s.charAt(i) * (long) Math.pow(base,i-(this.s.length()-1)));
		}
		this.HashIndex(sum);
		return sum;
	}
	
	private int HashIndex(long numericValue) {
		long index = Math.abs(this.numericValue % prime);
		this.hashValue = index;
		return (int) index;
	}
	
	// updates the numeric value during an append operation
	private void appendUpdate(char c) {
		this.numericValue = this.numericValue * base + (long)c;
		this.HashIndex(this.numericValue);
	}
	
	public void appendChar(char c){
		this.s.append(c);
		this.appendUpdate(c);
	}
	
	// updates the numeric value during a skip operation
	private void skipUpdate(char c, int lenOfPattern){
		// set the skipMultiplier
		if (this.skipMultiplier == 0){
			this.skipMultiplier = (long) Math.pow(base, lenOfPattern);
		}
		this.numericValue = this.numericValue - (long)c*this.skipMultiplier;
		this.HashIndex(this.numericValue);
	}
	
	public void skipChar(int lenOfPattern) {
		char c = this.s.charAt(0);
		this.s.deleteCharAt(0);
		this.skipUpdate(c,lenOfPattern);
	}

}
