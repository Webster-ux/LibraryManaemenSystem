package com.nishant.Student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.nishant.Book.Book;

@Entity(name="Students")
public class Student {
	
	public Student() {
		
	}
	@Id
	private int id;
	private String name;
	private String course;
	private String branch;
	@ManyToMany
	@JoinTable(
	        name = "student_book",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "book_id")
	    )
	private List<Book>books=new ArrayList<>();
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Student(int id, String name, String course, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.branch = branch;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", branch=" + branch + "]";
	}

	

	
	
}
