package KarpRabin;

// Rolling Hash ADT

public class RollingHash {
	static String s;
	static int a = 10;   // size of ascii alphabet
	static int m = 10079;  // a 4-digit prime
	StringBuilder x;
	
	public RollingHash(StringBuilder someString){
		this.x = someString;
	}
	
	// treat the string as an array of numbers
	// hash[d3,d2,d1,d0] = (d3*a^3 + d2*a^2 + d1*a^1 + d0*a^0) mod m
	public long getHashValue(){
		int sum = 0;
		for (int i = 0 ;i < this.x.length(); i++){
			sum = (int) (sum + (int)this.x.charAt(i) * Math.pow(a,i));
		}
		// System.out.println("Sum is : " + sum);
		// System.out.println("Hash Index is: " + sum%m);
		return sum % m;
	}
	
	public void append(char c) {
		this.x.append(c);
	}
	
	public void skip() {
		this.x.deleteCharAt(0);
	}

}
