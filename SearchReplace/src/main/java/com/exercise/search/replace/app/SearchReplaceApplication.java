package com.exercise.search.replace.app;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.search.replace.model.Model;

public class SearchReplaceApplication {
@Autowired
private Model model;
	public static void main(String[] args) {
	for(int i=0;i<args.length;i++) {
		
		System.out.println(args[i]);
		
		
		
		
	}
	}

}
