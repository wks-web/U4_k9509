$(function(){
    //1.使用datagrid组件绑定数据
    $('#dg').datagrid({
        url:'getHouse',
        pagination:true,  //开启分页
        pageSize:3,  //初始化页大小
        pageList:[3,5,8,10,20],  //页大小选项
        toolbar:'#ToolBar', //指定工具栏
        columns:[[
            //添加复选框
            {checkbox:true,width:100,align:'right'},
            {field:'id',title:'编号',width:100,align:'right'},
            {field:'title',title:'标题',width:100,align:'right'},
            {field:'dname',title:'区域',width:100,align:'right'},
            {field:'sname',title:'街道',width:100,align:'right'},
            {field:'tname',title:'类型',width:100,align:'right'},
            {field:'price',title:'价格',width:100,align:'right'},
            {field:'floorage',title:'面积',width:100,align:'right'},
            {
                field: 'ispass', title: '状态', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    //返回的内容就是呈现在单元格的内容
                    //value 表示当前字段的值， row当前行的值 index表示索引
                        return value==0?"未审核":"已审核";
                }
            },
            {field: 'opt', title: '编辑|操作', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    //返回的内容就是呈现在单元格的内容
                    //value 表示当前字段的值， row当前行的值 index表示索引
                    return "<a href='javascript:goUpdate()'>详情</a> <a href='javascript:goPass("+row.id+")'>确认审核</a>"
                }
            }
        ]]
    });
});
//触发工具栏的添加事件，打开窗口
function goPass(id){
    //发送异步请求   state=1 表示审核通过
    $.post("updatePassState",{"id":id,"state":1},function (data) {
        if (data.result>0){
            $('#dg').datagrid('reload');//刷新datagrid
        }else {
            $.messager.alert("审核失败，请稍后再试","info");
        }
    },"json")
}

