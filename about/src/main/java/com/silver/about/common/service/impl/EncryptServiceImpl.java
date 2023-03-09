package com.silver.about.common.service.impl;

import com.silver.about.common.service.EncryptService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImpl implements EncryptService {

	@Override
	public String encrypt(String encString) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPassword("EncPassword");
		encryptor.setSaltGenerator(new StringFixedSaltGenerator("someFixedSalt"));

		return encryptor.encrypt(encString);
	}

	@Override
	public String decrypt(String decString) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPassword("EncPassword");
		encryptor.setSaltGenerator(new StringFixedSaltGenerator("someFixedSalt"));

		return encryptor.decrypt(decString);
	}

}
