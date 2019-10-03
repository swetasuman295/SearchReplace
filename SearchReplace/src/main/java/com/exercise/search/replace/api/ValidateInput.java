package com.exercise.search.replace.api;

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
	 */
	public void validateInputArgs(Model model) throws InputArgumentException;

}