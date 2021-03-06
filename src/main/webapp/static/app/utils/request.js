var Request = function () {
    return {
        post: function (url,json) {
            $.ajax({
                "url" : url,
                "type" : "POST",
                "data" : json,
                //设置同步执行，默认是异步（true）
                //"async" :false,
                "dataType" : "JSON",
                "success" : function (data) {
                    if(data.status === true){
                       Modal.showSuccess(data.messages);
                    }else {
                       Modal.showFail(data.messages);
                    }
                }
            })
        },
        showDetailPage: function (url,title) {
            $.ajax({
                "url" : url,
                "type" : "get",
                "dataType" : "html",
                "success" : function (data) {
                    Detail.showDetailPage(title,data);
                }
            })
        },
    }
}();