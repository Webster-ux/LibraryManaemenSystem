package com.nishant.Book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nishant.Student.Student;
import com.nishant.Student.StudentRepository;




@Controller
public class BookControllerJpa {
	

	public BookControllerJpa(BookRepository bookrepo,StudentRepository studentrepo) {
		super();
		
		this.bookrepo=bookrepo;
		this.studentrepo=studentrepo;
	}
	private BookRepository bookrepo;
	private StudentRepository studentrepo;
	
	
	@RequestMapping(value="/bookslist")
	public String allBooks(ModelMap model) {
		List<Book> allbooks=bookrepo.findAll();
		
		model.addAttribute("allbooks",allbooks);
		return "Books";
	}
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public String addNewBook(ModelMap model) {
		Book book=new Book(0,"","","","");
		model.put("book", book);
		return "addbook";
	}
	
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addStudent(ModelMap model,@Valid Book book,BindingResult result) {
		if(result.hasErrors()) {
			return "addbook";
		}
		bookrepo.save(book);
		/*bookservice.addNewbooks(book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getNo_of_available());*/
		List<Book> allbooks=bookrepo.findAll();
		model.addAttribute("allbooks",allbooks);
		return "Books";
	}

	
	
	
	@RequestMapping("delete-book")
	public String deleteBook(ModelMap model,@RequestParam int id) {
		bookrepo.deleteById(id);
		List<Book> allbooks=bookrepo.findAll();
		model.addAttribute("allbooks",allbooks);
	
		return "Books";
	}
	
	
	

	@RequestMapping(value="/update-book",method=RequestMethod.GET)
	public String showUpdateBookPage(ModelMap model,@RequestParam int id) {
		Book book=bookrepo.findById(id);
	
		model.addAttribute("book",book);
	
		return "addbook";
	}
	@RequestMapping(value="/update-book",method=RequestMethod.POST)
	public String updatingBook(ModelMap model,@Valid Book book,BindingResult result) {
		if(result.hasErrors()) {
			return "addbook";
		}
		bookrepo.deleteById(book.getBook_id());
		bookrepo.save(book);
		/*bookservice.addNewbooks(book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getNo_of_available());*/
		List<Book> allbooks=bookrepo.findAll();
		model.addAttribute("allbooks",allbooks);
		return "Books";
	}

	
	
	//Adding book to individual Student
	
	@RequestMapping(value="/addBookToStudent",method=RequestMethod.GET)
	public String addBookToStudent(ModelMap model,@RequestParam int id) {
		Student student = studentrepo.findById(id);

	   
	    List<Book> books = bookrepo.findAll();

	    
	    model.addAttribute("student", student);
	    model.addAttribute("books", books);

		return "addBookToStudent";
	}
	@PostMapping("/addBookToStudent")
	public String addBookToStudent(ModelMap model,@RequestParam int bookId, @RequestParam int studentId) {
	    Student student = studentrepo.findById(studentId);
	    Book book = bookrepo.findById(bookId);

	    // Add the book to the student's list of books
	   student.getBooks().add(book);
	    studentrepo.save(student);
	    int student_id=student.getId();
	    List<Book> books=student.getBooks();
	    model.addAttribute("student_id",student_id);
	    model.addAttribute("books",books);
	    

	    return "bookstakenbystudent";
	    
	}
	
/*	@GetMapping("/bookstakenbystudent")
	public String getBooksTakenByStudent(ModelMap model,@RequestParam int book_id, @RequestParam int studentId) {
	    Student student = studentrepo.findById(studentId);
	    Book book = bookrepo.findById(book_id);

	    // Add the book to the student's list of books
	   student.getBooks().add(book);
	    studentrepo.save(student);
	    int student_id=student.getId();
	    List<Book> books=student.getBooks();
	    model.addAttribute("student_id",student_id);
	    model.addAttribute("books",books);
	    

	    return "addBookToStudent";
	    
	}*/
	
	@GetMapping("/bookstakenbystudent")
    public String getBooksTakenByStudent(ModelMap model,@RequestParam int id) {
        List<Book> books = bookrepo.findByStudentsId(id);
        int student_id=id;
        

		model.addAttribute("student_id",student_id);
        model.addAttribute("books",books);
        
        return "bookstakenbystudent";
    }

	@RequestMapping("return")
	public String Return(ModelMap model,@RequestParam int id) {
		 
		

		return "bookstakenbystudent";
	}
	

	
	
	

	
	

}
