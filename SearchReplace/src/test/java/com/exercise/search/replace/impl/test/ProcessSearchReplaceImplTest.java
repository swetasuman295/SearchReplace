package com.exercise.search.replace.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.exercise.search.replace.model.Model;

public class ProcessSearchReplaceImplTest {
	@Mock
	Model model;

	@Test
	public void readFileSourceTest() {
		
		Mockito.when(model.getFileType()).thenReturn("txt");
		Mockito.when(model.getSearchWord()).thenReturn("Customer");
		Mockito.when(model.getReplaceWord()).thenReturn("Client");
		Mockito.when(model.getSourceFile()).thenReturn("src/test/resources/Input.txt");
		Mockito.when(model.getDestinationFile()).thenReturn("src/test/resources/Result.txt");
		
		
		
		
		
		

	}

}
