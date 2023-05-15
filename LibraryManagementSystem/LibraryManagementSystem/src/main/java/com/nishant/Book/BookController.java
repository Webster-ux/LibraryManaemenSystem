package com.nishant.Book;
/*package com.project.library.Library_Management.Book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.library.Library_Management.Student.StudentService;



//@Controller
public class BookController {
	

	public BookController(BookService bookservice,StudentService studentService) {
		super();
		this.bookservice = bookservice;
		
	}
	private BookService bookservice;
	
	@RequestMapping(value="/bookslist")
	public String allBooks(ModelMap model) {
		List<Book> allbooks= bookservice.allBooks();
		model.addAttribute("allbooks",allbooks);
		return "Books";
	}
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public String addNewBook(ModelMap model) {
		Book book=new Book(0, "","","","");
		model.put("book", book);
		return "addbook";
	}
	
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addStudent(ModelMap model,@Valid Book book,BindingResult result) {
		if(result.hasErrors()) {
			return "addbook";
		}
		
		bookservice.addNewbooks(book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getNo_of_available());
		List<Book> allbooks= bookservice.allBooks();
		model.addAttribute("allbooks",allbooks);
		return "Books";
	}
	
	@RequestMapping(value="/borrow")
	public String BooksBorrowed(ModelMap model,@Valid Book book,@Valid Student student) {
		
		
		return "Books";
	}
	
	
}
*/