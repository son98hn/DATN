<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Chi tiết nhóm quyền</title>
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
                                    ${user}
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
                                Quản lí bài viết <b class="arrow fa fa-angle-down"></b>
                            </a> <b class="arrow"></b>
                            <ul class="submenu">
                                <li><a
                                        href='<c:url value ="/admin-new"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS bài viết
                                    </a> <b class="arrow"></b></li>
                                <li><a
                                        href='<c:url value ="/admin-user"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS tài khoản
                                    </a> <b class="arrow"></b></li>
                                <li><a
                                        href='<c:url value ="/admin-grouprole"/>'>
                                        <i class="menu-icon fa fa-caret-right"></i> DS nhóm quyền
                                    </a> <b class="arrow"></b></li>

                                <li><a
                                        href='<c:url value ="/admin-roledetail"/>'>
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
                    <form action="<c:url value='/admin-roledetail'/>" id="formSubmit" method="GET">
                        <div class="main-content-inner">
                            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                                <ul class="breadcrumb">
                                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="/admin-home">Trang
                                            chủ</a></li>
                                </ul>
                            </div>
                            <div class="page-content">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <c:if test="${not empty messageResponse}">
                                            <div class="alert alert-${alert}">${messageResponse}</div>
                                        </c:if>
                                        <div class="widget-box table-filter">
                                            <div class="table-btn-controls">
                                                <div class="pull-right tableTools-container">
                                                    <div class="dt-buttons btn-overlap btn-group">
                                                        <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary
														btn-bold" data-toggle="tooltip" title='Thêm chi tiết nhóm quyền' href='
														<c:url value="/admin-addOrUpdateRoleDetail" />' <c:if
                                                            test="${userRoleDetail.contains('add-roledetail') == true}">
                                                            style="visibility:
                                                            visible;"</c:if>
                                                            <c:if
                                                                test="${userRoleDetail.contains('add-roledetail') == false}">
                                                                style="visibility:
                                                                hidden;"</c:if>
                                                            > <span>
                                                                <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                            </span>
                                                        </a>
                                                        <button id="btnDelete" type="button" <c:if
                                                            test="${userRoleDetail.contains('delete-roledetail') == true}">
                                                            style="visibility:
                                                            visible;"</c:if>
                                                            <c:if
                                                                test="${userRoleDetail.contains('delete-roledetail') == false}">
                                                                style="visibility:
                                                                hidden;"</c:if>
                                                            class="dt-button buttons-html5 btn btn-white btn-primary
                                                            btn-bold"
                                                            data-toggle="tooltip" title='Xóa chi tiết nhóm quyền'>
                                                            <span> <i class="fa fa-trash-o bigger-110 pink"></i>
                                                            </span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th><input type="checkbox" id="checkAll"></th>
                                                                <th>Tên</th>
                                                                <th>Code</th>
                                                                <th>Thao tác</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="item" items="${listRoleDetail}"
                                                                varStatus="loop">
                                                                <tr>
                                                                    <td><input type="checkbox" id="checkbox_${item.id}"
                                                                            value="${item.id}"></td>
                                                                    <td>
                                                                        ${item.permission}
                                                                    </td>
                                                                    <td>
                                                                        ${item.code}
                                                                    </td>
                                                                    <td>
                                                                        <c:url var="editURL"
                                                                            value="/admin-addOrUpdateRoleDetail">

                                                                            <c:param name="id" value="${item.id}" />
                                                                        </c:url> <a
                                                                            class="btn btn-sm btn-primary btn-edit"
                                                                            <c:if
                                                                            test="${userRoleDetail.contains('edit-roledetail') == true}">
                                                                            style="visibility:
                                                                            visible;"</c:if>
                                                                            <c:if
                                                                                test="${userRoleDetail.contains('edit-roledetail') == false}">
                                                                                style="visibility:
                                                                                hidden;"</c:if>
                                                                            data-toggle="tooltip" title="Cập nhật
                                                                            chi tiết nhóm quyền"
                                                                            href='${editURL}'><i
                                                                                class="fa fa-pencil-square-o"
                                                                                aria-hidden="true"></i>
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <ul class="pagination" id="pagination"></ul>
                                                    <input type="hidden" value="" id="page" name="page" />
                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
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
            var totalPages = ${totalPage };
            var currentPage = ${page };
            var limit = 8;
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: totalPages,
                    visiblePages: 10,
                    startPage: currentPage,
                    onPageClick: function (event, page) {
                        if (currentPage != page) {
                            $('#size').val(limit);
                            $('#page').val(page);
                            $('#formSubmit').submit();
                        }
                    }
                });
            });

            $("#btnDelete").click(function () {
                var ids = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                deleteRoleDetail(ids);
            });

            function deleteRoleDetail(data) {
                $.ajax({
                    url: '/api-admin-roledetail',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    success: function (result) {
                        window.location.href = "/admin-roledetail?&message=delete_success";
                    },
                    error: function (error) {
                        window.location.href = "/admin-roledetail?&message=error_system";
                    }
                });
            }
        </script>

        </html>