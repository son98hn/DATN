<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html lang="en" class="no-js">

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<title>Đăng kí</title>
			<link rel="stylesheet" href="<c:url value='/template/web/css/media_query.css'/>" />
			<link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.css'/>" />
			<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
				integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
				crossorigin="anonymous">
			<link rel="stylesheet" href="<c:url value='/template/web/css/animate.css'/>" />
			<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
			<link rel="stylesheet" href="<c:url value='/template/web/css/owl.carousel.css'/>" />
			<link rel="stylesheet" href="<c:url value='/template/web/css/owl.theme.default.css'/>" />
			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="<c:url value='/template/web/css/style_1.css'/>" />
			<!-- Modernizr JS -->
			<script src="<c:url value='/template/web/js/modernizr-3.5.0.min.js'/>"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
			<link href="<c:url value='/template/login/style1.css' />" rel="stylesheet" type="text/css" media="all" />
		</head>

		<body>
			<div class="container-fluid bg-faded fh5co_padd_mediya padding_786">
				<div class="container padding_786">
					<nav class="navbar navbar-toggleable-md navbar-light ">
						<button class="navbar-toggler navbar-toggler-right mt-3" type="button" data-toggle="collapse"
							data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
							aria-expanded="false" aria-label="Toggle navigation"><span
								class="fa fa-bars"></span></button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
								<li class="nav-item active">
									<a class="navbar-brand" href="/trang-chu"><img
											src="https://static-znews.zadn.vn/images/logo-zing-home.svg" alt="img"
											class="fh5co_logo_width" /></a>
								</li>
								<c:forEach var="categoryP" items="${categoryParent}" begin="${categoryP.size()}"
									end="${categoryP.size()+4}">
									<li class="nav-item ">

										<a class="nav-link"
											href='<c:url value ="/nhom-bai-viet/${categoryP.code}"/>'>${categoryP.name}<span
												class="sr-only">(current)</span></a>
									</li>
								</c:forEach>
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#" id="dropdownMenuButton2"
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Xem thêm <span
											class="sr-only">(current)</span></a>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuLink_1">
										<c:forEach var="categoryP" items="${categoryParent}"
											begin="${categoryP.size()+6}"><a class="dropdown-item"
												href='<c:url value ="/nhom-bai-viet/${categoryP.code}"/>'>${categoryP.name}</a>
										</c:forEach>
									</div>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>

			<div class="container-fluid pb-4 pt-4 paddding">
				<div class="container paddding">
					<div class="row mx-0">
						<div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
							<div class="login-form">
					<div class="main-div">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group">
								<input type="text" class="form-control" id="name" name="name"
									   placeholder="Tên">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="username" name="username"
									placeholder="Tên đăng nhập">
							</div>
						
							<div class="form-group">
								<input type="password" class="form-control" id="password" name="password"
									placeholder="Mật khẩu">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
									   placeholder="Nhập lại mật khẩu">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="email" name="email"
									   placeholder="Email">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="phone" name="phone"
									   placeholder="Số điện thoại">
							</div>
							<button type="button" class="btn btn-primary" id="btnRegister">Đăng ký</button>

						</form>
						<br>
					</div>
				</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid fh5co_footer_bg pb-3">
				<div class="container animate-box">
					<div class="row">
						<div class="col-12 spdp_right py-5">
						</div>
						<div class="clearfix"></div>
						<div class="col-12 col-md-4 col-lg-3">
							<div class="footer_main_title py-3"> About</div>
							<div class="footer_sub_about pb-3"> Lorem Ipsum is simply dummy text of the printing and
								typesetting
								industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
								when an
								unknown printer took a galley of type and scrambled it to make a type specimen book.
							</div>
							<div class="footer_mediya_icon">
								<div class="text-center d-inline-block"><a class="fh5co_display_table_footer">
										<div class="fh5co_verticle_middle"><i class="fa fa-linkedin"></i></div>
									</a></div>
								<div class="text-center d-inline-block"><a class="fh5co_display_table_footer">
										<div class="fh5co_verticle_middle"><i class="fa fa-google-plus"></i></div>
									</a></div>
								<div class="text-center d-inline-block"><a class="fh5co_display_table_footer">
										<div class="fh5co_verticle_middle"><i class="fa fa-twitter"></i></div>
									</a></div>
								<div class="text-center d-inline-block"><a class="fh5co_display_table_footer">
										<div class="fh5co_verticle_middle"><i class="fa fa-facebook"></i></div>
									</a></div>
							</div>
						</div>
						<div class="col-12 col-md-3 col-lg-2">
							<div class="footer_main_title py-3"> Category</div>
							<ul class="footer_menu">
								<c:forEach var="categoryP" items="${categoryParent}" begin="${categoryP.size()}"
									end="${categoryP.size()+5}">
									<li><a href='<c:url value ="/nhom-bai-viet/${categoryP.code}"/>' class=""><i
												class="fa fa-angle-right"></i>&nbsp;&nbsp;
											${categoryP.name}</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="col-12 col-md-3 col-lg-2">
							<div class="footer_main_title py-3"> </div>
							<ul class="footer_menu">
								<c:forEach var="categoryP" items="${categoryParent}" begin="${categoryP.size()+6}"
									end="${categoryP.size()+11}">
									<li><a href='<c:url value ="/nhom-bai-viet/${categoryP.code}"/>' class=""><i
												class="fa fa-angle-right"></i>&nbsp;&nbsp;
											${categoryP.name}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="row justify-content-center pt-2 pb-4">
						<div class="col-12 col-md-8 col-lg-7 ">
							<div class="input-group">
								<span class="input-group-addon fh5co_footer_text_box" id="basic-addon1"><i
										class="fa fa-envelope"></i></span>
								<input type="text" class="form-control fh5co_footer_text_box"
									placeholder="Enter your email..." aria-describedby="basic-addon1">
								<a href="#" class="input-group-addon fh5co_footer_subcribe" id="basic-addon12"> <i
										class="fa fa-paper-plane-o"></i>&nbsp;&nbsp;Subscribe</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="gototop js-top">
				<a href="#" class="js-gotop"><i class="fa fa-arrow-up"></i></a>
			</div>


		</body>
		<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
		<!--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
			integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
			crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
			integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
			crossorigin="anonymous"></script>
		<!-- Waypoints -->
		<script src="<c:url value='/template/web/js/jquery.waypoints.min.js'/>"></script>
		<!-- Main -->
		<script src="<c:url value='/template/web/js/main.js'/>"></script>
		<script>
			  $('#btnRegister').click(function (e) {
                e.preventDefault();
                // var data = {};
                var formData = $('#formSubmit').serializeArray();
                // $.each(formData, function (i, v) {
                //     data["" + v.name + ""] = v.value;
                // });
                    register(formData);
            });
			function register(data) {
                var username = "";
                var name = "";
                var email = "";
                var phone = "";
                var password = "";
				var confirmPassword = "";
                data.forEach(element => {
                    if (element.name == "username")
                        username = element.value;
                    if (element.name == "name")
                        name = element.value;
                    if (element.name == "email")
                        email = element.value;
                    if (element.name == "phone")
                        phone = element.value;
					if (element.name == "password")
                        password = element.value;
					if (element.name == "confirmPassword")
                        confirmPassword = element.value;
                });
                sendDta = {
                    username: username,
                    name: name,
                    email: email,
                    phone: phone,
                    password: password,
					confirmPassword: confirmPassword
                };
                $.ajax({
                    url: '/register',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(sendDta),
                    dataType: 'json',
                    success: function (result) {
                        window.location.href = "/register?id=" + result.id + "&message=insert_success";
                    },
                    error: function (error) {
                        window.location.href = "/register?message=error_system";
                    }
                });
            }
		</script>
		</html>