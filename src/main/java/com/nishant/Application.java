package com.nishant;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nishant.entity.Author;
import com.nishant.entity.Book;
import com.nishant.entity.Category;
import com.nishant.entity.Publisher;
import com.nishant.entity.Role;
import com.nishant.entity.User;
import com.nishant.repository.UserRepository;
import com.nishant.service.BookService;

@SpringBootApplication
public class Application {
	@Autowired
		private BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	private BookService bookService;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate() {
		return (args) -> {

			var book = new Book("123", "Spring core ", "abc78", "Book description");
			book.addAuthors(new Author("john", "dummy description"));
			book.addCategories(new Category("Dummy categary"));
			book.addPublishers(new Publisher("Dummy publisher"));
			bookService.createBook(book);

			var book1 = new Book("456", "Spring Microservices", "efg46", "Description1");
			book1.addAuthors(new Author("Max", "Test description1"));
			book1.addCategories(new Category("New category"));
			book1.addPublishers(new Publisher("publisher2"));
			bookService.createBook(book1);

			var book2 = new Book("789", "Spring Boot", "hij89", "description2");
			book2.addAuthors(new Author("Leo", "Test description2"));
			book2.addCategories(new Category("Spring category"));
			book2.addPublishers(new Publisher("publisher3"));
			bookService.createBook(book2);

			var user = new User("admin", "admin", "nishant@gmail.com", passwordEncoder.encode("nishant123"),
					Arrays.asList(new Role("ROLE_ADMIN")));
			userRepository.save(user);

		};
	}
}
