package com.exercise.search.replace.app;

import com.exercise.search.replace.api.ProcessSearchReplace;
import com.exercise.search.replace.api.ValidateInput;
import com.exercise.search.replace.exception.ArgumentException;
import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.impl.ProcessSearchReplaceImpl;
import com.exercise.search.replace.impl.ValidateInputImpl;
import com.exercise.search.replace.model.Model;

public class SearchReplaceApplication {

	public static void main(String[] args) throws ArgumentException, InputArgumentException {

		// "Use This in Path Variable to execute"
		// xml “trace” “error” < src/main/resources/configuration.xml >
		// src/main/resources/Results/result.xml

		Model model = new Model();
		ValidateInput validateInput = new ValidateInputImpl();
		ProcessSearchReplace readFile = new ProcessSearchReplaceImpl();

		if (args.length == 7) {
			for (int i = 0; i < args.length; i++) {
				model.setFileType(args[0]);
				model.setSearchWord(args[1]);
				model.setReplaceWord(args[2]);
				model.setSourceFile(args[4]);
				model.setDestinationFile(args[6]);
			}
		} else
			throw new ArgumentException(
					"Please Provide input in the format : xml “trace” “error” < configuration.xml > result.xml");

		validateInput.validateInputArgs(model);
		readFile.readFileSource(model);

	}
}