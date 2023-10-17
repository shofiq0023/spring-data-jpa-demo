package com.demo.dto;

import java.util.List;

import com.demo.entities.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorWithBookReqDto {
	private long authorId;
	private String name;
	private List<Book> books;
}
