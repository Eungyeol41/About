package com.silver.about.common.service.impl;

import com.silver.about.common.service.EmailService;
import com.silver.about.common.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender javaMailSender;

	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Autowired
	private EncryptService encryptService;

	private MimeMessage createMessage(String to, String encUrl) throws Exception {
		MimeMessage message = javaMailSender.createMimeMessage();

		message.addRecipients(Message.RecipientType.TO, to); // 보내는 대상
		message.setSubject("이메일 인증"); // 제목

		String msg = "";
		msg += "<div style='margin:20px;'>";
		msg += "<h1> 안녕하세요 About 입니다. </h1>";
		msg += "<br>";
		msg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		msg += "<h3 style='color:blue;'>회원가입 인증 링크를 클릭해주세요.</h3>";
		msg += "<div style='font-size:130%'>";
		msg += "<a href=" + encUrl + ">인증 링크를 클릭해주세요.</a>";
		msg += "</div>";
		message.setText(msg, "utf-8", "html"); // 내용
		message.setFrom(new InternetAddress("","어플 About")); // 보내는 사람

		return message;
	}

	@Override
	public void sendSimpleMessage(String to, String id, String userNm, String pw, String email) throws Exception {
		String encUrl = emailEncrypt(id, userNm, pw, email);

		MimeMessage message = createMessage(to, encUrl);

		try { // 예외처리
			javaMailSender.send(message);
		} catch(MailException es) {
			es.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	private String emailEncrypt(String id, String userNm, String pw, String email) {
		String encId = encryptService.encrypt(id);
		String encUserNm = encryptService.encrypt(userNm);
		String encPw = encryptService.encrypt(pw);
		String encEmail = encryptService.encrypt(email);

		String encUrl = "http://localhost:8090/user/join.do?schEtc00=Y&id=" + encId + "&userNm=" + encUserNm + "&pw=" + encPw + "&email=" + encEmail;

		return encUrl;
	}

}
