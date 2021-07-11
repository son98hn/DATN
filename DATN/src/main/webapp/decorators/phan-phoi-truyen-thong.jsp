<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title><dec:title default="Phân phối truyền thông" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/fe072047f5.js"
	crossorigin="anonymous"></script>
<script
	src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

<style>
.main {
	display: flex;
	flex-direction: column;
	margin-top: 0;
	margin-left: 100px;
	margin-right: 100px;
}

.main-title {
	display: flex;
	justify-content: center;
}

.main-title span {
	color: orange;
	font-size: 25px;
	font-weight: bold;
}

.main-content {
	display: flex;
	flex-direction: column;
}

.main-content-items {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
}

.main-content-item {
	width: 33%;
	display: flex;
	flex-direction: column;
}

.main-content-item img {
	width: 360px;
	height: 205px;
}

@media only screen and (max-width: 1024px) and (min-width: 576px) {
	.main {
		margin-left: 50px;
		margin-right: 50px;
	}
	.main-content-item img {
		width: 100%;
		height: auto;
		max-width: 280px;
		max-height: 200px;
	}
}

@media only screen and (max-width: 575px) {
	.main-content-items {
		display: flex;
		flex-direction: column;
		flex-wrap: wrap;
	}
	.main-content-item {
		width: 100%;
		display: flex;
		flex-direction: column;
	}
	.main {
		margin: 5px;
		margin-left: 10px;
		margin-right: 10px;
	}
	.main-content-item img {
		max-width: 500px;
		max-height: 300px;
		display: flex;
		width: 100%;
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
<script>
	var totalPages = $
	{
		model.totalPage
	};
	var currentPage = $
	{
		model.page
	};
	var limit = 6;
	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 2,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#sortName').val('createddate');
					$('#sortBy').val('desc');
				}
			}
		});
	});
</script>

</html>