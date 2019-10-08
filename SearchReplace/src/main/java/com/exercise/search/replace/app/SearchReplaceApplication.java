package com.exercise.search.replace.app;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.exercise.search.replace.api.ValidateInput;
import com.exercise.search.replace.exception.ArgumentException;
import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.impl.ValidateInputImpl;
import com.exercise.search.replace.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: Execution Starts from this Class. Command Line Arguments are
 *               passed as Parameter at the start of the Application.
 *
 */
public class SearchReplaceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchReplaceApplication.class);

	/**
	 * @param args
	 * @throws ArgumentException
	 * @throws InputArgumentException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws ArgumentException, InputArgumentException, IOException,
			ParserConfigurationException, SAXException, TransformerException {

		// "Use This in Variable to execute"
		// xml “trace” “error” < src/main/resources/configuration.xml >
		// src/main/resources/Results/result.xml

		Model model = new Model();
		ValidateInput validateInput = new ValidateInputImpl();

		if (args.length == 7) {
			model.setFileType(args[0]);
			model.setSearchWord(args[1]);
			model.setReplaceWord(args[2]);
			model.setSourceFile(args[4]);
			model.setDestinationFile(args[6]);
			LOGGER.info("Arguments Provided are as per Requirement, Validation starting");
		} else {

			
			throw new ArgumentException(
					"Please Provide input in the format : fileType “searchWord” “replacedWord” < sourceFilePath > destinationFilePath");
		}
			
		
		validateInput.validateInputArgs(model);
		
	}
}