<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    var Detail = function (){
        return{
            showDetailPage: function (title,html){
                $("#modal-detail-title").html(title);
                $("#modal-detail-ok").unbind("click")
                $("#modal-detail-ok").bind("click",function (){
                    $("#modal-detail").modal("hide")
                })
                $("#modal-detail-body").html(html)
                $("#modal-detail").modal("show")
            },
        }
    }();
</script>

<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- 头部 -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="modal-detail-title" class="modal-title"></h4>
            </div>
            <!-- 页面 -->
            <div id ="modal-detail-body" class="modal-body"></div>
            <!-- 工具栏 -->
            <div class="modal-footer">
                <button id="modal-detail-ok" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
    <!-- /.modal-dialog -->
</div>
