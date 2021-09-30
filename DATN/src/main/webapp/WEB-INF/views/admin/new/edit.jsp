<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Chỉnh sửa bài viết</title>
        <script src="<c:url value='/ckeditor/ckeditor.js'/>"></script>
        <script src="<c:url value='/ckfinder/ckfinder.js'/>"></script>
        <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
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
                            Quản lí bài viết <b class="arrow fa fa-angle-down"></b>
                        </a> <b class="arrow"></b>
                        <ul class="submenu">
                            <li><a
                                    href='<c:url value ="/admin-new"/>'>
                                    <i class="menu-icon fa fa-caret-right"></i> DS bài viết
                                </a> <b class="arrow"></b></li>
                            <li><a href='<c:url value ="/admin-user"/>'>
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
                        data-icon="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
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
                            <li class="active">Chỉnh sửa bài viết</li>
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
                                        <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" id="categoryId" name="categoryId"> 
                                                <option value="">Chọn thể loại</option>
                                                <c:forEach items="${categories}" var="category" >
                                                    <option <c:if test="${category.id == news.categoryEntity.id}">selected="selected"</c:if> value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="title" name="title" value="${news.title}"/>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>--%>
<%--                                        <div class="col-sm-9">--%>
<%--                                            <textarea rows="" cols="" id="thumbnail" name="thumbnail"--%>
<%--                                                style="width: 820px;height: 50px">${news.thumbnail}</textarea>--%>
<%--                                            <!-- <input type="file" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}" /> -->--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                    <div class="form-group row">
                                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện
                                            <span class="text-danger">*</span></label>
                                        <div class="col-sm-9">
                                            <div class="avatar">
                                                <img id="thumbnail"
                                                     src="https://yt3.ggpht.com/-f6NCDKG2Ukw/AAAAAAAAAAI/AAAAAAAAAAA/MqMm3rgmqCY/s48-c-k-no-mo-rj-c0xffffff/photo.jpg"
                                                     class="img-fluid" style="max-width: 300px; max-height: 300px;"/>
                                            </div>
                                            <div class="file-field">
                                                <p>
                                                    <strong id="Ithumbnail">Chọn ảnh</strong><br/>
                                                    <button
                                                            class="btn btn-primary btn-sm waves-effect waves-light"
                                                            type="button" value="Browse Image"
                                                            onclick="BrowseServer( 'Images:/', 'Ithumbnail' );">Browse Image
                                                    </button>
                                                </p>
                                                <input type="hidden" name="thumbnail" id="image_src"/>
                                            </div>
                                        </div>
                                    </div>
<%--                                    <br />--%>
<%--                                    <br />--%>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="shortDescription"
                                                name="shortDescription" value="${news.shortDescription}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                        <div class="col-sm-9">
                                            <textarea rows="" cols="" id="content" name="content"
                                                style="width: 820px;height: 300px">${news.content}</textarea>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <c:if test="${not empty news.id}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                                    value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>
                                            <c:if test="${empty news.id}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                                    value="Thêm bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>
                                        </div>
                                    </div>
                                    <input type="hidden" value="${news.id}" id="id" name="id" />
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
        // var editor1 = '';
        // var editor2 = '';
        // $(document).ready(function () {
        //     editor1 = CKEDITOR.replace('content');
        //     // editor2 = CKEDITOR.replace('thumbnail');
        // });

        var editor = '';
        $(document).ready(function () {
            editor = CKEDITOR.replace('content',
                {
                    filebrowserBrowseUrl: '/ckfinder/ckfinder.html',
                    filebrowserImageBrowseUrl: '/ckfinder/ckfinder.html?type=Images',
                    filebrowserFlashBrowseUrl: '/ckfinder/ckfinder.html?type=Flash',
                    filebrowserUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
                    filebrowserImageUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
                    filebrowserFlashUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
                });
        });

        /*Avatar start*/
        function BrowseServer(startupPath, functionData) {
            // You can use the "CKFinder" class to render CKFinder in a page:
            var finder = new CKFinder();

            // The path for the installation of CKFinder (default = "/ckfinder/").
            finder.basePath = '../';

            //Startup path in a form: "Type:/path/to/directory/"
            finder.startupPath = startupPath;

            // Name of a function which is called when a file is selected in CKFinder.
            finder.selectActionFunction = SetFileField;

            // Additional data to be passed to the selectActionFunction in a second argument.
            // We'll use this feature to pass the Id of a field that will be updated.
            finder.selectActionData = functionData;

            // Name of a function which is called when a thumbnail is selected in CKFinder. Preview img
            // finder.selectThumbnailActionFunction = ShowThumbnails;

            // Launch CKFinder
            finder.popup();
        }

        function SetFileField(fileUrl, data) {
            document.getElementById(data["selectActionData"]).innerHTML = this
                .getSelectedFile().name;
            document.getElementById("thumbnail").src = fileUrl;
            $('#thumbnail').val(fileUrl);
            $('#image_src').val(fileUrl);
        }

        // $('#btnCreate').click(function (e) {
        //     e.preventDefault();
        //     var data = {};
        //     var formData = $('#formSubmit').serializeArray();
        //     $.each(formData, function (i, v) {
        //         data[""+v.name+""] = v.value;
        //     });
        //     data["content"] = editor.getData();
        //     createNews(data);
        // });

        $('#btnAddOrUpdateNew').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });
            data["content"] = editor.getData();
            // data["thumbnail"] = editor2.getData();
            var id = $('#id').val();
            if (id == "") {
                addNew(data);
            } else {
                updateNew(data);
            }
        });
        function addNew(data) {
            $.ajax({
                url: '/api-admin-new',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    window.location.href = "/admin-addOrUpdateNew?id=" + result.id + "&message=insert_success";
                },
                error: function (xhr, status, error) {
                    window.location.href = "/admin-new?message=error_system";
                }
            });
        }
        function updateNew(data) {
            $.ajax({
                url: '/api-admin-new',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    window.location.href = "/admin-addOrUpdateNew?id=" + result.id + "&message=update_success";
                },
                error: function (error) {
                    window.location.href = "/admin-new?message=error_system";
                }
            });
        }
    </script>
</html>