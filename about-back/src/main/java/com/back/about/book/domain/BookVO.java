package com.back.about.book.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("t_book")
public class BookVO {

	@Transient
	public static final String SEQUENCE_NAME = "t_board_seq";

	private String _id;
	private int seqNo;
	private String frstId;
	private String frstDt;
	private String lstId;
	private String lstDt;
	private String useYn;
	
	// Builder 추가
}
