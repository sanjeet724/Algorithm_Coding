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
			System.out.println("Inserting into heap: " + heapItem.key);
			heap.addItem(heapItem);
		}
		scanner.close();
		// heap.heapSort();  // Heap Sort Algorithm
		heap.buildMaxHeap(); 
		while(heap.size != 0){
			System.out.println("Max is " + heap.ExtractMax().key);
		}
	}
}
