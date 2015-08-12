package PeakFinding;
import java.util.Scanner;


// this program implements the peak finding problem discussed in MIT 6.006 lectures

class driver {

	public static void main(String[] args) {
		System.out.println("Enter your Choice--> ");
		System.out.println("[1]: 1-D Array ");
		System.out.println("[2]: 2-D Array ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		int size = 10; // set the size of the array here
		if (choice == 1) {
			oneDimension myArray = new oneDimension(size);
			printArray(myArray.a);
			myArray.getPeak();
			System.out.printf("\n%d is a peak in the array",myArray.peak);
		}
		else if (choice == 2) { 
			twoDimension myArray = new twoDimension(size);
			printArray(myArray.a);
		}
		else {
			System.out.println("Invalid Choice");
		}
		in.close();
	}
	
	public static void printArray (int a[]) {
		System.out.println("The generated array is  ");
		for (int i = 0 ; i < a.length; i++) {
			System.out.printf("%d ",a[i]);
		}
	}
	
	public static void printArray (int a[][]) {
		System.out.println("The generated array is:  ");
		for (int i = 0 ; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%02d ",a[i][j]);
			}
		    System.out.println();
		}
	}
}
