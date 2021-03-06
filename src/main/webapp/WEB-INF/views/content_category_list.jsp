<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <li class="active">内容分类</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a> &nbsp&nbsp&nbsp&nbsp
                            <button onclick="" type="button" class="btn btn-sm btn-default"><i class="fa fa-trash-o"></i> 删除</button>&nbsp&nbsp&nbsp&nbsp
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp&nbsp&nbsp&nbsp
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp&nbsp&nbsp&nbsp
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id = "treeTable" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>排序</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${contentCategories}" var="record">
                                        <tr id="${record.id}" pId="${record.parentId}">
                                            <td>${record.id}</td>
                                            <td>${record.name}</td>
                                            <td>${record.sortOrder}</td>
                                            <td>
                                                <button herf="#" type="button" class="btn btn-sm btn-primary">
                                                    <i class="fa fa-edit">编辑</i> &nbsp; &nbsp; &nbsp;
                                                </button>
                                                <button type="button" class="btn btn-sm btn-danger">
                                                    <i class="fa fa-trash-o">删除</i> &nbsp; &nbsp; &nbsp;
                                                </button>
                                                <button herf="#" type="button" class="btn btn-sm btn-default">
                                                    <i class="fa fa-plus">新增下级菜单</i> &nbsp; &nbsp; &nbsp;
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
<script>

    $(function(){
        var option = {
            column: 1,
            expandLevel : 2,
        };
        $('#treeTable').treeTable(option);
    });
</script>
</body>
</html>