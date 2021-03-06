<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id='center'>
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">유저정보 변경</h1>
					<p>유저정보를 변경합니다.</p>
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

	
	<!-- 회원 수정 영역 -->
	<div></div>
	<section class="sample-text-area">
		<div class="container border-top-generic">
			<h3 class="text-heading">사용자 정보 수정</h3>
			<form id ="updateform" action="userupdateadminimple.mc" method="post">
				<div class="mt-10">
					<div class="percentage">ID: ${dbuser.id }</div>
					<input type="hidden" name="id" value="${dbuser.id }">
				</div>
				<div class="mt-10">
					<input type="text" name="name" placeholder="이름" value="${dbuser.name}" onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'"
					 required class="single-input">
				</div>
				<div class="mt-10">
					<input type="text" name="pwd" placeholder="비밀번호" value="${dbuser.pwd}" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'"
					 required class="single-input">
				</div>
				<c:choose>
					<c:when test="${position == '1'}">
						<div class="mt-10">
							<div class="default-select" id="default-select" >
								<select name="position">
									<option value="0">일반사용자</option>
									<option value="1">관리자</option>
								</select>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<input type = "hidden" name="position" value ="0">
					</c:otherwise>
				</c:choose>
				<div class="button-group-area mt-10">
					<input class="genric-btn info circle arrow" type="submit" form="updateform" value="정보변경">
					<a href="userdeleteimpl.mc?id=${dbuser.id} " class="genric-btn danger circle">삭제</a>
				</div>
			</form>
		</div>
	</section>
</div>