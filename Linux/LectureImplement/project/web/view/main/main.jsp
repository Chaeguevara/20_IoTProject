<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="view/main/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="codepixer">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Educature Education</title>

<!--
			Google Font
			============================================= -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,500,600"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500i"
	rel="stylesheet">

<!--
			CSS
			============================================= -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="view/main/css/linearicons.css">
<link rel="stylesheet" href="view/main/css/font-awesome.min.css">
<link rel="stylesheet" href="view/main/css/bootstrap.css">
<link rel="stylesheet" href="view/main/css/magnific-popup.css">
<link rel="stylesheet" href="view/main/css/nice-select.css">
<link rel="stylesheet" href="view/main/css/animate.min.css">
<link rel="stylesheet" href="view/main/css/owl.carousel.css">
<link rel="stylesheet" href="view/main/css/main.css">
</head>

<body>

	<!-- Start Header Area -->
	<header id="header">
		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.html"><img src="view/main/img/logo.png" alt=""
						title="" /></a>
				</div>
				<c:choose>
					<%-- 유저로 로그인된 경우 --%>
					<c:when test="${loginuser != null && loginuser.position == '0'}">
						<nav id="nav-menu-container">
							<ul class="nav-menu">
								<li class="menu-active"><a href="main.mc">Home</a></li>
								<li class="menu-has-children"><a href="#">${loginuser.name }(${loginuser.id} )</a>
									<ul>
										<li><a href="mybook.mc?id=${loginuser.id} ">My book</a></li>
										<li><a href="userdetail.mc?id=${loginuser.id}">정보변경</a></li>
									</ul>
								</li>
								<li>
									<a href="logout.mc">로그아웃</a>
								</li>
							</ul>

						</nav>
					</c:when>
					<%-- 관리자로 로그인된 경우 --%>
					<c:when test="${loginuser.position == '1'}">
						<nav id="nav-menu-container">
							<ul class="nav-menu">
								<li class="menu-active"><a href="main.mc">Home</a></li>
								<li class="menu-has-children"><a href="#">${loginuser.name }(${loginuser.id} )</a>
									<ul>
										<li><a href="mybook.mc?id=${loginuser.id} ">My book</a></li>
										<li><a href="userdetailadminimpl.mc?id=${loginuser.id}">정보변경</a></li>
										<li><a href="manager.mc">관리자 페이지</a></li>
										
									</ul>
								</li>
								<li class="menu-has-children"><a href="">사용자 관리</a>
									<ul>	
										<li><a href="useraddadmin.mc">등록</a></li>
										<li><a href="userupdateadmin.mc">변경</a></li>
										<li><a href="userdeleteadmin.mc">삭제</a></li>
										<li><a href="userselectall.mc">조회</a></li>
									</ul>
								</li>
								<li class="menu-has-children"><a href="">책 관리</a>
									<ul>	
										<li><a href="bookadd.mc">등록</a></li>
										<li><a href="bookupdate.mc">변경</a></li>
										<li><a href="bookdelete.mc">삭제</a></li>
										<li><a href="bookselectall.mc">보유 장서 조회</a></li>
									</ul>
								</li>
								<li>
									<a href="logout.mc">로그아웃</a>
								</li>
							</ul>
						</nav>
					</c:when>
					<%-- 로그인되지 않은 경우 --%>
					<c:otherwise>
						<nav id="nav-menu-container">
								<ul class="nav-menu">
									<li class="menu-active"><a href="index.html">Home</a></li>
									<li><a href="login.mc">로그인</a></li>
									<li><a href="useradd.mc">회원가입</a></li>									
									<li class="menu-has-children"><a href="">Pages</a>
										<ul>
											<li><a href="view/main/elements.html">Elements</a></li>
											<li><a href="seat.mc">Seats</a></li>
										</ul>
									</li>
									<li class="menu-has-children"><a href="">Blog</a>
										<ul>
											<li><a href="view/main/blog-home.html">Blog Home</a></li>
											<li><a href="view/main/blog-single.html">Blog Details</a></li>
										</ul></li>
									<li><a href="view/main/contact.html">Contact</a></li>
								</ul>
							</nav>
					</c:otherwise>
				</c:choose>

				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<!-- End Header Area -->


	<section>
		<c:choose>
			<c:when test="${centerpage == null }">
				<jsp:include page="center.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="${centerpage}.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</section>


	<!-- Start Footer Area -->
	<footer class="footer-area section-gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-6 single-footer-widget">
					<h4>Top Products</h4>
					<ul>
						<li><a href="#">Managed Website</a></li>
						<li><a href="#">Manage Reputation</a></li>
						<li><a href="#">Power Tools</a></li>
						<li><a href="#">Marketing Service</a></li>
					</ul>
				</div>
				<div class="col-lg-2 col-md-6 single-footer-widget">
					<h4>Quick Links</h4>
					<ul>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Brand Assets</a></li>
						<li><a href="#">Investor Relations</a></li>
						<li><a href="#">Terms of Service</a></li>
					</ul>
				</div>
				<div class="col-lg-2 col-md-6 single-footer-widget">
					<h4>Features</h4>
					<ul>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Brand Assets</a></li>
						<li><a href="#">Investor Relations</a></li>
						<li><a href="#">Terms of Service</a></li>
					</ul>
				</div>
				<div class="col-lg-2 col-md-6 single-footer-widget">
					<h4>Resources</h4>
					<ul>
						<li><a href="#">Guides</a></li>
						<li><a href="#">Research</a></li>
						<li><a href="#">Experts</a></li>
						<li><a href="#">Agencies</a></li>
					</ul>
				</div>
				<div class="col-lg-4 col-md-6 single-footer-widget">
					<h4>Newsletter</h4>
					<p>You can trust us. we only send promo offers,</p>
					<div class="form-wrap" id="mc_embed_signup">
						<form target="_blank"
							action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
							method="get" class="form-inline">
							<input class="form-control" name="EMAIL"
								placeholder="Your Email Address" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Your Email Address '" required=""
								type="email">
							<button class="click-btn btn btn-default">
								<span class="lnr lnr-arrow-right"></span>
							</button>
							<div style="position: absolute; left: -5000px;">
								<input name="b_36c4fd991d266f23781ded980_aefe40901a"
									tabindex="-1" value="" type="text">
							</div>

							<div class="info"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="footer-bottom row align-items-center">
				<p class="footer-text m-0 col-lg-8 col-md-12">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						class="fa fa-heart-o" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
				<div class="col-lg-4 col-md-12 footer-social">
					<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
						class="fa fa-twitter"></i></a> <a href="#"><i
						class="fa fa-dribbble"></i></a> <a href="#"><i
						class="fa fa-behance"></i></a>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer Area -->

	<!-- ####################### Start Scroll to Top Area ####################### -->
	<div id="back-top">
		<a title="Go to Top" href="#"></a>
	</div>
	<!-- ####################### End Scroll to Top Area ####################### -->

	<script src="view/main/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="view/main/js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="view/main/js/easing.min.js"></script>
	<script src="view/main/js/hoverIntent.js"></script>
	<script src="view/main/js/superfish.min.js"></script>
	<script src="view/main/js/jquery.ajaxchimp.min.js"></script>
	<script src="view/main/js/jquery.magnific-popup.min.js"></script>
	<script src="view/main/js/owl.carousel.min.js"></script>
	<script src="view/main/js/owl-carousel-thumb.min.js"></script>
	<script src="view/main/js/jquery.sticky.js"></script>
	<script src="view/main/js/jquery.nice-select.min.js"></script>
	<script src="view/main/js/parallax.min.js"></script>
	<script src="view/main/js/waypoints.min.js"></script>
	<script src="view/main/js/wow.min.js"></script>
	<script src="view/main/js/jquery.counterup.min.js"></script>
	<script src="view/main/js/mail-script.js"></script>
	<script src="view/main/js/main.js"></script>
</body>

</html>