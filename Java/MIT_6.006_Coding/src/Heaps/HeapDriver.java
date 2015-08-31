package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        // create a array for the heap
		Heap heap = new Heap(); // check input file for # of items
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			HeapItem  heapItem = new HeapItem(scanner.nextInt());
			 System.out.println("Adding to the array: " + heapItem.key);
			 heap.addItem(heapItem); 
		}
		scanner.close(); 
		heap.buildMaxHeap(); 
		heap.heapSort();		
	}
}
