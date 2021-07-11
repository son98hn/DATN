<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="/common/taglib.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>
        <dec:title default="Tin tức" />
      </title>
      <!-- 
 <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

      <!-- jQuery library -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

      <!-- Popper JS -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

      <!-- Latest compiled JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      <script src="https://kit.fontawesome.com/fe072047f5.js" crossorigin="anonymous"></script>
	<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
      <style>
      .container {
      display: flex;
      flex-direction: column;}
        .main {
          display: flex;
          flex-direction: row;
          margin-top: 25px;
          margin-left: 100px;
          margin-right: 100px;
        }

        .menu {
          
          background-color: #FFFAD5;
          width: 25%;
          display: flex;
          flex-direction: column;
          height: 100%;
          padding: 10px;
        }

        .category {
          margin: 10px;
          font-size: 14px;
          font-weight: bold;
        }

        .content {
          width: 75%;
          padding: 10px;
          display: flex;
          flex-direction: column;

        }

        .title {
          display: flex;
          justify-content: center;
        }
        .content-content {
          
          display: flex;
          flex-direction: row;
          flex-wrap:wrap;
        }
        .block {
          display: flex;
          flex-direction: column;
          width:50%;
        }
      
        .block-2 {
          display: flex;
          flex-direction: row;
        }
        .block-2-1 {
          width: 50%;
        }
        .block-2-2 {
          width: 50%;
          display: flex;
          flex-direction: column;
        }
      </style>
    </head>

    <body>
      <%@ include file="/common/web/header.jsp" %>

        <div>
          <dec:body />
        </div>

        <%@include file="/common/web/footer.jsp" %>
    </body>
<script>
				var totalPages = ${ model.totalPage };
				var currentPage = ${ model.page };
				var limit = 6;
				$(function () {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages: totalPages,
						visiblePages: 10,
						startPage: currentPage,
						onPageClick: function (event, page) {
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