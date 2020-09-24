<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id='center'>
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">유저삭제</h1>
					<p>회원을 삭제합니다.</p>
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

	
	<!-- 회원 삭제 영역 -->
	<div></div>
	<section class="sample-text-area">
		<div class="container border-top-generic">
			<h3 class="text-heading">회원 삭제</h3>
			<form id ="registerform" action="userdeleteimpl.mc" method="post">
				<div class="mt-10">
					<input type="text" name="id" placeholder="아이디" onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디'"
					 required class="single-input">
				</div>
				<div class="button-group-area mt-10">
					<input class="genric-btn info circle arrow" type="submit" value="회원삭제">
				</div>
			</form>
		</div>
	</section>
</div>