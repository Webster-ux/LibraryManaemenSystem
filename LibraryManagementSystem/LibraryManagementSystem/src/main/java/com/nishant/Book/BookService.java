package com.nishant.Book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nishant.Student.Student;

@Service

public class BookService {
	
	private static List<Book>books= new ArrayList<>();
	private Student students;
	Student allstudents=students;
	
	static {
		
		books.add(new Book(101,"Java","abc","Xyz","3"));
		books.add(new Book(102,"Mysql","abc","Xyz","3"));
		books.add(new Book(103,"python","abc","Xyz","3"));
		books.add(new Book(104,"AWS","abc","Xyz","3"));
	}
	
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return books;
	}
	
	public void addNewbooks(int id,String title,String author,String publisher,String no_of_available) {
		Book book=new Book(id,title,author,publisher,no_of_available);
		books.add(book);
	}

	public List<Book> borrow() {
		// TODO Auto-generated method stub
		
		return null;
	}
}
