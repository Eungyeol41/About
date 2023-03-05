package com.silver.about.book.dao;

import com.silver.about.book.domain.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
	public List<BookVO> selectList(BookVO bookVO);
	public List<BookVO> selectContents(BookVO bookVO);
	public void insert(BookVO bookVO);
	public void update(BookVO bookVO);
	public void delete(BookVO bookVO);
}
