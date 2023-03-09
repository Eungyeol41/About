package com.silver.about.common.service;

public interface EmailService {
	void sendSimpleMessage(String to, String id, String userNm, String pw, String email) throws Exception;

}
