package com.nishant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
