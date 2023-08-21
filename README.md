﻿# spring_prj


spring_prj/src/main/java/Domain/Food.java
#### int id;
PK를 위한 주문 번호 변수
#### String name;
음식의 이름을 입력하는 변수 입니다. ex) 피자, 햄버거
#### int price;
음식의 가격을 입력하는 변수 입니다. ex)10000

## 다음 길(요청)에 대해 직접 URL 짓기. a.k.a API 설계
환경 : postman
### 조회
- GET http://localhost:8080/api/v1/foods 음식 전체 조회
- GET http://localhost:8080/api/v1/foods/{id} 음식 단일 조회

### 수정
- PUT http://localhost:8080/api/v1/foods/{id} 음식 수정
- PATCH http://localhost:8080/api/v1/foods/{id} 음식 수정

### 삭제
- DELETE http://localhost:8080/api/v1/foods 음식 전체 삭제
- DELETE http://localhost:8080/api/v1/foods/{id} 음식 개별 삭제


### 등록
- POST http://localhost:8080/api/v1/foods 음식 등록 

## 음식 API 다이어그램

### 테이블 설계
  ![](https://velog.velcdn.com/images/cjllee/post/b3991cb8-b34d-4016-a1e7-4bac99d5daf1/image.png)

### 엔티티 설계
![](https://velog.velcdn.com/images/cjllee/post/a1307bcd-3d93-4c10-a96d-6b7cf31e3b53/image.png)


## Docker mariadb 사용
