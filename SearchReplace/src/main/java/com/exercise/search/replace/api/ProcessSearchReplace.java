package com.exercise.search.replace.api;

import com.exercise.search.replace.model.Model;

/**
 * @Description : Interface for Process File type and Replace Word.
 * 
 */
public interface ProcessSearchReplace {
	/**
	 * @param Takes Command Line Arguments as Model POJO Bean
	 * @return 
	 */
	public void readFileSource(Model model);
}