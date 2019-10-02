package com.exercise.search.replace.impl;

import java.io.File;

import com.exercise.search.replace.api.ValidateInput;
import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.model.Model;

public class ValidateInputImpl implements ValidateInput {

	@Override
	public void validateInputArgs(Model model) throws InputArgumentException {
		File source = new File(model.getSourceFile());
		File destination = new File(model.getDestinationFile());

		if (!(model.getFileType().equalsIgnoreCase("xml") || model.getFileType().equalsIgnoreCase("xml")))
			throw new InputArgumentException("Only XML and Text is Supported");
		if ((model.getSearchWord().isBlank() || model.getReplaceWord().isBlank()))
			throw new InputArgumentException("Please Provide Search/Replace Word");

		if (!(source.canRead() || source.exists() || source.isFile()) || source.getName().endsWith("*.xml")
				|| source.getName().endsWith("*.txt"))
			throw new InputArgumentException("Problem Exist with the Source File");

		if (!(destination.getName().endsWith("xml") || destination.getName().endsWith("txt")))
			throw new InputArgumentException("Problem Exist with the Destination File");

	}

}
