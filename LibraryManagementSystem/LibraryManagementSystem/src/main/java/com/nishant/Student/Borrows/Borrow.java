package com.nishant.Student.Borrows;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Borrow {
	
	private String id;
	private String student_id;
	private String book_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate borrowed_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate returned_date;
	public Borrow(String id, String student_id, String book_id, LocalDate borrowed_date, LocalDate returned_date) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.book_id = book_id;
		this.borrowed_date = borrowed_date;
		this.returned_date = returned_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public LocalDate getBorrowed_date() {
		return borrowed_date;
	}
	public void setBorrowed_date(LocalDate borrowed_date) {
		this.borrowed_date = borrowed_date;
	}
	public LocalDate getReturned_date() {
		return returned_date;
	}
	public void setReturned_date(LocalDate returned_date) {
		this.returned_date = returned_date;
	}
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", student_id=" + student_id + ", book_id=" + book_id + ", borrowed_date="
				+ borrowed_date + ", returned_date=" + returned_date + "]";
	}

}
