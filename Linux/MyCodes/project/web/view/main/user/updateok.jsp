<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="center">
	<!-- 로그인 된 배너-->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">업데이트 실패하였습니다. </h1>
					<p>${updateuser.name }님 정보가 업데이트 되었습니다. </p>
					<div class="link-nav">
						<span class="box"> <a href="main.mc">홈으로 </a> 
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
</div>