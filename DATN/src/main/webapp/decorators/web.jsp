<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- 
 <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"

	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/fe072047f5.js"
	crossorigin="anonymous"></script>

<style>
.main {
	display: flex;
	flex-direction: column;
	margin-top: 0;
}

.carousel {
	margin-top: 0px;
}

.content {
	margin-top: 50px;
	margin-left: 100px;
	margin-right: 100px;
	padding: 10px;
	display: flex;
	flex-direction: row;
}

.left-content {
	width: 33%;
	display: flex;
	flex-direction: column;
}

.left-content-title {
	margin-top: 30px;
	margin-bottom: 30px;
}

.left-content-content {
	border: 1px;
	border-radius: 2px;
	background-color: #3E4D5C;
	display: flex;
	flex-direction: column;
}

.mid-content {
	width: 33%;
	display: flex;
	flex-direction: column;
}

.mid-content-title {
	margin-top: 30px;
	margin-bottom: 30px;
}

.mid-content-content {
	display: flex;
	flex-direction: column;
}

.mid-content-content-block-1 {
	width: 100%;
}

.mid-content-content-block-1 img {
	width: 100%;
	height: 100%;
}

.mid-content-content-block-2 {
	width: 100%;
	display: flex;
	flex-direction: column;
}

.last-content {
	width: 33%;
	display: flex;
	flex-direction: column;
}

.last-content-block-1 {
	display: flex;
	flex-direction: row;
}

.last-content-block-2 {
	display: flex;
	flex-direction: column;
}

.content-left-content-block {
	display: flex;
	flex-direction: row;
	width: 100%;
	justify-content: space-around;
}

.content-left-content-block-1 img {
	border-radius: 50%;
	width: 20%;
}

.content-left-content-block-2 {
	width: 60%;
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.content-left-content-block-2 :first-child {
	font-weight: bold;
	font-size: 15px;
}

.content-left-content-block-2 :last-child {
	font-size: 10px;
}

.content-left-content-block-3 {
	width: 20%;
}
@media only screen and (max-width: 480px) {  
	.main {
		padding: 3px;
	}
	.slide {
		display: none;
	}
	.content {
		display: flex;
		padding: 5px;
		flex-direction: column;
		margin: 0px;
	}
	.left-content {
		display: none;
	}
	.mid-content {
		display: flex;
		flex-direction: column;
		width: 100%;
	}

	.last-content {
		width: 100%;
	}
	.mid-content-content {
		display: flex;
	}

	.mid-content-content-block-1 img {
		max-width: 630px;
		max-height: auto;
		display: flex;		
	}
}
@media only screen and (max-width: 767px) and (min-width: 481px){
	.content {
		display: flex;
		padding: 5px;
		flex-direction: column;
		margin: 0px;
	}
	.left-content {
		display: none;
	}
	.mid-content {
		display: flex;
		flex-direction: column;
		width: 100%;
	}

	.last-content {
		width: 100%;
	}
	.mid-content-content {
		display: flex;
	}

	.mid-content-content-block-1 img {
		max-width: 830px;
		max-height: auto;
		display: flex;		
	}
}
@media only screen and (max-width: 1024px) and (min-width: 768px){ 
	.content {
	margin-top: 20px;
	margin-left: 30px;
	margin-right: 30px;
	padding: 5px;
	display: flex;
	flex-direction: row;
}
.content-left-content-block-1 {
	width: 30px;
	height: 30px;
}
}

</style>
</head>

<body>
	<%@ include file="/common/web/header.jsp"%>

	<div>
		<dec:body />
	</div>

	<%@include file="/common/web/footer.jsp"%>
</body>

</html>