var Request = function () {
    return {
        post: function (url,json) {
            $.ajax({
                "url" : url,
                "type" : "POST",
                "data" : json,
                "dataType" : function (data) {
                    if(data.status === true){
                        window.location.reload();
                    }else {
                        Modal.fail(data.message);
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
                "dataType" : function (data) {
                    if(data.status === true){
                        window.location.reload();
                    }else {
                        Modal.fail(data.message);
                    }
                }
            })
        },
    }
}();