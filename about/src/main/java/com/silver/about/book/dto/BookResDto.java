package com.silver.about.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResDto {
	@Schema(name = "seqNo", example = "1", description = "일련번호")
	private String seqNo;
	@Schema(name = "frstDt", example = "2023-02-19", description = "책 등록일자")
	private String frstDt;
	@Schema(name = "lstDt", example = "2023-02-19", description = "책 수정일자")
	private String lstDt;
	@Schema(name = "userId", example = "test", description = "책 등록자")
	private String userId;
	@Schema(name = "title", example = "내가 키운 S급들", description = "책 제목")
	private String title;
	@Schema(name = "author", example = "근서", description = "작가")
	private String author;
	@Schema(name = "genre", example = "판타지", description = "책 장르")
	private String genre;
	@Schema(name = "platform", example = "리디", description = "책 플랫폼")
	private String platform;
	@Schema(name = "isCompleted", example = "Y", description = "책 완결여부")
	private String isCompleted;
	@Schema(name = "isLikely", example = "N", description = "책 좋아요 여부")
	private String isLikely;
	@Schema(name = "readNum", example = "720", description = "읽은 페이지")
	private String readNum;
	@Schema(name = "completedNum", example = "720", description = "완결 페이지")
	private String completedNum;
	@Schema(name = "memo", example = "memo_test", description = "메모")
	private String memo;
}
