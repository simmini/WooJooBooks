<h1>📢 WooJooBooks: Springboot를 이용한 중고거래 사이트</h1>

<h1>🙋‍♂️ Spring을 함께 공부하고자 모인 사람들</h1>
<a href="https://github.com/simmini">simmini님</a> <br/>
<a href="https://github.com/Lee-S-June">Lee-S-June님</a><br/>
<a href="https://github.com/qdt6028">qdt6028님</a><br/> 
<a href="https://github.com/serena-0323">serena-0323님</a><br/> 
<a href="https://github.com/Amuk97">Amuk97님</a><br/> 


<h1>🎯 프로젝트 개발 동기 및 목표</h1>
우주책방의 의미는  ‘우리 주변의 책방’ 입니다.
최초 기획 의도는 지도API를 활용한 사용자의 위치를 기반으로 한 중고책 거래였습니다.
스프링 부트, JPA, Security, 등이 기술스택들을 이론적으로 학습한 뒤에 이를 기반으로 한 간단한 중고거래
 쇼핑몰 프로젝트를 구현해 보았고 완성하는 것에 초점을 두기 보다는 사용하는 기술들의 원리에 대해 
이해하는 것에 중점을 두었고 프론트보다는 ‘구현 가능한’ 백엔드에 집중하였습니다.


<h1>⚙️ 프로젝트 개발 환경</h1>
  <ol>
  <li>운영체제 : Window10</li>
  <li>통합개발환경(IDE) : IntelliJ</li>
  <li>JDK 버전 : JDK 11</li>
  <li>스프링 부트 버전 : 2.7.6 </li>
  <li>데이터 베이스 : MySQL</li>
  <li>빌드 툴 : gradle</li>
  <li>관리 툴 : Git, GitHub</li>
 </ol>
 
 
<h1>⚒️ 프로젝트 기술 스택</h1>
<ul>
  <li>프론트엔드</li>
- HTML, CSS, JS, BootStrap, Thymeleaf, JQuery
<li>백엔드</li>
- Spring Boot, Spring Security, Spring Data JPA, ApacheTomcat(9.0)
<li>데이터베이스</li>
- Hibernate, MySQL
<li>기타</li>
-ERDCloud,Flgma
 </ul>

<h1>📜 프로젝트 구현 기능</h1>
<ul>
<li>회원 (Member)<br/></li>
회원가입/ 카카오 연동/ 로그인 및 로그아웃/ 회원정보 수정 / 회원 정보 보기/ 회원탈퇴<br/><br/>

<li>상품 (Item)<br/></li>
상품 등록 / 상품 관리 / 상품 수정 / 상품 조회 (메인화면) / 상품 상세 페이지<br/><br/>

<li>공지(Board)<br/></li>
공지 등록 / 공지 수정 / 공지 삭제/ 공지 조회<br/><br/>
</ul>

<h1>📂 프로젝트 DB 모델링</h1>
<img src="https://user-images.githubusercontent.com/77092838/210767816-57592500-a19d-44be-93ef-20fefb309e2d.png"/>
![DB모델링1](https://user-images.githubusercontent.com/77092838/210767996-e37dfcca-c304-4bb8-9777-15adedbd1a03.png)

<br/>
member : 회원정보 테이블</br>
sellBoard : 판매게시판 테이블</br>
sellBoardImg : 판매게시판용 이미지파일 테이블</br>
Board : 공지게시판 테이블</br>
BoardImg : 공지게시판용 파일 테이블</br>


<h1>📜 프로젝트 API 명세서</h1>

![DBAPI설계](https://user-images.githubusercontent.com/77092838/210763757-105df151-104a-403f-a0dc-c1c7fe4c561d.png)


<h1>🎯 구현 결과</h1>
<ol>
 <li>회원</li>
 회원가입<br/>
 카카오연동</br>
 로그인<br/>
 회원정보수정</br>
 회원탈퇴</br>
 

 <li>메인 페이지(홈)</li>
 ![메인페이지](https://user-images.githubusercontent.com/77092838/210767782-43c9be5f-ff90-403b-8ade-22383a69cb60.png)

 도서 리스트 보기<br/>
 도서 업로드<br/>
 도서 상세페이지 보기<br/>
 도서 수정</br>
 도서 삭제</br>
 
 <li>마이 페이지</li>
 <!--좋아요 내역, 판매/구매 내역<br/>-->
 내 정보 보기<br/>
 
 <li>공지 페이지</li>
 공지 게시글 보기<br/>
 공지 업로드<br/>
 공지 수정<br/>
 공지 삭제<br/>
</ol>
