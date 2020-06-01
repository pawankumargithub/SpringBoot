package com.pawan.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.boot.dto.BookDTO;
import com.pawan.boot.repository.BookRepository;
import com.pawan.boot.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository repository;

	@Override
	public BookDTO saveBook(BookDTO book) {

		System.out.println(book);
		return repository.save(book);
	}

	@Override
	
	public List<BookDTO> findAllBooks() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public BookDTO findOneBookById(Integer bookId) {

		return repository.findById(bookId).get();
	}

	@Override
	public void deleteOneBookById(Integer bookId) {

		repository.deleteById(bookId);

	}

	@Override
	public boolean isBookExist(Integer bookId) {

		return repository.existsById(bookId);
	}

	@Override
	public void deleteAllBooks() {
		repository.deleteAll();

	}

}
