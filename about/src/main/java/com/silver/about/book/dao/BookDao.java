package com.silver.about.book.dao;

import com.silver.about.book.domain.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
	public List<BookVO> selectList(BookVO bookVO);
	public List<BookVO> selectContents(BookVO bookVO);
	public void insertContents(BookVO bookVO);
	public void updateContents(BookVO bookVO);
	public void deleteContents(BookVO bookVO);
}
