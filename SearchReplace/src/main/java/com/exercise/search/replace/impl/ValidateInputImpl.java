package com.exercise.search.replace.impl;

import java.io.File;

import com.exercise.search.replace.api.ValidateInput;
import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.model.Model;

/**
 * @Description: Class for the validation of Input Arguments.
 *
 */
public class ValidateInputImpl implements ValidateInput {

	/**
	 *@Description: Validate File type, File Source and File Extension for Input Provided.
	 */
	@Override
	public void validateInputArgs(Model model) throws InputArgumentException {
		File source = new File(model.getSourceFile());
		File destination = new File(model.getDestinationFile());

		if (!(model.getFileType().equalsIgnoreCase("xml") || model.getFileType().equalsIgnoreCase("txt")))
			throw new InputArgumentException("Only XML and Text is Supported");
		
		if ((model.getSearchWord().isEmpty() || model.getReplaceWord().isEmpty()))
			throw new InputArgumentException("Please Provide Search/Replace Word");

		if (!(source.canRead() || source.exists() || source.isFile()) || source.getName().endsWith("*.xml")
				|| source.getName().endsWith("*.txt"))
			throw new InputArgumentException("Problem Exist with the Source File");

		if (!(destination.getName().endsWith("xml") || destination.getName().endsWith("txt")))
			throw new InputArgumentException("Problem Exist with the Destination File");
		
		
		

	}

}