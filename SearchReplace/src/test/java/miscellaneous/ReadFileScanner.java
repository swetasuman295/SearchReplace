package miscellaneous;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadFileScanner {
	public static void main(String args[]) throws IOException {

		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
		fileReader();
		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

	}

	public static void fileReader() throws IOException {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = new FileOutputStream("src/main/resources/Scanner.txt");
		Scanner sc = null;

		try {
			inputStream = new FileInputStream("src/main/resources/TestSmall.txt");
			sc = new Scanner(inputStream, "UTF-8");
			System.out.println("Free Memory : " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)));
			System.out.println("Max Memory  : " + (Runtime.getRuntime().maxMemory() / (1024 * 1024)));
			System.out.println("Total Memory  : " + (Runtime.getRuntime().totalMemory() / (1024 * 1024)));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				byte b[] = line.replaceAll("customer", "Client").getBytes();

				outputStream.write(b);
				outputStream.write("\n".getBytes());

			}
			System.out.println("Done");
			System.out.println("Free Memory : " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)));
			System.out.println("Max Memory  : " + (Runtime.getRuntime().maxMemory() / (1024 * 1024)));
			System.out.println("Total Memory  : " + (Runtime.getRuntime().totalMemory() / (1024 * 1024)));
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
				outputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
	}

}
