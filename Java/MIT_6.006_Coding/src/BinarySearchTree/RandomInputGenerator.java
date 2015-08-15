package BinarySearchTree;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomInputGenerator {

	public static void main(String[] args) throws IOException {
		Random randomGenerator = new Random();
		int sizeOfInput = 10;
		System.out.println("Generating some random inputs: ");
		PrintWriter writer = new PrintWriter("inputKeys.txt", "UTF-8");
		for (int i = 0; i < sizeOfInput; i++){
			int randomNumber = randomGenerator.nextInt(100);
			if (i < sizeOfInput - 1){
				System.out.printf("%02d-->", randomNumber);
			}
			else {
				System.out.printf("%02d", randomNumber);
			}
			writer.println(randomNumber);
		}
		writer.close();
	}
}
