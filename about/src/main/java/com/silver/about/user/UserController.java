package com.silver.about.user;

import com.silver.about.user.dao.UserDao;
import com.silver.about.user.domain.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "User API", description = "User API")
public class UserController {

	// Log
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;

	// ID 중복검사
	@Operation(summary = "ID 중복검사", description = "2. ID 중복검사", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "성공")
	})
	@GetMapping(value = "/user/idDblChk.do", produces = "application/json;charset=UTF-8")
	public int idDblChk(
			@Parameter(description = "사용자 ID") @RequestParam String id
	) {
		UserVO userVO = new UserVO();
		userVO.setId(id);

		return userDao.login(userVO);
	}
	
	// 이메일 인증

	@Operation(summary = "회원가입", description = "1. 회원가입", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "회원가입 완료")
	})
	@GetMapping(value = "/user/join.do", produces = "application/json;charset=UTF-8")
	public void join(
			  @Parameter(description = "사용자 ID") @RequestParam String id
			, @Parameter(description = "사용자 이름") @RequestParam String userNm
			, @Parameter(description = "사용자 비밀번호") @RequestParam String pw
			, @Parameter(description = "사용자 이메일") @RequestParam String email
	) {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setUserNm(userNm);
		userVO.setPw(pw); // TODO 암호화 처리 필요
		userVO.setEmail(email);

		userDao.join(userVO);
	}
	
	/*@Operation(summary = "", description = "", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "성공")
	})
	@GetMapping(value = "/.do", produces = "application/json;charset=UTF-8")
	public void dd(
			@Parameter(description = "") @RequestParam String id
	) {
		UserVO userVO = new UserVO();

		return userDao.login(userVO);
	}*/
	// 외부로그인(카카오)
	// 외부로그인(구글)
	// 외부로그인(애플)
	
	@Operation(summary = "회원 정보 조회", description = "3. 회원 정보 조회", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "회원 정보 조회 성공")
	})
	@GetMapping(value = "/user/list.do", produces = "application/json;charset=UTF-8")
	public List<UserVO> selectUser(
			  @Parameter(description = "사용자 ID") @RequestParam String id
			, @Parameter(description = "사용자 비밀번호") @RequestParam String pw
	) {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPw(pw); // TODO 암호화 처리 필요

		return userDao.selectContents(userVO);
	}

	// 로그인
	@Operation(summary = "로그인", description = "4. 로그인", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "성공")
	})
	@GetMapping(value = "/user/login.do", produces = "application/json;charset=UTF-8")
	public int login(
			  @Parameter(description = "사용자 ID") @RequestParam String id
			, @Parameter(description = "사용자 비밀번호") @RequestParam String pw
	) {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPw(pw); // TODO 암호화 처리 필요

		userVO.setSchEtc00("login");

		return userDao.login(userVO);
	}
	
	// 회원 탈퇴
	@Operation(summary = "회원 탈퇴", description = "6. 회원 탈퇴", tags = "User API", responses = {
			@ApiResponse(responseCode = "200", description = "성공")
	})
	@GetMapping(value = "/user/delete.do", produces = "application/json;charset=UTF-8")
	public void delete(
			@Parameter(description = "사용자 ID") @RequestParam String id
	) {
		UserVO userVO = new UserVO();
		userVO.setId(id);

		userDao.delete(userVO);
	}

}
