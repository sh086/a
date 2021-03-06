var User = function () {

    /**
     * 单个删除
     */
    var handlerDelete = function (id) {
        var _idArray = [];
        _idArray.push(id);
        if(_idArray.length === 0){
            Modal.bindCancel("请选择需要删除的信息！");
        }else {
            Modal.bindOk(Api.delete,{"ids": _idArray.toString()},"确认删除数据项吗？！")
        }
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function () {
        //将选中的元素的ID放入到数组中
        var checkbox = Icheck.handleCheckId();
        if(checkbox.length === 0){
            Modal.bindCancel("请选择需要删除的信息！");
        }else {
            Modal.bindOk(Api.delete,{"ids": checkbox.toString()},"确认删除数据项吗？！")
        }
    };

    /**
     * 表格分页
     */
    var handlerPageInit = function (tableId) {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "id"},
            {"data": "userName"},
            {"data": "phone"},
            {"data": "email"},
            {"data": function (row, type, val, meta) {
                    return DateTime.format(row.updateTime,"yyyy-MM-dd HH:mm:ss");
                }},
            {
                "data": function (row, type, val, meta) {
                    return '<button onclick="User.handlerShowDetail('+row.id+')" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<a type="button" href="/user/form?id='+row.id+'" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button onclick="User.handlerDelete('+row.id+')" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</a>';
                }
            }
        ];
        DataTableUtils.dataTableInit(tableId,Api.page, _columns)
    };

    /**
     * 分页查询
     */
    var handlerPageSearch = function () {
        var userName = $("#userName").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var param = {
            "userName": userName,
            "phone": phone,
            "email": email
        };
        DataTableUtils.dataTableSearch(param);
    }

    /**
     * 重置查询参数
     */
    var handlerRestSearch = function () {
        $("#userName").val("");
        $("#phone").val();
        $("#email").val();
    };

    /**
     * 查看用户明细
     */
    var handlerShowDetail = function (id) {
        Request.showDetailPage(Api.userDetail + "?id=" + id,'用户详情');
    };

    return {
        /** 批量删除 */
        handlerDelete: function (id) {
            handlerDelete(id);
        },

        /** 批量删除 */
        handlerDeleteMulti: function () {
            handlerDeleteMulti();
        },

        /** 表格初始化 */
        handlerPageInit: function (tableId) {
            handlerPageInit(tableId);
        },

        /** 分页查询 */
        handlerPageSearch: function () {
            handlerPageSearch();
        },

        /** 查看用户明细 */
        handlerRestSearch: function () {
            handlerRestSearch();
        },

        /** 重置查询参数 */
        handlerShowDetail: function (id) {
            handlerShowDetail(id);
        }
    }
}();