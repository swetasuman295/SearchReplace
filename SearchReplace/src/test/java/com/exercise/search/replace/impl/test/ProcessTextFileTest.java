package com.exercise.search.replace.impl.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ProcessTextFileTest {

	/**
	 * @Description:  Comparing both the Text files are equal or not
	 * @throws IOException
	 */
	@Test
	public void compareTextFile() throws IOException {
		FileWriter writer = new FileWriter("src/test/resources/ResultTextFile.txt");
		File file1 = new File("src/test/resources/ResultTextFile.txt");
		File file2 = new File("src/test/resources/Expected.txt");
		

		try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/resources/SmallTextFile.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String writeTextFile;
				writeTextFile = line.replaceAll("Welcome", "WELCOME");
				writer.write(writeTextFile + "\n");
			}
			writer.close();

		}
		assertThat(file1).hasSameContentAs(file2);
		assertEquals("Same Size", file1.length(), file2.length());

	}
}
