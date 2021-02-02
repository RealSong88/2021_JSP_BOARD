### 최종배포 주소

[jsp 게시판] <http://bellsky.ga/BBS/>
---


### 2021-01-30 작업

- 로그인 페이지
- 회원데이터베이스 구축
- 로그인 기능 구현

### 2021-02-01 작업

- 회원가입 기능 구현
- 접속한 회원 세션 관리
- 게시판 데이터베이스 구축
- 글쓰기 기능 구현
- 게시판 글 목록 기능 구현
- 게시글 보기 구현
- 게시글 수정 및 삭제 기능 구현
- custom.css, 메인 이미지 추가
- 클라우드에 배포, mariaDB 연결
---


### 마리아디비 & mysql 대소문자 구별시


>윈도우에서는 대부분 대소문자 구분없이 설치가 되지만, 간혹가다가 리눅스용 MySQL은 대소문자 구분하는 형식으로 설치가 되있는 경우가 있다. 
다음과 같은 명령을 실행하고 확인 하였을 경우 lower_case_table_names의 값이 0인지 1인지 2인지를 확인해야 한다.
본인의 테스트 서버는 0이어서 오류가 났었던 것이다.
보통 2는본적이 없어서 모르겠고 0 또는 1인것을 보았었다.
- 0일 경우 : 대소문자 구분함
- 1일 경우 : 대소문자 구분안함
>본인은 대소문자 구분을 하지 않기위하여  lower_case_table_names의 값을 1로 설정을 해주고자 한다.
MySQL의 my.cnf 파일을 건드려 주어야 하는데 보통은 /etc/my.cnf에 존재한다. 영역의 맨밑에
`lower_case_table_names = 1`
라고 설정을 한다.

### JSP 게시판 만들기 강좌(동빈나님)를 바탕으로 만든 게시판입니다.
