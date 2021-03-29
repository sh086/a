<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="title" type="java.lang.String" required="false" description="模态框的标题" %>
<%@ attribute name="message" type="java.lang.String" required="false" description="模态框的消息" %>

<script>
    var Modal = function (){
        return{
            showFail: function (message){
                $("#modal-title").html("操作失败");
                $("#btnModalOk").unbind("click")
                $("#btnModalOk").bind("click",function (){
                    $("#modal-default").modal("hide")
                })
                $("#modal-message").html(message)
                $("#modal-default").modal("show")
            },
            showSuccess: function (message){
                $("#modal-title").html("操作成功");
                $("#btnModalOk").unbind("click")
                $("#btnModalOk").bind("click",function (){
                    $("#modal-default").modal("hide");
                    window.location.reload();
                })
                $("#modal-message").html(message)
                $("#modal-default").modal("show")

            },
            bindCancel: function (message){
                $("#modal-title").html("提示");
                $("#modal-message").html(message);
                $("#btnModalOk").unbind("click");
                $("#btnModalOk").bind("click",function (){
                    $("#modal-default").modal("hide")
                });
                $("#modal-default").modal("show");
            },
            bindOk: function (url,json,message){
                $("#modal-title").html("提示");
                $("#modal-message").html(message);
                $("#btnModalOk").bind("click",function (){
                    setTimeout(function () {
                        Request.post(url,json);
                    },500);
                });
                $("#modal-default").modal("show");
            },
        }
    }();
</script>

<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="modal-title" class="modal-title">${title}</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message">${message}</p>
            </div>
            <div class="modal-footer">
                <button id="btnModalOk" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
