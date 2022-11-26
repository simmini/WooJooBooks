<h1>📢 WooJooBooks: Springboot를 이용한 중고거래 사이트</h1>
로고사진


<h1>🙋‍♂️ Spring을 함께 공부하고자 모인 사람들</h1>
<a href="https://github.com/simmini">simmini님</a> <br/>
<a href="https://github.com/Lee-S-June">Lee-S-June님</a>
<a href=""></a><br/>

<h1>🎯 프로젝트 개발 동기 및 목표</h1>
스프링, 스프링 부트, JPA, 시큐리티 등의 기술스택들을 이론적으로 학습한 뒤에 실제로 어떻게 동작하는지 이해하기 위해서 간단한 쇼핑몰 프로젝트를 구현해봄. 흔한 쇼핑몰 프로젝트일지라도 완성하는 것에 초점을 두지 않고, 사용되는 기술에 대한 정확한 개념 및 사용법, 그리고 동작원리에 대해서 초점을 맞추었고, 또한 개발 과정에서 맞이하는 에러 및 궁금증들을 자세하게 찾아보고 정리하면서 전체적인 흐름 파악을 목표로 두었으며 프론트보다는 백엔드에 좀 더 집중하였음.


<h1>⚙️ 프로젝트 개발 환경</h1>
  <ol>
  <li>운영체제 : Window10</li>
  <li>통합개발환경(IDE) : IntelliJ</li>
  <li>JDK 버전 : JDK 11</li>
  <li>스프링 부트 버전 : </li>
  <li>데이터 베이스 : MySQL</li>
  <li>빌드 툴 : Maven</li>
  <li>관리 툴 : Git, GitHub</li>
 </ol>
 
 
<h1>⚒️ 프로젝트 기술 스택</h1>
프론트엔드
- HTML, CSS, JS, BootStrap, Thymeleaf
백엔드
- Spring Boot, Spring Security, Spring Data JPA
데이터베이스
- Hibernate, MySQL

<h1>📜 프로젝트 구현 기능</h1>
회원 (Member)
- 회원가입 / 로그인 및 로그아웃

상품 (Item)
- 상품 등록 / 상품 관리 / 상품 수정 / 상품 조회 (메인화면) / 상품 상세 페이지

주문 (Order)
- 상품 주문 / 주문 내역 조회 / 주문 취소

장바구니 (Cart)
- 장바구니 담기 / 장바구니 조회 / 장바구니 삭제 / 장바구니 상품 주문

  <h1>📂 프로젝트 DB 모델링</h1>
사진
member - 쇼핑몰 회원 정보 테이블
cart - 회원의 장바구니 목록 테이블
cart_item - 장바구니에 담긴 상품 정보 테이블
orders - 쇼핑몰 회원들의 주문 목록 테이블
order_item - 주문된 상품 정보 테이블
item - 쇼핑몰 상품 정보 테이블
item_img - 상품에 대한 이미지 정보를 담고 있는 테이블

<h1>📜 프로젝트 API 명세서</h1>

