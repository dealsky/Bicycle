$(document).ready(function () {



    var $bicycleTable = $('#ArbetTable').bootstrapTable({
        columns: [
            { fileid: 'bicid', checkbox: true},
            { field: 'bicnumber', title: '编号', sortable: true},
            { field: 'bictype', title: '类型', sortable: true},
            { field: 'bicrentprice', title: '价格/(小时)', sortable: true},
            { field: 'bicbuytime', title: '购买时间', sortable: true, formatter: function (value) {
                var date = new Date(value);
                return date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
            }},
            { field: 'bicborrowed', title: '借还状态', sortable: true, formatter: function (value) {
                if(value === 1) {
                    return "被借";
                } else {
                    return "没被借";
                }
            }},
            { field: 'bicborrowedcount', title: '被借次数', sortable: true}
        ],
        url: "/Bicycle/TableBicycle.do",
        pagination: true,
        sidePagination: 'client',
        pageList: [5, 10, 20, 50],
        search: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        clickToSelect: true,
        height: 450
    });

    $('#btn1').click(function () {
        //获取选中结果行,返回数组
        //返回结果中包括多选框字段 state=true
        var result = $bicycleTable.bootstrapTable('getSelections');
        console.info(result);
        var ids = [];
        for (var i = 0; i < result.length; i++) {
            var item = result[i];
            ids.push(item.bictype);
        }
        alert(ids);
    });

});