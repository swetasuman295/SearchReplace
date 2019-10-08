package com.exercise.search.replace.impl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.search.replace.model.Model;

public class ProcessTextFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessTextFile.class);

	public void textReadWrite(Model model) throws IOException {

		FileWriter writer = new FileWriter(model.getDestinationFile());
		LOGGER.info("Processing Text File Started at "
				+ DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

		writeFile(model, writer);
		LOGGER.info("Processing Text File Completed  at "
				+ DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

	}

	/**
	 * @param model
	 * @param writer
	 * @throws IOException
	 */
	private void writeFile(Model model, FileWriter writer) throws IOException {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(model.getSourceFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				replaceSearchReplace(model, writer, line);
			}
		} catch (IOException e) {
			LOGGER.error("IOException: %s%n", e);
		}
		writer.close();
	}

	/**
	 * @param model
	 * @param writer
	 * @param line
	 * @throws IOException
	 */
	private void replaceSearchReplace(Model model, FileWriter writer, String line) throws IOException {
		String writeTextFile;
		writeTextFile = line.replaceAll(model.getSearchWord(), model.getReplaceWord());
		writer.write(writeTextFile + "\n");
	}

}
