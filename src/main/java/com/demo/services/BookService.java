package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.BookReqDto;
import com.demo.entities.Author;
import com.demo.entities.Book;
import com.demo.repositories.AuthorRepo;
import com.demo.repositories.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	private final AuthorRepo authorRepo;
	
	public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
	}
	
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		
		bookRepo.findAll().forEach(books::add);
		
		return ResponseEntity.ok(books);
	}

	public ResponseEntity<?> addBook(BookReqDto dto) {
		Optional<Author> author = authorRepo.findById(dto.getAuthorId());
		
		if (author.isEmpty()) {
			return new ResponseEntity<String>("No author found with the given id", HttpStatus.NOT_FOUND);
		}
		
		Book model = new Book();
		model.setTitle(dto.getTitle());
		model.setAuthor(author.get());
		
		Book res = bookRepo.save(model);
		
		return ResponseEntity.ok(res);
	}
	
}
