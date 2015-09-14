package KarpRabin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//karp-rabin algorithm

public class RollingHashDriver {

	public static void main(String[] args) throws IOException {
		String pattern = "works";
		RollingHash r = new RollingHash(new StringBuilder(pattern));
		long patternHash = r.getHashValue();
		// Read the document and create the giant string
		BufferedReader br = new BufferedReader(new FileReader("karpRabin.txt"));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    while (line != null) {
	    	sb.append(line);
	        sb.append("\n");
	        line = br.readLine();
	    }
	    br.close();
	    // our huge string
	    String target = sb.toString(); 
	    // check the first n characters
	    StringBuilder sliding = new StringBuilder(target.substring(0, pattern.length()));
	    RollingHash t = new RollingHash(sliding);
	    long slidingValue = t.getHashValue();
	    if (slidingValue == patternHash) {
	    	if (pattern.equals(sliding)){
	    		System.out.println("Match Found");
	    	}
	    }
	    for (int i = pattern.length(); i < target.length() - pattern.length(); i++) {
	    	t.append(target.charAt(i));
	    	t.skip();
	    	// System.out.println("Sliding String: " + t.x);
	    	slidingValue = t.getHashValue();
	        if (slidingValue == patternHash) {
	        	// System.out.println("hash value matches");
		    	if (pattern.equals(t.x.toString())){
		    		System.out.println("Sliding String: " + t.x);
		    		System.out.println("Match Found");
		    	}
		    }
	    }
	 
	}
}
