package com.silver.about.book.domain;

import com.silver.about.common.domain.CommonVO;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("bookVO")
public class BookVO extends CommonVO {
	
	// 일련번호
	private String seqNo;
	// 책 등록일자
	private String frstDt;
	// 책 수정일자
	private String lstDt;
	// 책 등록자
	private String userId;
	// 책 제목
	private String title;
	// 작가
	private String author;
	// 책 장르
	private String genre;
	// 책 플랫폼
	private String platform;
	// 책 완결여부
	private String isCompleted;
	// 책 좋아요 여부
	private String isLikely;
	// 읽은 페이지
	private String readNum;
	// 완결 페이지
	private String completedNum;
	// 메모
	private String memo;
	// 책 읽은 비율
	private String readingRate;
}
