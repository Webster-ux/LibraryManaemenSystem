package com.nishant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
