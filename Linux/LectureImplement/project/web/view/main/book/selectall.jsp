<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id='center'>
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">책 목록페이지</h1>
					<p>전체 책 목록을 불러옵니다.</p>
					<div class="link-nav">
						<span class="box">
							<a href="main.mc">홈 </a>
							<i class="lnr lnr-arrow-right"></i>
							<a href="register.mc">회원가입</a>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="rocket-img">
			<img src="img/rocket.png" alt="">
		</div>
	</section>
	<!-- End Banner Area -->

	
	<!-- 책 정보 얻어오기 -->
	
	<section class="sample-text-area">
		<div class="container border-top-generic">
		<h3 class="text-heading">책 정보 조회</h3>
		<div class="progress-table">
			<div class="table-head">
				<div class="serial">아이디</div>
				<div class="country">도서명</div>
				<div class="country">작가</div>
				<div class="visit">출판사</div>
				<div class="visit">카테고리</div>
				<div class="percentage">소개말</div>
				
			</div>
			<c:forEach var="b" items="${booklist }">
				<div class="table-row">
					<div class="serial"><a href="bookdetail.mc?id=${b.id} ">${b.id}</a></div>
					<div class="country">${b.name}</div>
					<div class="country">${b.author }</div>
					<div class="visit">${b.publisher }</div>
					<div class="visit">${b.category }</div>
					<div class="percentage">${b.contents }</div> 
				</div>				
			</c:forEach>
		</div>
		</div>
	</section>
</div>