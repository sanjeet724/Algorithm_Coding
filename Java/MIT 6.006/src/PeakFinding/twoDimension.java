package PeakFinding;
import java.util.Random;


public class twoDimension {
	int size;
	int a[][];
	int peak;
	
	public twoDimension(int s) {
		size = s;
		a = new int[size][size];
		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				a[i][j] = randomGenerator.nextInt(100); // generate random numbers between 1-100
			}
		}
	}

}
