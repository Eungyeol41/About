package com.silver.about.book;

import com.silver.about.book.dao.BookDao;
import com.silver.about.book.domain.BookVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

import java.awt.print.Book;
import java.util.List;

@RestController
@Tag(name = "Book API", description = "Book API")
public class BookController {

	// Log
	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookDao bookDao;

	@Operation(summary = "등록한 책 리스트 조회", description = "1. 등록한 책 리스트 조회", tags = "Book API", responses = {
			@ApiResponse(responseCode = "200", description = "책 리스트 조회 완료")
	})
	@GetMapping(value = "/book/list.do", produces = "application/json;charset=UTF-8")
	public List<BookVO> bookList(
			@Parameter(description = "사용자 ID") @RequestParam String userId,
			@Parameter(description = "완독 여부 (전체 : 0 / 완독 : 1 / 읽는 중 : 2)") @RequestParam String isCompleted,
			@Parameter(description = "좋아요 여부 (전체 : 0 / 좋아요 Y : 1 / 좋아요 N : 2 / 전체)") @RequestParam String isLikely,
			@Parameter(description = "정렬 조건 (등록순 : 0 / 최신순 : 1)") @RequestParam String schEtc00
	) {
		BookVO bookVO = new BookVO();
		bookVO.setUserId(userId);			// 사용자 ID 
		bookVO.setIsCompleted(isCompleted); // 완결 여부
		bookVO.setIsLikely(isLikely); 		// 좋아요 여부
		bookVO.setSchEtc00(schEtc00);		// 정렬 조건

		return bookDao.selectList(bookVO);
	}

	@Operation(summary = "책 상세 조회", description = "2. 책 상세 조회", tags = "Book API", responses = {
			@ApiResponse(responseCode = "200", description = "책 상세 조회 완료")
	})
	@GetMapping(value = "/book/detail/list.do", produces = "application/json;charset=UTF-8")
	public List<BookVO> detail(
			@Parameter(description = "사용자 ID") @RequestParam String userId,
			@Parameter(description = "책 일련번호") @RequestParam String seqNo
	) {
		BookVO bookVO = new BookVO();
		bookVO.setUserId(userId);	// 사용자 ID
		bookVO.setSeqNo(seqNo);		// 책 일련번호

		return bookDao.selectContents(bookVO);
	}

	// 책 등록
	@Operation(summary = "책 등록", description = "3. 책 등록", tags = "Book API", responses = {
			@ApiResponse(responseCode = "200", description = "책 등록 성공")
	})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "사용자 ID", required = true),
			@ApiImplicitParam(name = "title", value = "책 제목", required = true),
			@ApiImplicitParam(name = "author", value = "책 작가", required = false),
			@ApiImplicitParam(name = "genre", value = "책 장르", required = false),
			@ApiImplicitParam(name = "platform", value = "책 플랫폼", required = false),
			@ApiImplicitParam(name = "isCompleted", value = "완결 여부", required = true),
			@ApiImplicitParam(name = "readNum", value = "읽은 페이지 수", required = false),
			@ApiImplicitParam(name = "completedNum", value = "책 완결 페이지 수", required = false),
			@ApiImplicitParam(name = "memo", value = "메모", required = false)
	})
	@GetMapping(value = "/book/insert.do", produces = "application/json;charset=UTF-8")
	public void insert(
		  @RequestParam(value = "userId", required = true, defaultValue = "") String userId
		, @RequestParam(value = "title", required = true, defaultValue = "") String title
		, @RequestParam(value = "author", required = false, defaultValue = "") String author
		, @RequestParam(value = "genre", required = false, defaultValue = "") String genre
		, @RequestParam(value = "platform", required = false, defaultValue = "") String platform
		, @RequestParam(value = "isCompleted", required = true, defaultValue = "") String isCompleted
		, @RequestParam(value = "readNum", required = false, defaultValue = "") String readNum
		, @RequestParam(value = "completedNum", required = false, defaultValue = "") String completedNum
		, @RequestParam(value = "memo", required = false, defaultValue = "") String memo
	) {
		BookVO bookVO = new BookVO();
		bookVO.setUserId(userId);				// 사용자 ID
		bookVO.setTitle(title);					// 책 제목
		bookVO.setAuthor(author);				// 책 작가
		bookVO.setGenre(genre);					// 책 장르
		bookVO.setPlatform(platform);			// 책 플랫폼
		bookVO.setIsCompleted(isCompleted);		// 완결 여부
		bookVO.setReadNum(readNum);				// 읽은 페이지 수
		bookVO.setCompletedNum(completedNum);	// 책 완결 페이지 수
		bookVO.setMemo(memo);					// 메모

		bookDao.insertContents(bookVO);
	}

	// 책 수정
	@Operation(summary = "책 수정", description = "4. 책 수정", tags = "Book API", responses = {
			@ApiResponse(responseCode = "200", description = "책 수정 완료")
	})
	@GetMapping(value = "/book/update.do", produces = "application/json;charset=UTF-8")
	public void update(
			@Parameter(description = "책 일련번호") @RequestParam String seqNo
	) {
		BookVO bookVO = new BookVO();
		bookVO.setSeqNo(seqNo);

		bookDao.updateContents(bookVO);
	}

	// 책 삭제
	@Operation(summary = "책 삭제", description = "5. 책 삭제", tags = "Book API", responses = {
			@ApiResponse(responseCode = "200", description = "책 삭제 완료")
	})
	@GetMapping(value = "/book/delete.do", produces = "application/json;charset=UTF-8")
	public void delete(
			@Parameter(description = "책 일련번호") @RequestParam String seqNo
	) {
		BookVO bookVO = new BookVO();
		bookVO.setSeqNo(seqNo);

		bookDao.deleteContents(bookVO);
	}

}
