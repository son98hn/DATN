<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en" class="no-js">

        <head>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Trang chủ</title>
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
        </head>

        <body>
            <div class="container-fluid bg-faded fh5co_padd_mediya padding_786">
                <div class="container padding_786">
                    <nav class="navbar navbar-toggleable-md navbar-light ">
                        <button class="navbar-toggler navbar-toggler-right mt-3" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation"><span
                                class="fa fa-bars"></span></button>
                        <a class="navbar-brand" href="/trang-chu"><img
                                src="https://static-znews.zadn.vn/images/logo-zing-home.svg" alt="img"
                                class="mobile_logo_width" /></a>
                        <!-- <a class="navbar-brand" href="/login"><img style="width: 30px; margin-top: 5px;"
                                src="https://png.pngtree.com/png-vector/20190223/ourlarge/pngtree-profile-line-black-icon-png-image_691051.jpg"
                                alt="img" class="fh5co_logo_width" /></a> -->
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a href="/trang-chu"><img
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
                                <li class="nav-item active">
                                    <a href="/login"><img style="width: 30px; margin-top: 5px;"
                                            src="https://png.pngtree.com/png-vector/20190223/ourlarge/pngtree-profile-line-black-icon-png-image_691051.jpg"
                                            alt="img" class="fh5co_logo_width" /></a>
                                </li>

                            </ul>
                        </div>

                    </nav>
                </div>
            </div>
            <div class="container-fluid paddding mb-5">
                <div class="row mx-0">
                    <div class="col-md-6 col-12 paddding animate-box" data-animate-effect="fadeIn">
                        <div class="fh5co_suceefh5co_height"><img src="${firstSportNew.thumbnail}" alt="img" />
                            <div class="fh5co_suceefh5co_height_position_absolute"></div>
                            <div class="fh5co_suceefh5co_height_position_absolute_font">
                                <div class=""><a href="/bai-viet/${firstSportNew.id}" class="color_fff"> <i
                                            class="fa fa-clock-o"></i>&nbsp;&nbsp;${firstSportNew.createdDate}
                                    </a></div>
                                <div class=""><a href="/bai-viet/${firstSportNew.id}" class="fh5co_good_font">
                                        ${firstSportNew.title}</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-6 col-6 paddding animate-box" data-animate-effect="fadeIn">
                                <div class="fh5co_suceefh5co_height_2"><img src="${firstSocietyNew.thumbnail}"
                                        alt="img" />
                                    <div class="fh5co_suceefh5co_height_position_absolute"></div>
                                    <div class="fh5co_suceefh5co_height_position_absolute_font_2">
                                        <div class=""><a href="/bai-viet/${firstSocietyNew.id}" class="color_fff"> <i
                                                    class="fa fa-clock-o"></i>&nbsp;&nbsp;${firstSocietyNew.createdDate}
                                            </a></div>
                                        <div class=""><a href="/bai-viet/${firstSocietyNew.id}"
                                                class="fh5co_good_font_2">
                                                ${firstSocietyNew.title}</a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-6 paddding animate-box" data-animate-effect="fadeIn">
                                <div class="fh5co_suceefh5co_height_2"><img src="${firstWorldNew.thumbnail}"
                                        alt="img" />
                                    <div class="fh5co_suceefh5co_height_position_absolute"></div>
                                    <div class="fh5co_suceefh5co_height_position_absolute_font_2">
                                        <div class=""><a href="/bai-viet/${firstWorldNew.id}" class="color_fff"> <i
                                                    class="fa fa-clock-o"></i>&nbsp;&nbsp;${firstWorldNew.createdDate}
                                            </a></div>
                                        <div class=""><a href="/bai-viet/${firstWorldNew.id}" class="fh5co_good_font_2">
                                                ${firstWorldNew.title}</a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-6 paddding animate-box" data-animate-effect="fadeIn">
                                <div class="fh5co_suceefh5co_height_2"><img src="${firstTechnologyNew.thumbnail}"
                                        alt="img" />
                                    <div class="fh5co_suceefh5co_height_position_absolute"></div>
                                    <div class="fh5co_suceefh5co_height_position_absolute_font_2">
                                        <div class=""><a href="/bai-viet/${firstTechnologyNew.id}" class="color_fff"> <i
                                                    class="fa fa-clock-o"></i>&nbsp;&nbsp;${firstTechnologyNew.createdDate}
                                            </a></div>
                                        <div class=""><a href="/bai-viet/${firstTechnologyNew.id}"
                                                class="fh5co_good_font_2">
                                                ${firstTechnologyNew.title}</a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-6 paddding animate-box" data-animate-effect="fadeIn">
                                <div class="fh5co_suceefh5co_height_2"><img src="${firstEntertainmentNew.thumbnail}"
                                        alt="img" />
                                    <div class="fh5co_suceefh5co_height_position_absolute"></div>
                                    <div class="fh5co_suceefh5co_height_position_absolute_font_2">
                                        <div class=""><a href="/bai-viet/${firstEntertainmentNew.id}" class="color_fff">
                                                <i
                                                    class="fa fa-clock-o"></i>&nbsp;&nbsp;${firstEntertainmentNew.createdDate}
                                            </a></div>
                                        <div class=""><a href="/bai-viet/${firstEntertainmentNew.id}"
                                                class="fh5co_good_font_2">
                                                ${firstEntertainmentNew.title}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid pt-3">
                <div class="container animate-box" data-animate-effect="fadeIn">
                    <div>
                        <div class="fh5co_heading fh5co_heading_border_bottom py-2 mb-4">Thể thao</div>
                    </div>
                    <div class="owl-carousel owl-theme js" id="slider1">
                        <c:forEach var="sportNew" items="${sportNews}" begin="${sportNew.size()}"
                            end="${sportNew.size()+9}">
                            <div class="item px-2">
                                <div class="fh5co_latest_trading_img_position_relative">
                                    <div class="fh5co_latest_trading_img"><img src="${sportNew.thumbnail}" alt=""
                                            class="fh5co_img_special_relative" /></div>
                                    <div class="fh5co_latest_trading_img_position_absolute"></div>
                                    <div class="fh5co_latest_trading_img_position_absolute_1">
                                        <a href="/bai-viet/${sportNew.id}" class="text-white"> ${sportNew.title} </a>
                                        <div class="fh5co_latest_trading_date_and_name_color">${sportNew.createdDate}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="container-fluid pb-4 pt-5">
                <div class="container animate-box">
                    <div>
                        <div class="fh5co_heading fh5co_heading_border_bottom py-2 mb-4">Công nghệ</div>
                    </div>
                    <div class="owl-carousel owl-theme" id="slider3">
                        <c:forEach var="technologyNew" items="${technologyNews}" begin="${technologyNew.size()}"
                            end="${technologyNew.size()+9}">
                            <div class="item px-2">
                                <div class="fh5co_hover_news_img">
                                    <div class="fh5co_news_img"><img src="${technologyNew.thumbnail}" alt="" /></div>
                                    <div>
                                        <a href="/bai-viet/${technologyNew.id}"
                                            class="d-block fh5co_small_post_heading"><span
                                                class="">${technologyNew.title}</span></a>
                                        <div class="c_g"><i class="fa fa-clock-o"></i>${technologyNew.createdDate}</div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="container-fluid pb-4 pt-4 paddding">
                <div class="container paddding">
                    <div class="row mx-0">
                        <div class="col-md-8 animate-box" data-animate-effect="fadeInLeft">
                            <div>
                                <div class="fh5co_heading fh5co_heading_border_bottom py-2 mb-4">News</div>
                            </div>
                            <c:forEach var="lastNew" items="${lastNews}">
                                <div class="row pb-4">
                                    <div class="col-md-5">
                                        <div class="fh5co_hover_news_img">
                                            <div class="fh5co_news_img"><img src="${lastNew.thumbnail}" alt="" /></div>
                                            <div></div>
                                        </div>
                                    </div>
                                    <div class="col-md-7 animate-box">
                                        <a href="/bai-viet/${lastNew.id}" class="fh5co_magna py-2"> ${lastNew.title}</a>
                                        <br>
                                        <a href="/bai-viet/${lastNew.id}" class="fh5co_mini_time py-3">
                                            ${lastNew.createdDate} </a>
                                        <div class="fh5co_consectetur"> ${lastNew.shortDescription}
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-md-3 animate-box" data-animate-effect="fadeInRight">
                            <div>
                                <div class="fh5co_heading fh5co_heading_border_bottom pt-3 py-2 mb-4">Phổ biến nhất</div>
                            </div>
                            <div class="row pb-3">
                                <div class="col-5 align-self-center">
                                    <img src="\" alt="img" class="fh5co_most_trading" />
                                </div>
                                <div class="col-7 paddding">
                                    <div class="most_fh5co_treding_font"> 
                                    </div>
                                    <div class="most_fh5co_treding_font_123"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <form action="<c:url value='/trang-chu'/>" id="formSubmit" method="GET">
                        <ul class="pagination" id="pagination"></ul>
                        <input type="hidden" value="" id="page" name="page" />
                    </form>
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
            var totalPages = ${ totalPage };
            var currentPage = ${ page };
            var limit = 8;
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: totalPages,
                    visiblePages: 10,
                    startPage: currentPage,
                    onPageClick: function (event, page) {
                        if (currentPage != page) {
                            $('#page').val(page);
                            $('#formSubmit').submit();
                        }
                    }
                });
            });
        </script>

        </html>