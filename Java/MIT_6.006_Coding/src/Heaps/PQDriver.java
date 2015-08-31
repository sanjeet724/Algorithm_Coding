package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class PQDriver {

	public static void main(String[] args) throws IOException {
		PriorityQueue maxQ = new PriorityQueue();
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			 maxQ.InsertIntoHeap(scanner.nextInt());
		}
		scanner.close();
		maxQ.IncreaseKey(9,96);
		maxQ.ExtractMax();
		maxQ.ExtractMax();
		maxQ.ExtractMax();
		maxQ.IncreaseKey(6,99);
		maxQ.ExtractMax();
		maxQ.InsertIntoHeap(24);
		maxQ.InsertIntoHeap(278);
		maxQ.ExtractMax();
		// kind of heap sort
		while (maxQ.size != 0) {
			maxQ.ExtractMax();
		}
		maxQ.InsertIntoHeap(50);
		maxQ.InsertIntoHeap(90);
		maxQ.IncreaseKey(1,95);
		maxQ.ExtractMax();
		maxQ.InsertIntoHeap(89);
		maxQ.InsertIntoHeap(67);
		maxQ.InsertIntoHeap(33);
		maxQ.printHeap();
	}

}
