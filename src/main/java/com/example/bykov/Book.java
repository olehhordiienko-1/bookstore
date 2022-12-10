package com.example.bykov;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int count_pages;
	private String author;

	@Column(unique = true)
	private String book_name;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Bookstore> bookstores;

	public Book() {
	}

	public Book(String book_name, int count_pages, String author) {
		this.book_name = book_name;
		this.count_pages = count_pages;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book: " +
				"id - " + id +
				" book name - " + book_name +
				" pages - " + count_pages +
				" author - " + author;
	}
}