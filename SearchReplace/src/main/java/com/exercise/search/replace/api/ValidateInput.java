package com.exercise.search.replace.api;

import com.exercise.search.replace.exception.InputArgumentException;
import com.exercise.search.replace.model.Model;

public interface ValidateInput {

	public void validateInputArgs(Model model) throws InputArgumentException;

}
