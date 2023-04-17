package com.back.about.book.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 일련번호를 관리하는 VO
 */
@Getter
@Setter
@Document("t_book_seq")
public class BookSeq {

	private String _id;
	private int seqNo;

}
