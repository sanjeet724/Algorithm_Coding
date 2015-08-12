package PeakFinding;
import java.util.Random;

public class oneDimension {
	int size;
	int a[];
	int peak;
	
	// default constructor
	public oneDimension(int s) {
		size = s;
		a = new int[size];
		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++){
			a[i] = randomGenerator.nextInt(100); // generate random numbers between 1-100
		}
	}
	
	public void getPeak() {
		int currentIndex = size/2; // starting point of the recursion
		peak = findPeak(currentIndex);
	}
		
	private int findPeak(int c) {
		// System.out.printf("\nCurrent Index is %d: ", c);
		if ( c == 0 || c == size-1) {
			return a[c];
		}
		else {
			if (a[c] < a[c-1]){ // search in left half
				c = c/2;
				return findPeak(c);
		    } 
		    else if (a[c] < a[c+1]){ // search in right half
			    c = c + c/2;
			    return findPeak(c);
		    }
		    else {
			    return a[c];
		    }
		}
	}

}
