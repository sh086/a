var DataTableUtils = function () {

    var _dataTable;

    var handlerDataTableInit = function (tableId,url, columns) {
        return $("#" + tableId).DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function(settings) {
                Icheck.init();
            }
        });
    };

    var handlerDataTableSearch = function (param) {
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }

    return {
        /**
         * 表格初始化
         */
        dataTableInit: function (tableId,url, columns) {
            _dataTable = handlerDataTableInit(tableId,url, columns);
            return _dataTable;
        },
        /**
         * 分页查询
         */
        dataTableSearch: function (param) {
            handlerDataTableSearch(param);
        }
    }
}();