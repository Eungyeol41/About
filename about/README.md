# About demo Project 생성
### Swagger 연동
### Mybatis를 이용한 AWS RDS(MySQL) 연동
### 이메일 인증을 이용한 회원가입
### 외부로그인 연동
1. 카카오 로그인
2. 구글 로그인
3. 애플 로그인

<hr>

## dependency 추가
1. Mybatis
   - <i>org.mybatis.spring.boot > mybatis-spring-boot-starter</i>
2. MySQL
   - <i>com.mysql > mysql-connector-j</i>
3. Swagger-ui
   - <i>io.springfox > springfox-boot-starter</i>
   - <i>io.springfox > springfox-swagger-ui</i>

## Swagger 이용
1. SwaggerConfig.class 생성
2. Controller 에서 Swagger API 작성
3. 주소 뒤에 `/swagger-ui/` 붙이고 API 확인 가능