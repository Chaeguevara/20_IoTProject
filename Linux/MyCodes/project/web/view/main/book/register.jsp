<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div id="center">
	<!-- Start Banner Area -->
	<section class="banner-area relative">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">관리자 페이지</h1>
					<p>매니저와 관련된 행위.도서 대출 내역 조회, 신간 도서 입력.</p>
					<div class="link-nav">
						<span class="box"> <a href="index.html">홈 </a> <i
							class="lnr lnr-arrow-right"></i> <a href="elements.html">로그인</a>
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

	<!-- 메인 내용 -->
	<!-- 신간도서 입력 시작-->
	<div class="whole-wrap">
		<div class="container">
			<div class="section-top-border">
				<div class="row">
					<div class="col-lg-8 col-md-8">
						<h3 class="mb-30">책 등록</h3>
						<form enctype="multipart/form-data" action="bookaddimpl.mc" method ="post">
							<div class="mt-10">
								커버 이미지: <input type="file" name="mf">
							</div>
							<div class="mt-10">
								<input type="text" name="id" placeholder="일련번호" onfocus="this.placeholder = ''" onblur="this.placeholder = '일련번호'"
								 required class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="name" placeholder="책이름" onfocus="this.placeholder = ''" onblur="this.placeholder = '책이름'"
								 required class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="author" placeholder="저자" onfocus="this.placeholder = ''" onblur="this.placeholder = '저자'"
								 required class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="publisher" placeholder="출판사" onfocus="this.placeholder = ''" onblur="this.placeholder = '출판사'"
								 required class="single-input">
							</div>
							<div class="mt-10">
								<input type="number" name="qt" placeholder="권 수" onfocus="this.placeholder = ''" onblur="this.placeholder = '권 수'"
								 required class="single-input">
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<div class="form-select" id="default-select" >
									<select name = category>
										<option value="카테고리">카테고리</option>
										<option value="소설">소설</option>
										<option value="경영 / 경제">경영 / 경제</option>
										<option value="인문 / 사회 ">인문 / 사회</option>
										<option value="자기계발">자기계발</option>
									</select>
								</div>
							</div>
							<div class="mt-10">
								<textarea class="single-textarea" name="contents" placeholder="책소개" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Message'"
								 required></textarea>
							</div>
							<div class="button-group-area mt-10">
								<input class="genric-btn info circle arrow" type="submit" value="등록"> 
							</div>	
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 신간도서 입력 끝-->
</div>
	<!-- 메인내용 끝 -->