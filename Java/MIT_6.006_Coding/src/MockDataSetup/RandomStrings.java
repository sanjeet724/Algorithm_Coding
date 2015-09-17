package MockDataSetup;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

public class RandomStrings {

	public static void main(String[] args) throws IOException {
		Random randomGenerator = new Random();
		System.out.println("Generating some random uique inputs: ");
		PrintWriter writer = new PrintWriter("inputStrings.txt", "UTF-8");
		int sizeOfInput = 0;
		while (sizeOfInput != 80000){
			Integer randomNumber = randomGenerator.nextInt(1000);
			String randomString = UUID.randomUUID().toString() + randomNumber.toString();
			System.out.println("String generated is: " + randomString);
			writer.println(randomString);
			sizeOfInput++;
		}
		writer.close();
	}

}
