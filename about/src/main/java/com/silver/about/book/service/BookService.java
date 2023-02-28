package com.silver.about.book.service;

import com.silver.about.book.BookController;
import com.silver.about.book.dao.BookDao;
import com.silver.about.book.domain.BookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	private final BookDao bookDao;

	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookVO> selectAll(BookVO bookVO) {
		List<BookVO> resultList = bookDao.selectList(bookVO);

		logger.info(">> selectAll() >> " + resultList.toString());

		return resultList;
	}
}
