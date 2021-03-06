<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<head>
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                控制面板
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">

                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <div class="box-body">
                            <div class="row form-horizontal" >
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="userName" class="col-sm-4 control-label">姓名</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="userName"  placeholder="请输入用户姓名"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">电话</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="phone"  placeholder="请输入电话"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label">邮箱</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" id="email"  placeholder="请输入邮箱"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button onclick="User.handlerPageSearch()" class="btn btn-info pull-right">搜索</button>
                                <button onclick="User.handlerRestSearch()"  class="btn btn-default pull-right">重置</button>
                            </div>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a> &nbsp&nbsp&nbsp&nbsp
                            <button onclick="" type="button" class="btn btn-sm btn-default"><i class="fa fa-trash-o"></i> 删除</button>&nbsp&nbsp&nbsp&nbsp
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp&nbsp&nbsp&nbsp
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp&nbsp&nbsp&nbsp
                            <button type="button" class="btn btn-sm btn-primary"
                                    onclick="$('.box-info-search').css('display') == 'none' ?
                                                    $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')">
                                <i class="fa fa-search"></i> 搜索
                            </button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id = "dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal checkbox-master" /></th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>链接</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${contents}" var="record">
                                    <tr id="${record.id}">
                                        <td><input type="checkbox" class="minimal" /></td>
                                        <td>${record.id}</td>
                                        <td>${record.title}</td>
                                        <td>${record.subTitle}</td>
                                        <td>${record.titleDesc}</td>
                                        <td>
                                            <c:if test="${record.url != null}">
                                                <a href="${record.url}">查看</a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${record.pic != null}">
                                                <a href="${record.pic}">查看</a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${record.pic2 != null}">
                                                <a href="${record.pic2}">查看</a>
                                            </c:if>
                                        </td>
                                        <td><fmt:formatDate value="${record.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td></td>
                                        <td>
                                            <button herf="#" type="button" class="btn btn-sm btn-primary">
                                                <i class="fa fa-edit">查看</i> &nbsp; &nbsp; &nbsp;
                                            </button>
                                            <button herf="#" type="button" class="btn btn-sm btn-primary">
                                                <i class="fa fa-edit">编辑</i> &nbsp; &nbsp; &nbsp;
                                            </button>
                                            <button type="button" class="btn btn-sm btn-danger">
                                                <i class="fa fa-trash-o">删除</i> &nbsp; &nbsp; &nbsp;
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp"/>

</div>
<jsp:include page="../includes/foot.jsp"/>
</body>
</html>