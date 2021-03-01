var APP = function () {

    return {
        deleteMulti: function () {
            //将选中的元素的ID放入到数组中
            var checkbox = Icheck.handleCheckId();
            if(checkbox.length === 0){
                Modal.bindCancel("请选择需要删除的信息！");
            }else {
                Modal.bindOk('/user/delete',{"ids": checkbox.toString()},"确认删除数据项吗？！")
            }
        },
    }
}();