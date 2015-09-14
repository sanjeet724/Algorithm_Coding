package KarpRabin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// karp-rabin algorithm

public class RollingHashDriver {

	public static void main(String[] args) throws IOException {
		String pattern = "article";
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
	    String target = sb.toString(); 
	    karpRabin(pattern, target);
	}
	
	private static void karpRabin(String p, String t) {
		// rolling hash for the pattern
		int matchCount = 0;
		RollingHash r1 = new RollingHash(new StringBuilder(p));
		long patternHash = r1.getHashValue();
		// rolling hash for the sliding window
		// first check the substring equaling pattern's length
	    StringBuilder slidingString = new StringBuilder(t.substring(0, p.length()));
	    RollingHash r2 = new RollingHash(slidingString);
	    long slidingHash = r2.getHashValue();
	    // System.out.println("Sliding String: " + r2.x);
	    if (slidingHash == patternHash) {
	    	if (p.equals(slidingString.toString())){
	    		matchCount++;
	    		System.out.println("Match Found");
	    	}
	    }
	    for (int i = p.length(); i < t.length() - p.length(); i++) {
	    	// System.out.println("Sliding String: " + r2.x);
	    	r2.append(t.charAt(i));
	    	r2.skip();
	    	slidingHash = r2.getHashValue();
	        if (slidingHash == patternHash) {
		    	if (p.equals(r2.x.toString())){
		    		// System.out.println("Sliding String: " + r2.x);
		    		matchCount++;
		    		// System.out.println("Match Found");
		    	}
		    }
	    }
	    System.out.println("# Matches Found: " + matchCount);
	}
}
