var Request = function () {
    return {
        post: function (url,json) {
            $.ajax({
                "url" : url,
                "type" : "POST",
                "data" : json,
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
        postSyn: function (url,json) {
            $.ajax({
                "url" : url,
                "type" : "POST",
                //设置同步执行，默认是异步
                "async" :false,
                "data" : json,
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
    }
}();