package KarpRabin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// karp-rabin algorithm

public class RollingHashDriver {

	public static void main(String[] args) throws IOException {
		String pattern = "article";
		RollingHash.slidingWindow = pattern.length();
		// Read the document and create the target string
		BufferedReader br = new BufferedReader(new FileReader("karpRabin.txt"));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    while (line != null) {
	    	sb.append(line);
	        sb.append("\n");
	        line = br.readLine();
	    }
	    br.close();
	    sb.deleteCharAt(sb.length()-1); // delete the last "/n" character
	    String target = sb.toString(); 
	    karpRabin_1(pattern, target);
	    karpRabin_2(pattern, target);
	}
	
	private static void karpRabin_1(String p, String t) {
		System.out.println("Karp-Rabin 1");
		long startTime = System.nanoTime();   
		RollingHash r1 = new RollingHash();
		// Create the rolling hash of the pattern String
		for (int i = 0; i < p.length(); i++){
			r1.appendChar(p.charAt(i));
		}
		// Create the rolling hash of the target String 
	    RollingHash r2 = new RollingHash();
		for (int i = 0; i < p.length(); i++){
			r2.appendChar(t.charAt(i));
		}
		int matchCount = 0;
		// first check the substring equaling pattern's length
	    if (r1.hashValue == r2.hashValue) {
	    	if (p.equals(r2.s.toString())){
	    		matchCount++;
	    		System.out.println("Match Found");
	    	}
	    }
	    // compare the rest of the document
	    for (int i = p.length(); i < t.length() - p.length(); i++) {
	    	r2.appendChar(t.charAt(i));
	    	r2.skipChar(p.length());
	        if (r1.hashValue == r2.hashValue) {
		    	if (p.equals(r2.s.toString())){
		    		matchCount++;
		    	}
		    }
	    }
	    long stopTime = System.nanoTime(); 
	    long elapsedTime = stopTime - startTime;
	    System.out.println("# Matches Found: " + matchCount);
	    System.out.println("Time taken to find the matches: " + elapsedTime);
	}
	
	private static void karpRabin_2(String p, String t) {
		System.out.println("Karp-Rabin 2");
		long startTime = System.nanoTime();   
		RollingHash2 r1 = new RollingHash2();
		// Create the rolling hash of the pattern String
		for (int i = 0; i < p.length(); i++){
			r1.appendChar(p.charAt(i));
		}
		// Create the rolling hash of the target String 
	    RollingHash2 r2 = new RollingHash2();
		for (int i = 0; i < p.length(); i++){
			r2.appendChar(t.charAt(i));
		}
		int matchCount = 0;
		// first check the substring equaling pattern's length
		System.out.println("r1 Hash Value: " + r1.hashValue);
		System.out.println("r2 Hash Value: " + r1.hashValue);
	    if (r1.hashValue == r2.hashValue) {
	    	if (p.equals(r2.s.toString())){
	    		matchCount++;
	    		System.out.println("Match Found");
	    	}
	    }
	    // compare the rest of the document
	    for (int i = p.length(); i < t.length() - p.length(); i++) {
	    	r2.appendChar(t.charAt(i));
	    	r2.skipChar();
	        if (r1.hashValue == r2.hashValue) {
		    	if (p.equals(r2.s.toString())){
		    		matchCount++;
		    	}
		    }
	    }
	    long stopTime = System.nanoTime(); 
	    long elapsedTime = stopTime - startTime;
	    System.out.println("# Matches Found: " + matchCount);
	    System.out.println("Time taken to find the matches: " + elapsedTime);
	}
}
