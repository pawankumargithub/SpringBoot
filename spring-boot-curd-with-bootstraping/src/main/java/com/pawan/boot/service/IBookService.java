package com.pawan.boot.service;


import java.util.List;

import com.pawan.boot.dto.BookDTO;

public interface IBookService {

	BookDTO saveBook(BookDTO book);

	List<BookDTO> findAllBooks();

	BookDTO findOneBookById(Integer bookId);

	void deleteOneBookById(Integer bookId);

	boolean isBookExist(Integer bookId);

	void deleteAllBooks();
}
