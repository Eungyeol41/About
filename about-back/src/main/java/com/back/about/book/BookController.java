package com.back.about.book;

import com.back.about.book.domain.BookVO;
import com.back.about.common.service.SeqGeneratorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@Resource(name = "SeqGeneratorService")
	private SeqGeneratorService seqGeneratorService;

	private final static String folder_path = "/book/";


	// id에 해당하는 LIST 전체 조회
	@RequestMapping(value = folder_path + "selectList.do")
	public String selectList() {

		return "";
	}

	// id에 해당하는 LIST 중 해당 내역 조회
	@RequestMapping(value = folder_path + "selectContents.do")
	public String selectContents() {

		return "";
	}

	// 책 insert
	@RequestMapping(value = folder_path + "insert.do")
	public String insert() {
		BookVO bookVO = new BookVO();
		bookVO.setSeqNo(seqGeneratorService.generatorSeq(BookVO.SEQUENCE_NAME));

		// t_book_seq에 seq 등록

		// t_book에 builder를 사용하여 table에 insert

		return "";
	}

}
