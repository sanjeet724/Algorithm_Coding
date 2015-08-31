package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        // create a array for the heap
		Heap heap = new Heap(20); // check input file for # of items
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			HeapItem  heapItem = new HeapItem(scanner.nextInt());
			 System.out.println("Adding to the array: " + heapItem.key);
			 heap.addItem(heapItem); 
		}
		scanner.close(); 
		heap.buildMaxHeap(); // build the heap
		heap.IncreaseKey(9,96);
		heap.ExtractMax();
		heap.ExtractMax();
		heap.ExtractMax();
		heap.IncreaseKey(6,99);
		heap.ExtractMax();
		heap.InsertIntoHeap(45); // maintain the heap when new elements are added
		heap.InsertIntoHeap(109);
		heap.ExtractMax();
		heap.heapSort();
	}
}
