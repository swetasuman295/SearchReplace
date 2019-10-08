package com.exercise.search.replace.api;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.model.Model;
/**
 * @Description : Interface for Validating Input Passed as Command Line Parameters
 * 
 */
public interface ValidateInput {

	/**
	 * @param Command Line Arguments as Model POJO Bean
	 * @throws InputArgumentException
	 * @throws IOException 
	 * @throws TransformerException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void validateInputArgs(Model model) throws InputArgumentException, IOException, ParserConfigurationException, SAXException, TransformerException;

}