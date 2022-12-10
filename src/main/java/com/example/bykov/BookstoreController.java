package com.example.bykov;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {
	private static final Logger logger = Logger.getLogger(BookstoreController.class);

	@Autowired
	private BookstoreRepository bookstoreRepository;
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/bookstore")
	public String blogMain(Model model) {
		logger.info("[log] execution bookstoreRepository.findAll()");
		Iterable<Bookstore> bookstores = bookstoreRepository.findAll();
		model.addAttribute("bookstores", bookstores);

		Iterable<Book> books = bookRepository.findAll();
		logger.info("[log] execution bookRepository.findAll()");
		model.addAttribute("books", books);

		return bookstores.toString();
	}

}
