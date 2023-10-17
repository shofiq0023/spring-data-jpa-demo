package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.BookReqDto;
import com.demo.services.BookService;

@RestController
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody BookReqDto dto) {
		return bookService.addBook(dto);
	}
}
