var User = function () {

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function () {
        //将选中的元素的ID放入到数组中
        var checkbox = Icheck.handleCheckId();
        if(checkbox.length === 0){
            Modal.bindCancel("请选择需要删除的信息！");
        }else {
            Modal.bindOk(Api.deleteMulti,{"ids": checkbox.toString()},"确认删除数据项吗？！")
        }
    };

    /**
     * 表格分页
     */
    var handlerPage = function () {
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
            {"data": "updateTime"},
            {
                "data": function (row, type, val, meta) {
                    return '<button type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</button>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];
        DataTableUtils.page(Api.page, _columns)
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
        console.log(param)
        DataTableUtils.search(param);
    };

    return {
        /** 批量删除 */
        deleteMulti: function () {
            handlerDeleteMulti();
        },

        /** 表格分页 */
        handlerPage: function () {
            handlerPage();
        },

        /** 分页查询 */
        handlerPageSearch: function () {
            handlerPageSearch();
        }
    }
}();