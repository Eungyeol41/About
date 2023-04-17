# About demo Project 생성
- ### Swagger 연동
- ### Mybatis를 이용한 AWS RDS(MySQL) 연동
- ### 이메일 인증을 이용한 회원가입
- ### 외부로그인 연동
    - 카카오 로그인 / 구글 로그인 / 애플 로그인

## Spring Boot Project 생성하기
### Spring Boot 버전 : 3.0.5
### 기본 dependency
1. Spring Boot DevTools
2. Lombok
3. Spring Web
4. Spring Data MongoDB
5. Java Mail Sender
### dependency 추가
1. Swagger-ui
    - <i>io.springfox > springfox-boot-starter</i>
    - <i>io.springfox > springfox-swagger-ui</i>
2. Jasypt
    - <i>org.jasypt > jasypt</i>

## Swagger 이용
1. SwaggerConfig.class 생성
2. Controller 에서 Swagger API 작성
3. 주소 뒤에 `/swagger-ui/` 붙이고 API 확인 가능

## 회원가입 시 이메일 인증
1. EmailConfig.class 생성
2. `JavaMailSender`를 이용하여 이메일 보내기
3. 이메일에서 링크 클릭 시 바로 회원가입 적용
<hr style="margin-top: 2rem;">
<h2 align='center'>기술 스택</h2>
<h3 align='center'>개발</h3>
<p align='center'>
	<img src="https://img.shields.io/badge/Java 17-007396?style=flat-square&logo=Java&logoColor=white" />
	<img src="https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=Apache Maven&logoColor=white" />
	<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white" />
	<img src="https://img.shields.io/badge/Spring Boot 3.0.5-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white" />
	<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat-square&logo=IntelliJ IDEA&logoColor=white" />
</p>

<h3 align='center'>DB</h3>
<p align='center'>
	<img src="https://img.shields.io/badge/MongoDB-47A248?style=flat-square&logo=MongoDB&logoColor=white" />
</p>

<h3 align='center'>문서/협업</h3>
<p align='center'>
	<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=Swagger&logoColor=white" />
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white" />
	<img src="https://img.shields.io/badge/Notion-000000?style=flat-square&logo=Notion&logoColor=white" />
</p>