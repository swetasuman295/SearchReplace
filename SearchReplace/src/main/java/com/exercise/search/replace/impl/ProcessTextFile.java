package com.exercise.search.replace.impl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.exercise.search.replace.model.Model;

public class ProcessTextFile {

	public void textReadWrite(Model model) throws IOException {

		String writeTextFile;
		FileWriter writer = new FileWriter(model.getDestinationFile());
		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

		try (BufferedReader br = Files.newBufferedReader(Paths.get(model.getSourceFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				writeTextFile = line.replaceAll(model.getSearchWord(), model.getReplaceWord());
				writer.write(writeTextFile+ "\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		writer.close();
		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

	}

}
