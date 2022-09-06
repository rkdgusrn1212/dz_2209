# dz_2209
더존 3기 2팀 미니프로젝트

# 개요
- 컨텐츠 : 
- 출력화면 : 콘솔

# BookDAO
**컬럼종류 및 변수 타입**
- isbn(국제표준도서번호) : int
- genre(장르) : String
- bname(책이름) : String
- wirter(저자) : String
- prent(person_rent 대여한 사람 수) : int
- clearnum()  : int
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


