package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.AuthorReqDto;
import com.demo.dto.AuthorWithBookReqDto;
import com.demo.dto.BookReqDto;
import com.demo.entities.Author;
import com.demo.entities.Book;
import com.demo.repositories.AuthorRepo;

@Service
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

	public ResponseEntity<?> createAuthor(AuthorReqDto dto) {
		Author model = new Author();
		model.setName(dto.getName());
		
		Author res = authorRepo.save(model);
		
		return ResponseEntity.ok(res);
	}
	
	public ResponseEntity<?> getAuthor(long id) {
		Optional<Author> author = authorRepo.findById(id);
		
		if (author.isPresent()) {
			return ResponseEntity.ok(author.get());
		} else {
			return new ResponseEntity<String>("No author found with the given id", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> createAuthorWithBooks(AuthorWithBookReqDto dto) {
		Author model = new Author();
		
		model.setName(dto.getName());
		dto.getBooks().forEach(b -> b.setAuthor(model));
		
		model.setBooks(dto.getBooks());
		
		Author res = authorRepo.save(model);
		
		return ResponseEntity.ok(res);
	}
}













