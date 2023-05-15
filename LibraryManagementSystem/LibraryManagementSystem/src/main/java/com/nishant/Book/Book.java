package com.nishant.Book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.nishant.Student.Student;

@Entity
public class Book {
	public Book() {
		
	}

	@Id
	private int book_id;
    private String title;
    private String author;
    private String publisher;
    private String no_of_available;
    
    @ManyToMany
    @JoinTable(
            name = "books_taken",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();
    


	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Book(int book_id, String title, String author, String publisher, String no_of_available) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.no_of_available = no_of_available;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getNo_of_available() {
		return no_of_available;
	}
	public void setNo_of_available(String no_of_available) {
		this.no_of_available = no_of_available;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", no_of_available=" + no_of_available + "]";
	}
    
}
