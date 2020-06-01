package com.pawan.boot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.boot.dto.BookDTO;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Integer> {

}
