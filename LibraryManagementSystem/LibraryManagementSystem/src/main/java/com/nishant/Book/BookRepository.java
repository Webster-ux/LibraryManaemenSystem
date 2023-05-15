package com.nishant.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository 
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByStudentsId(int studentId);

	 Book findById(int id);

}
