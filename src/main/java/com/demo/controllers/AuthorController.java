package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.services.AuthorService;

public class AuthorController {
	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/authors")
	public ResponseEntity<?> getAllAuthors() {
		return authorService.getAllAuthors();
	}
}
