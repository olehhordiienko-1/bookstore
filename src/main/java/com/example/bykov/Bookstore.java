package com.example.bykov;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bookstore implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String store_name;
	private String store_number;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Book book;

	public Bookstore() {
	}

	public Bookstore(String shop_name, String owner_email, Book book) {
		this.store_name = shop_name;
		this.store_number = owner_email;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bookstore: " +
				"id - " + id +
				" name - " + store_name +
				" number - " + store_number +
				" book - " + book;
	}
}