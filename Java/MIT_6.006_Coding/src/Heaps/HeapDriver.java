package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        // create a array for the heap
		Heap heap = new Heap(10); // check input file for # of items
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			HeapItem  heapItem = new HeapItem(scanner.nextInt());
			System.out.println("Adding to the array: " + heapItem.key);
			heap.addItem(heapItem);
		}
		scanner.close(); 
		heap.buildMaxHeap(); // build the heap first
		// heap.heapSort();  // Heap Sort Algorithm
		// some extractions and increasing the keys
		heap.IncreaseKey(9,96);
		heap.printHeap();
		heap.ExtractMax();
		heap.ExtractMax();
		heap.ExtractMax();
		heap.printHeap();
		heap.IncreaseKey(6,99);
		heap.printHeap();
		heap.ExtractMax();
		heap.printHeap();
	}
}
