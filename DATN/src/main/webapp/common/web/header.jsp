<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>
        <!-- Navigation -->
        <style>
            .header {
                background-color: #ECECEC;
                display: flex;
                height: 25px;
            }

            .left-header {
                width: 50%;
                display: flex;
                justify-content: flex-start;
                align-items: center;
                color: black;
                padding-left: 100px;
            }

            .left-header span {
                margin: 5px;
            }

            .right-header {
                width: 50%;
                display: flex;
                justify-content: space-between;
                align-items: center;
                /* padding-left: 100px; */
                color: black;
                padding-right: 100px;
            }

            .right-header a {
                margin: 10px;
            }

            .banner {
                display: flex;
            }

            .left-banner {
                width: 50%;
                padding-left: 100px;
            }

            .left-banner img {
                width: 80%;
            }

            .right-banner {
                width: 50%;
                padding-right: 100px;
                justify-content: space-around;
                align-items: center;
                display: flex;
                flex-direction: row;
            }

            .right-banner img {
                width: 20%;
            }

            .nvarbarr {
                background-color: #FCB71E;
                display: flex;
                padding-left: 100px;
                padding-right: 100px;
                justify-content: space-around;
                align-items: center;
                height: 40px;
            }

            .nvarbarr a {
                color: white;
                font-size: 15px;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropbtn {
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
                /* cursor: pointer; */
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 200px;
                box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {
                background-color: #f1f1f1
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
           
           @media only screen and (max-width: 1024px) and (min-width: 768px) { 
           .left-header { 
           padding-left: 50px;
           }
           .right-header {
           padding-right: 50px;}
          
             .left-banner {
               
                padding-left: 50px;
            }
    		.right-banner {
    		padding-right: 50px;}        
	           }
            @media only screen and (max-width: 767px) {
                .header {
                    display: flex;
                    flex-direction: row;
                    height: 30px;
                    background-color: #ECECEC;
                    
                }

                .left-header {
                    display:none;
                }
                .right-header {
                    width: 100%;
                    display: flex;
                    justify-content: space-evenly;
                    /* padding: 2px; */
                    
                }

                .right-header a {
                    font-size: 12px;
                }

                .banner {
                    display: flex;
                }

                .left-banner {
                    width: 100%;
                    padding-left: 0px;
                }

                .left-banner img {
                    width: 100%;
                }

                .right-banner {
                    width: 0%;
                }

                .nvarbarr a {
                    font-size: 8px;
                }

                .nvarbarr {
                    padding: 0px;
                }

            }
        </style>
        <header class="header">
            <div class="left-header">
                <span>Đường dây nóng hỗ trợ</span> <span style="font-weight: bold;">1900
                    54 54 81</span>
            </div>
            <div class="right-header">
                <a href="#" style="text-decoration: none; color: black">Giới thiệu</a>
                <a href="#" style="text-decoration: none; color: black">Hỏi đáp</a> <a href="#"
                    style="text-decoration: none; color: black">Liên hệ</a>
                <c:if test="${not empty USERMODEL}">
                    <a href='<c:url value="/thoat?action=logout"/>'
                        style="text-decoration: none; color: black">Thoát</a>
                </c:if>
                <c:if test="${empty USERMODEL}">
                    <a href='<c:url value="/dang-nhap?action=login"/>' style="text-decoration: none; color: black">Đăng
                        nhập</a>
                </c:if>
            </div>
        </header>
        <div class="banner">
            <div class="left-banner">

                <a href='<c:url value="/trang-chu"/>'><img src="./img/logo.PNG" alt=""></a>
            </div>
            <div class="right-banner">
                <img src="./img/tra-cuoc.PNG" alt=""> <img src="./img/danh-gia.PNG" alt=""> <img src="./img/tin.PNG"
                    alt="">
            </div>
        </div>
        <div class="nvarbarr">
            <!-- <div class="dropdown">
                <span class="dropbtn">Tra cứu - Định vị</span>
                <div class="dropdown-content">
                    <a href="#">Định vị bưu gửi</a>
                    <a href="#">Định vị chuyển tiền</a>
                    <a href="#">Mạng lưới bưu cục</a>
                    <a href="#">Tra cứu hàng cấm gửi</a>
                    <a href="#">Tra cứu kì cước KHL</a>
                    <a href="#">Mã địa chỉ bưu chính</a>
                </div>
            </div> -->

        <a href="#" style="text-decoration: none;">Tra cứu - Định vị</span></a> <a
                href='<c:url value ="buu-chinh-chuyen-phat?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                style="text-decoration: none;">Bưu
                chính chuyển phát</span> </a> <a
                href='<c:url value ="tai-chinh-buu-chinh?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                style="text-decoration: none;">Tài
                chính bưu chính</span> </a> <a
                href='<c:url value ="phan-phoi-truyen-thong?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                style="text-decoration: none;">Phân
                phối chuyển phát</span></a> <a href='<c:url value ="/tin-tuc"/>' style="text-decoration: none;">Tin
                tức</span></a> <a href="#" style="text-decoration: none;">EMAIL</span></a>
        </div> 
        <!-- <div class="menu">
            <nav class="navbar navbar-expand-md">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                            fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                d="M2.5 11.5A.5.5 0 0 1 3 11h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 7h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 3h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
                        </svg></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="#" style="text-decoration: none;">Tra cứu - Định vị</span></a>
                        </li>
                        <li class="nav-item">
                            <a href='<c:url value ="buu-chinh-chuyen-phat?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                                style="text-decoration: none;">Bưu
                                chính chuyển phát</span> </a>
                        </li>
                        <li class="nav-item">
                            <a href='<c:url value ="tai-chinh-buu-chinh?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                                style="text-decoration: none;">Tài
                                chính bưu chính</span> </a>
                        </li>
                        <li class="nav-item">
                            <a href='<c:url value ="phan-phoi-truyen-thong?page=1&maxPageItem=6&sortName=createddate&sortBy=desc"/>'
                                style="text-decoration: none;">Phân
                                phối chuyển phát</span></a>
                        </li>
                        <li class="nav-item">
                            <a href='<c:url value ="/tin-tuc"/>' style="text-decoration: none;">Tin
                                tức</span></a>
                        </li>
                        <li class="nav-item">

                        </li>
                    </ul>
                </div>
            </nav>
        </div> -->