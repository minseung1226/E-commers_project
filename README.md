<h2><b>쇼핑몰 프로젝트</b></h2>

mvc 패턴을 도입한 쇼핑몰의 기본적인 기능과 구현 <br>
쇼핑몰을 이용하는 회원의 상품 구매 <br>
쇼핑몰을 관리하는 관리자의 쇼핑몰 운영<br>

<h2><b>사용 기술</b></h2>
<ul>
  <li>Spring boot</li>
  <li>mybatis</li>
  <li>spring interceptor</li>
  <li>jquery</li>
  <li>thymeleaf</li>
  <li>AOP</li>
  <li>AJAX</li>
  <li>MySQL</li>
  
</ul>


<h2><b>DB 구조</b></h2>
<img src="https://user-images.githubusercontent.com/102594142/197384389-7c0bf66f-6801-42c9-933b-3085be60401e.png">


<h2><b>화면 구성</b></h2>
<h3>home</h3>
<img src="https://user-images.githubusercontent.com/102594142/197386309-41a023fe-922c-4376-945f-2d95bacda5ee.png">
<hr>

<h3>Main Bar</h3>
<img src="https://user-images.githubusercontent.com/102594142/197385471-7593f59a-0d3d-45f4-9213-e0c93799affd.png">
-> 회원,비회원,관리자에 따라 mainbar를 다르게 사용

<br>
<hr>

<h3>장바구니</h3>
<img src="https://user-images.githubusercontent.com/102594142/197386512-7fc563c4-01fd-4c6b-be0a-8cf3b6a778d9.png">
<h4>-> 체크가 된 상품들의 총 판매 금액을 아래 버튼에 나타내줌으로써 회원들에게 편리한 서비스를 제공</h4>
<hr>

<h3>주문</h3>
<img src="https://user-images.githubusercontent.com/102594142/197386789-ee20d261-8922-4791-810b-691121799dd3.png">
<h4>-> 주문이 완료되면 주문테이블에 정보를 insert 결제완료된 상품들을 장바구니에서 delete 상품 테이블의 판매량과 판매금액을 증가,회원 테이블의 해당 회원의 결제금액을
증가</h4>
<br>
<hr>

<h3>상품 리뷰</h3>
<img src="">
<h4>-> 주문완료한 상품에 한해서 리뷰작성 or 수정 가능 </h4>
