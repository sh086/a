<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<head>
    <title>我的商城 | 用户管理</title>
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
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">

                    <c:if test="${saveResult != null}">
                        <div class="alert alert-${saveResult.status ==  true ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${saveResult.messages}
                        </div>
                    </c:if>

                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="user">
                           <div class="box-body">
                               <div class="row">
                                   <div class="col-xs-12 col-sm-3">
                                       <div class="form-group">
                                           <label for="userName" class="col-sm-4 control-label">姓名</label>
                                           <div class="col-sm-8">
                                               <form:input class="form-control" path="userName"  placeholder="请输入用户姓名"/>
                                           </div>
                                       </div>
                                   </div>
                                   <div class="col-xs-12 col-sm-3">
                                       <div class="form-group">
                                           <label for="phone" class="col-sm-4 control-label">电话</label>
                                           <div class="col-sm-8">
                                               <form:input class="form-control" path="phone"  placeholder="请输入电话"/>
                                           </div>
                                       </div>
                                   </div>
                                   <div class="col-xs-12 col-sm-3">
                                       <div class="form-group">
                                           <label for="email" class="col-sm-4 control-label">邮箱</label>
                                           <div class="col-sm-8">
                                               <form:input class="form-control" path="email"  placeholder="请输入邮箱"/>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               <div class="box-footer">
                                   <button type="submit" class="btn btn-info pull-right">搜索</button>
                                   <button type="reset" class="btn btn-default pull-right">重置</button>
                               </div>
                           </div>
                        </form:form>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row" style="padding-top: 10px">
                                <div class="col-xs-12" >
                                    <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a> &nbsp&nbsp&nbsp&nbsp
                                    <button onclick="APP.deleteMulti()" type="button" class="btn btn-sm btn-default"><i class="fa fa-trash-o"></i> 删除</button>&nbsp&nbsp&nbsp&nbsp
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp&nbsp&nbsp&nbsp
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp&nbsp&nbsp&nbsp
                                    <button type="button" class="btn btn-sm btn-primary"
                                            onclick="$('.box-info-search').css('display') == 'none' ?
                                                    $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')">
                                        <i class="fa fa-search"></i> 搜索
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal checkbox-master" /></th>
                                        <th>编号</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                        <tr>
                                            <td><input id="${user.id}" type="checkbox" class="minimal" /></td>
                                            <td>${user.id}</td>
                                            <td>${user.userName}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.email}</td>
                                            <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                            <td>
                                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</a>
                                                <a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>
                                                <a href="#" type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i>删除</a>
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
    <sys:modal/>

</div>
<jsp:include page="../includes/foot.jsp"/>

</body>
</html>