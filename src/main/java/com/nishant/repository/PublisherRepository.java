package com.nishant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
