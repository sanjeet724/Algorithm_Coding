package KarpRabin;

// Rolling Hash ADT
// Using the hash values directly  and using caches

public class RollingHash2 {
	static long base = 256;
	static long prime = 23;
	static long slidingWindow;
	StringBuilder s;
	long numericValue;
	long hashValue;
	// cache the values
	long skipCache; 
	long hashCache;
	long baseCache;
	
	
	public RollingHash2(){
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
	
	private void HashIndex(long numericValue) {
		long index = Math.abs(this.numericValue % prime);
		this.hashValue = index;
		this.setCaches();
	}
	
	private void setCaches() {
		this.hashCache =  Math.abs(this.numericValue % prime);
		this.baseCache = base % prime;
	}
	
	// updates the numeric value during an append operation
	private void appendUpdate(char c) {
		this.hashValue = this.hashCache*this.baseCache + (long)c % prime;
	}
	
	public void appendChar(char c){
		this.s.append(c);
		this.appendUpdate(c);
	}
	
	// updates the numeric value during a skip operation
	private void skipUpdate(char c) {
		// set the skipMultiplier
		if (this.skipCache == 0){
			this.skipCache = Math.abs((long) Math.pow(base, slidingWindow) % prime);
		}
		this.hashValue = this.hashCache - ((long)c % prime) * (this.skipCache);
	}
	
	public void skipChar() {
		char c = this.s.charAt(0);
		this.s.deleteCharAt(0);
		this.skipUpdate(c);
	}
}

