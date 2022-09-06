# dz_2209
더존 3기 2팀 미니프로젝트

# 개요
- 컨텐츠 : 
- 출력화면 : 콘솔

# BookDAO
**컬럼종류 및 변수 타입**
- isbn(국제표준도서번호) : int
- genre(책 장르) : String
- bname(책이름) : String
- wirter(저자) : String
- prent(person_rent 대여한 사람 수) : int
- clearNum()  : int
- originPrice(책의 실제 가격) : int 
- summary(줄거리) : String 
<br> 

**insertBook()**
- 변수: isbn, genre, bname, writer, prent, clearNum, originPrice, summary
- 기능: Book 전체 데이터 추가
<br> 

**updatePrent()**
- 변수 : prent, isbn
- 기능 : isbn 번호로 prent 카운트 조정?
<br>

**updateclearNum()**
- 변수 : clearNum, Isbn
- 기능 : isbn 번호로 ClearNum 조정
<br> 

**deleteBook()**
- 변수 : isbn
- 기능 : isbn 번호로 book 데이터 삭제 
<br> 

**selectBook()**
- 변수 : genre, bname, writer, prent, clearNum, originPrice, summary, image
- 기능 : isbn으로 book 데이터 조회
<br> 

**ArrayList<Book> recommendBook()**
- 변수 : bname, writer, originPrice, summary
- 기능 : genre로 book의 데이터 조회
- 특징 : ArrayList<Book> 활용
<br> 

**ArrayList<Book> selectAllBook()**
- 변수 : isbn, genre, bname, writer, prent, clearNum, originPrice, summary
- 기능 : 전체 book 테이블 조회
- 특징 : ArrayList<Book> 활용
<br> 

**selectDuplicatedIsbn()**
- 변수 : isbn
- 기능 : isbn로 book의 전체 건수를 조회
- 특징 : count(*)를 통해 조회된 전체 행 건수를 반환
<br>
<br>  

# ConnectionHelper
**연결 및 CLOSE 함수**
- Connection getConnection() : DB연결
- close(Connection conn) : Connection close
- close(Statement stmt) : Statement close
- close(ResultSet rs) : ResultSet close
<br>  
<br>

# HISTORYDAO
**컬럼종류 및 변수 타입**
- id(사용자 아이디) : String
- isbn(국제표준도서번호) : int
- price(도서공유프로그램에서의 가격) : int 
- clear()  : int
<br>

**ArrayList<History> selectHistory**
- 변수 : id, isbn, price, clear
- 기능 : id로 history의 데이터 조회
- 특징 : ArrayList<History> 활용
<br> 

**ArrayList<History> selectAllHistory**
- 변수 : id, isbn, price, clear
- 기능 : history의 전체 데이터 조회
- 특징 : ArrayList<History> 활용
<br> 

**insertHistory()**
- 변수 : id, isbn, price, clear
- 기능 : history의 데이터 삽입
<br>

**updateHistory()**
- 변수 : id, isbn, price, clear
- 기능 : id와 isbn 으로 데이터 수정
- 특징 : where id and isbn
<br>

**countClear()**
- 변수 : id
- 기능 : id로 history의 전체 건수를 조회
- 특징 : count(*)를 통해 조회된 전체 행 건수를 반환
<br>
<br> 

# MemberDAO
**컬럼종류 및 변수 타입**
- id(사용자의 아이디) : String
- pass(사용자의 비밀번호) : String
- ename(사용자의 이름) : String
- email(사용자의 이메일) : String
- genre(책의 장르) : String
- egrade(사용자의 등급) : int
- point(사용자의 포인트) : int
- cash(사용자의 캐쉬) : int
<br>
-checkstr(@ 문자열 포함 여부 확인): String
<br>

**loginCheck()**
- 변수 : id, pass
- 기능 : id와 isbn 으로 데이터 수정
- 특징1 : count(*)를 통해 조회된 전체 행 건수를 반환
- 특징2 : where id and pass
<br> 

**insertJoin()**
- 변수 : id,pass,ename,email,genre
- 기능 : member에 데이터 삽입
<br>

**findIdPass()**
- 변수 : id, pass, email
- 기능 : email로 사용자의 id, pass 찾기
<br>

**selectMypage()**
- 변수 : id, ename, egrade, point,cash
- 기능 : id로 사용자의 마이페이지 데이터 조회
<br>

**selectGenre()**
- 변수 : id, gerne
- 기능 : id로 사용자의 장르 데이터 조회
<br>

**selectMemberInfo()**
- 변수 : id, ename, email,genre
- 기능 : id로 사용자의 데이터 조회
<br>

**ArrayList<Member> selectMember()**
- 변수 : id, ename, email,genre
- 기능 : id로 사용자의 데이터 조회
- 특징 : ArrayList<Member> 활용
<br>

**ArrayList<Member> selectAllMember()**
- 변수 : id, ename, email,genre
- 기능 : 전체 member 데이터 조회
- 특징 : ArrayList<Member> 활용
<br> 

**updateMemberInfo()**
- 변수 : id, pass
- 기능 : id로 pass 수정
<br>

**dupliCheck()**
- 변수 : id, email
- 기능 : @이 있으면 email의 건수 확인 없으면 id의 건수 확인
- 특징1 : count(*)를 통해 조회된 전체 행 건수를 반환
- 특징2 : checkStr.contains("@") 즉 "@" 문자열 확인
<br>

**updateGenre()**
- 변수 : id, gerne
- 기능 : id로 사용자의 genre 데이터 수정
<br>

**updateCashCharge()**
- 변수 : id, cash
- 기능 : id로 사용자의 cash 데이터 수정
- 특징 : cash = cash+
<br>

**updateAfterPay()**
- 변수 : id, cash
- 기능 : id로 사용자의 cash 데이터 수정
- 특징 : cash = cash-
<br>

**selectGrade()**
- 변수 : id, egrade
- 기능 : id로 사용자의 egrade 데이터 조회
<br>

**updateGrade()**
- 변수 : id, egrade
- 기능 : id로 사용자의 egrade 데이터 수정
<br>

