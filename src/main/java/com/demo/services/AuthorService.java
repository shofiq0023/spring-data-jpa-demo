package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.entities.Author;
import com.demo.repositories.AuthorRepo;

public class AuthorService {
	private final AuthorRepo authorRepo;
	
	public AuthorService(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}

	public ResponseEntity<?> getAllAuthors() {
		List<Author> authors = new ArrayList<Author>();
		
		authorRepo.findAll().forEach(authors::add);
		
		return ResponseEntity.ok(authors);
	}
}
