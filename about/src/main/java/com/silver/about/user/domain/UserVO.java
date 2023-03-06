package com.silver.about.user.domain;

import com.silver.about.common.domain.CommonVO;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("userVO")
public class UserVO extends CommonVO {

	// 일련번호
	private String seqNo;
	// 등록일자
	private String frstDt;
	// 수정일자
	private String lstDt;
	// 사용자 ID
	private String id;
	// 사용자 닉네임
	private String userNm;
	// 사용자 비밀번호
	private String pw;
	// 사용자 이메일
	private String email;

	/* E-mail 인증 */
	// 이메일 주소
	private String address;
	// 이메일 제목
	private String title;
	// 이메일 내용
	private String content;
}
