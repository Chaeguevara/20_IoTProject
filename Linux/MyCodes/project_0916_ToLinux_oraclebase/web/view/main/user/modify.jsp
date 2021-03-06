<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<div id='center'>
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">유저정보 변경</h1>
					<p>유저정보를 변경</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	
	<!-- 회원 수정 영역 -->
	<div></div>
	<section class="sample-text-area">
		<div class="container border-top-generic">
			<h3 class="text-heading">사용자 정보 수정</h3>
			<form id ="updateform" action="userupdateimple.mc" method="post"></form>
			<form id ="acquireform" action="usergetidimpl.mc" method="post"></form>
			<div class="mt-10">
				<div class="percentage">${dbuser.id }</div>
			</div>
			<div class="mt-10">
				<input class="genric-btn info circle arrow" type="submit" form="acquireform" value="아이디 조회">
			</div>
			<div class="mt-10">
				<input type="text" name="name" placeholder="이름" value="${dbuser.name}" onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'"
				 required class="single-input">
			</div>
			<div class="mt-10">
				<input type="password" name="pwd" placeholder="비밀번호" value="${dbuser.pwd}" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'"
				 required class="single-input">
			</div>
			<div class="mt-10">
				<div class="default-select" id="default-select" >
					<select name="position">
						<option value="0 ">일반사용자</option>
						<option value="1 ">관리자</option>
					</select>
				</div>
			</div>
			<div class="button-group-area mt-10">
				<input class="genric-btn info circle arrow" type="submit" form="updateform" value="정보변경">
			</div>
		</div>
	</section>
</div>