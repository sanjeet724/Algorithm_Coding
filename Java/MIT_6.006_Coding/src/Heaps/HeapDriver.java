package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        
		// create an array of 10 heap nodes
		HeapNode [] heapArray = new HeapNode[10];
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		int index = 0;
		while (scanner.hasNextInt()){
			HeapNode h = new HeapNode(scanner.nextInt());
			heapArray[index] = h;
			index++;
		}
		scanner.close();
	}

}
