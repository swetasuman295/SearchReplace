package com.exercise.search.replace.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.exercise.search.replace.api.ProcessSearchReplace;
import com.exercise.search.replace.model.Model;

public class ProcessSearchReplaceImpl implements ProcessSearchReplace {

	@Override
	public void readFileSource(Model model) {
		try {
			String searchWord = model.getSearchWord().substring(1, model.getSearchWord().length() - 1);
			String replaceWord = model.getReplaceWord().substring(1, model.getReplaceWord().length() - 1);

			Path source = Paths.get(model.getSourceFile());

			Path destination = Paths.get(model.getDestinationFile());
			Stream<String> lines = Files.lines(source);

			List<String> replaced = lines.map(line -> line.replaceAll(searchWord, replaceWord))
					.collect(Collectors.toList());
			Files.write(destination, replaced);
			lines.close();
			System.out.println("Find and Replace done!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
