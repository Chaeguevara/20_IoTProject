<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	
	.search-book {
  margin-top: 200px;
  margin-bottom: 112px;
  text-align: center;
  color: #fff;
  position: relative; }

  .search-book h4 {
    font-size: 35px;
    font-weight: 700;
    margin-bottom: 20px; }

  .search-book p {
    color: #fff;
    max-width: 615px;
    margin: 0 auto;
    margin-bottom: 40px; }

</style>

<!-- 채희진 -->
<!-- 최종수정일: 2020.09.08 -->
<!-- 내용전체 복사 붙여넣기 하면 됨. -->
<div id="center">
	<!-- 로그인 된 배너-->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="search-book col-lg-12">
					<h1 class="text-white">등록되었습니다 </h1>
					<img src="view/main/img/bookimg/${regibook.img }" alt="" class="img-fluid">
					<p>책  "<${regibook.name }>"  등록되었습니다 </p>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
</div>