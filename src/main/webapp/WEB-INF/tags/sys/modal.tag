<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    var Modal = function (){
        return{
            show: function () {
                $("#modal-default").modal("show")
            },
            setMessage: function (message){
                $("#modal-message").html(message)
            },
            fail: function (message){
                $("#btnModalOk").unbind("click")
                $("#btnModalOk").bind("click",function (){
                    $("#modal-default").modal("hide")
                })
                $("#modal-message").html(message)
                $("#modal-default").modal("show")
            },
            bindCancel: function (){
                $("#btnModalOk").unbind("click")
                $("#btnModalOk").bind("click",function (){
                    $("#modal-default").modal("hide")
                })
            },
            bingOk: function (url,json){
                $("#btnModalOk").bind("click",function (){
                    setTimeout(function () {
                       Request.post(url,json);
                    },500);
                })
            }
        }
    }();
</script>

<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message"></p>
            </div>
            <div class="modal-footer">
                <button id="btnModalOk" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
