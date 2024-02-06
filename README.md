### Java를 통한 JDBC 사용해보기

---

#### 개발환경

- Java8
- MAC
- IntelliJ IDEA
- MariaDB jdbc Driver : 3.3.2-GA 

  - 구글에 mariadb jdbc driver 검색 > 다운로드

---

#### JDBC 드라이버 인텔리제이에 넣는 방법

1. 다운로드 받은 jdbc 드라이버를 프로젝트내에 lib 폴더 생성하여 안에 넣는다.
2. 인텔리제이 상단 file > project structure > library 클릭
3. '+' 클릭 후 lib 내에 jdbc 클릭

** [참고] jdbc를 lib에 넣지 말고 프로젝트 위부에 빼놓아도 프로젝트 구조 > 라이브러리에 추가해도 될 거 같다!

---

JDBC 순서
1. Class.forName으로 jdbc 드라이버 로드
2. DB Connection 생성 
3. SQL Statement 객체 생성
4. SQL 문장 실행
5. 결과 처리
6. JDBC 연결 해제

---
예시 sql table

```
create table member
(
member_type varchar(50)  not null comment 'type',
user_id     varchar(100) not null comment '사용자 ID',
password    varchar(100) not null comment '비밀번호',
name        varchar(100) not null comment '이름'
)
comment '유저 정보';
```

```mariadb
insert into member (member_type, user_id, password, name)
values  ('email', 'kwon@gmail.com', '7777', '원균'),
        ('email', 'kwon@daum.net', '1592', '이순신'),
        ('email', 'test@naver.com', '1234', '박규태'),
        ('kakao', 'syryu@nate.com', '', '류성용'),
        ('kakao', 'test@naver.com', '', '박규태'),
        ('email', 'kyc@naver.com', '9999', '김예짱');
```
