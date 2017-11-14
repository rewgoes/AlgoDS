package os;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class LinuxTail {

	public static void run() {

		File file = new File("test.txt");
		try {
			file.createNewFile();

			System.setOut(new PrintStream(file));

			while (true) {
				System.out.println("Bla");
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
