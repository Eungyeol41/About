package com.silver.about.user.dao;

import com.silver.about.user.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
	public List<UserVO> selectContents(UserVO userVO);
	public int login(UserVO userVO);
	public void join(UserVO userVO);
	public void update(UserVO userVO);
	public void delete(UserVO userVO);
}
