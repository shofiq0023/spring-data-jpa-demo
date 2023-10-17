package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AuthorReqDto;
import com.demo.dto.AuthorWithBookReqDto;
import com.demo.services.AuthorService;

@RestController
public class AuthorController {
	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/authors")
	public ResponseEntity<?> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@PostMapping("/author")
	public ResponseEntity<?> createAuthor(@RequestBody AuthorReqDto dto) {
		return authorService.createAuthor(dto);
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<?> getAuthor(@PathVariable("id") long id) {
		return authorService.getAuthor(id);
	}
	
	@PostMapping("/author/book")
	public ResponseEntity<?> createAuthorWithBooks(@RequestBody AuthorWithBookReqDto dto) {
		return authorService.createAuthorWithBooks(dto);
	}
	
}
