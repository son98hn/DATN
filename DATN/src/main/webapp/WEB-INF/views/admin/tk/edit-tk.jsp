<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Chỉnh sửa tài khoản</title>
            <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
            <link rel="stylesheet"
                href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
            <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />"
                class="ace-main-stylesheet" id="main-ace-style" />
            <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
            <link rel="stylesheet"
                href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
            <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
            <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
        </head>

        <body class="no-skin">
            <div id="navbar" class="navbar navbar-default ace-save-state">
                <div id="navbar-container ace-save-state" id="navbar-container">
                    <div class="navbar-header pull-left">
                        <a href="/admin-home" class="navbar-brand"> <small> <i class="fa fa-leaf"></i>Trang quản trị
                            </small>
                        </a>
                    </div>
                    <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
                        <ul class="nav ace-nav">
                            <li class="light-blue dropdown-modal">
                                <a date-toggle="dropdown" href="#" class="dropdown-toggle">Wellcome,
                                    ${userInfo}
                                </a>
                            </li>
                            <li class="light-blue dropdown-modal"><a href="#"> <i class="ace-icon fa fa-power-off"></i>
                                    Thoát
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="main-container" id="main-container">
                <script type="text/javascript">
                    try {
                        ace.settings.check('main-container', 'fixed')
                    } catch (e) {
                    }
                </script>
                <div id="sidebar" class="sidebar responsive ace-save-state">
                    <script type="text/javascript">
                        try {
                            ace.settings.loadSate('slidebar')
                        } catch (e) {
                        }
                    </script>
                    <div class="sidebar-shortcuts">
                        <div class="sidebar-shortcuts-large">
                            <button class="btn btn-succes">
                                <i class="ace-icon fa fa-signal"></i>
                            </button>
                            <button class="btn btn-info">
                                <i class="ace-icon fa fa-pencil"></i>
                            </button>
                            <button class="btn btn-warning">
                                <i class="ace-icon fa fa-users"></i>
                            </button>
                            <button class="btn btn-danger">
                                <i class="ace-icon fa fa-cogs"></i>
                            </button>

                        </div>
                        <div class="sidebar-shorcuts-mini">
                            <span class="btn btn-success"></span> <span class="btn btn-info"></span>
                            <span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
                        </div>
                    </div>
                    <ul class="nav nav-list">
                        <li><a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-list"></i> <span
                                    class="menu-text"></span>
                                Quản lí tài khoản<b class="arrow fa fa-angle-down"></b>
                            </a> <b class="arrow"></b>
                            <ul class="submenu">
                                <li><a href='<c:url value ="/admin-new"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS bài viết
                                    </a> <b class="arrow"></b></li>
                                <li><a href='<c:url value ="/admin-user"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS tài khoản
                                    </a> <b class="arrow"></b></li>
                                <li><a href='<c:url value ="/admin-group"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS nhóm quyền
                                    </a> <b class="arrow"></b></li>

                                <li><a href='<c:url value ="/admin-function"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS chi tiết nhóm quyền
                                    </a> <b class="arrow"></b></li>
                            </ul>
                        </li>
                    </ul>
                    <div class="sidebar-toggle sidebar-collapse">
                        <i class="ace-icon fa fa-angle-double-left ace-save-state"
                            data-icon="ace-icon fa fa-angle-double-left"
                            data-icon2="ace-icon fa fa-angle-double-right"></i>
                    </div>

                </div>
                <div class="main-content">
                    <div class="main-content-inner">
                        <div class="breadcrumbs" id="breadcrumbs">
                            <script type="text/javascript">
                                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
                            </script>
                            <ul class="breadcrumb">
                                <li>
                                    <i class="ace-icon fa fa-home home-icon"></i>
                                    <a href="/admin-home">Trang chủ</a>
                                </li>
                                <li class="active">Chỉnh sửa tài khoản</li>
                            </ul>
                        </div>
                        <div class="page-content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <c:if test="${not empty messageResponse}">
                                        <div class="alert alert-${alert}">
                                            ${messageResponse}
                                        </div>
                                    </c:if>
                                    <form id="formSubmit">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Username</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="username" name="username"
                                                    value="${users.username}" />
                                            </div>
                                        </div>
                                        <br />
                                        <br />
                                        <!-- <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Password</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="password" name="password"
                                                    value="${users.password}" />
                                            </div>
                                        </div> -->
                                        <!-- <br /> -->
                                        <!-- <br /> -->
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Tên</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="name" name="name"
                                                    value="${users.name}" />
                                            </div>
                                        </div>
                                        <br />
                                        <br />
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Email</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="email" name="email"
                                                    value="${users.email}" />
                                            </div>
                                        </div>
                                        <br />
                                        <br />
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Số điện thoại</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="phone" name="phone"
                                                    value="${users.phone}" />
                                            </div>
                                        </div>
                                        <br />
                                        <br />
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Nhóm quyền</label>
                                            <div class="col-sm-9">
                                                <c:forEach var="item" items="${groups}">
                                                    <input id="${item}" type="checkbox" name="groupName" value="${item}"
                                                        <c:forEach var="item1" items="${userGroupNames}">
                                                    <c:if test="${item.contains(item1) == true}">
                                                        checked="checked"
                                                    </c:if>
                                                </c:forEach>>${item}<br />
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <br />
                                        <br />
                                        <div class="form-group">
                                            <div class="col-sm-12">
                                                <c:if test="${not empty users.id}">
                                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                                        value="Cập nhật tài khoản" id="btnAddOrUpdateUser" />
                                                </c:if>
                                                <c:if test="${empty users.id}">
                                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                                        value="Thêm tài khoản" id="btnAddOrUpdateUser" />
                                                </c:if>
                                            </div>
                                        </div>

                                        <input type="hidden" value="${users.id}" id="id" name="id" />

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer">
                    <div class="footer-inner">
                        <div class="footer-content">
                            <span class="action-buttons">
                                <a href="#">
                                    <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                                </a>

                                <a href="#">
                                    <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                                </a>

                                <a href="#">
                                    <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                                </a>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
        <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
        <script>
            $('#btnAddOrUpdateUser').click(function (e) {
                e.preventDefault();
                // var data = {};
                var formData = $('#formSubmit').serializeArray();
                // $.each(formData, function (i, v) {
                //     data["" + v.name + ""] = v.value;
                // });
                var id = $('#id').val();
                if (id == "") {
                    addUser(formData);
                } else {
                    updateUser(formData);
                }
            });
            function addUser(data) {
                var username = "";
                var name = "";
                var email = "";
                var phone = "";
                var gr = [];
                var id;
                data.forEach(element => {
                    if (element.name == "username")
                        username = element.value;
                    if (element.name == "name")
                        name = element.value;
                    if (element.name == "email")
                        email = element.value;
                    if (element.name == "phone")
                        phone = element.value;
                    if (element.name == "groupName")
                        gr.push(element.value);
                    if (element.name == "id")
                        id = element.value;
                });
                sendDta = {
                    username: username,
                    name: name,
                    email: email,
                    phone: phone,
                    groupName: gr,
                    id: id
                };
                $.ajax({
                    url: '/api-admin-user',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(sendDta),
                    dataType: 'json',
                    success: function (result) {
                        window.location.href = "/admin-addOrUpdateUser?id=" + result.id + "&message=insert_success";
                    },
                    error: function (error) {
                        window.location.href = "/admin-user?message=error_system";
                    }
                });
            }
            function updateUser(data) {
                var username = "";
                var name = "";
                var email = "";
                var phone = "";
                var gr = [];
                var id;
                data.forEach(element => {
                    if (element.name == "username")
                        username = element.value;
                    if (element.name == "name")
                        name = element.value;
                    if (element.name == "email")
                        email = element.value;
                    if (element.name == "phone")
                        phone = element.value;
                    if (element.name == "groupName")
                        gr.push(element.value);
                    if (element.name == "id")
                        id = element.value;
                });
                sendDta = {
                    username: username,
                    name: name,
                    email: email,
                    phone: phone,
                    groupName: gr,
                    id: id
                };
                $.ajax({
                    url: '/api-admin-user',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(sendDta),
                    // data: JSON.stringify(data),  
                    dataType: 'json',
                    success: function (result) {
                        window.location.href = "/admin-addOrUpdateUser?id=" + result.id + "&message=update_success";
                    },
                    error: function (error) {

                        window.location.href = "/admin-user?message=error_system";
                    }
                });
            }
        </script>

        </html>