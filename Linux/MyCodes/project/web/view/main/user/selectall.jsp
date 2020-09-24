<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id='center'>
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">유저목록 페이지</h1>
					<p>전체 유저 목록을 불러옵니다.</p>
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

	
	<!-- 회원 정보 얻어오기 -->
	
	<section class="sample-text-area">
		<div class="container border-top-generic">
			<h3 class="text-heading">회원 정보 조회</h3>
			<div class="mt-10">
				<a href="userselectalladminimpl.mc" class="genric-btn info-border circle arrow">회원정보 가져오기<span class="lnr lnr-arrow-right"></span></a>
			</div>
			<div class="progress-table">
				<div class="table-head">
					<div class="serial">ID</div>
					<div class="country">비밀번호</div>
					<div class="visit">이름</div>
					<div class="percentage">직위</div>
				</div>
				<c:forEach var="u" items="${userlist }">
					<div class="table-row">
						<div class="serial"><a href="userdetail.mc?id=${u.id }&position=1">${u.id } </a></div>
						<div class="country"> ${u.pwd } </div>
						<div class="visit">	  ${u.name }</div>
						<div class="percentage"> ${u.position }</div>  
					</div>				
				</c:forEach>
			</div>
		</div>
	</section>
</div>