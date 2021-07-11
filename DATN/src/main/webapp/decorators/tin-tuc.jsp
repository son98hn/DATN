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

      <style>
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

        .name-category {
          background-color: #EAF6FF;
          color: #485986;
        }

        .content-news {
          display: flex;
          flex-direction: row;
        }

        .first-news {
          display: flex;
          width: 45%;
          flex-direction: column;
        }

        .second-news {
          width: 30%;
          display: flex;
          flex-direction: column;
        }

        .last-news {
          width: 25%;
          display: flex;
          flex-direction: column;
        }

        .first-news img {
          width: 355px;
          height: 200px;
        }

        .last-news img {
          width: 200px;
          height: 175px;
        }

        @media only screen and (max-width: 1024px) and (min-width: 769px) {
        .main {
          margin-left: 50px;
          margin-right: 50px;
        }
        .first-news img {
          width: 100%;
          display: flex;
          max-width: 290px;
        }
        }
        @media only screen and (max-width: 768px) and (min-width: 481px) {
          .main {
            margin-left: 3px;
            margin-right: 3px;
          }
          .menu {
            display: none;
          }
          .content {
            width: 100%;
          }
          .first-news img {
            display: flex;
            width: 100%;
            max-width: 300px;
            height: 200px;
          }
          .last-news img {
            display: flex;
            width: 100%;
            max-width: 190px;

          }
        }
        @media only screen and (max-width: 480px) {
          .menu {
            display: none;
          }

          .main {
            padding: 0px;
            margin-left: 5px;
            margin-right: 5px;
          }

          .content {
            width: 100%;
          }

          .content-tin {
            display: flex;
            flex-direction: column;
          }

          .content-news {
            display: flex;
            flex-direction: column;
          }

          .first-news {
            display: flex;
            width: 100%;
            flex-direction: column;
          }
          .first-news img {
            max-width: 450px;
            max-height: 300px;
            width: 100%;
            display: flex;
          }
          .second-news {
            display: flex;
            width: 100%;
            flex-direction: column;
          }

          .last-news {
            display: flex;
            flex-direction: column;
            width: 100%;
          
          }
          .last-news img {
            display: flex;
            width: 100%;
            max-height: 300px;
            max-width: 450px;
          }
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

    </html>