<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17/0017
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="static/js/jquery-1.8.3.js"></script>
    <script src="static/js/jquery.easyui.min.js"></script>
<%--    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>--%>
    <script language="JavaScript" type="text/javascript">
        $(function () { //入口，加载
            //为按钮绑定事件
            $("#but").click(function () {
                //使用jquery的post发送异步请求
                // $.post("getStudent",null,function (date) {
                //     // console.log(date);
                //     //将数据拼成表格，显示
                //   var str="<table border=2><tr><td>学号</td><td>年龄</td><td>姓名</td><td>电话</td><td>操作</td></tr>";
                //   for (var i=0;i<date.length;i++){
                //         var s=date[i]
                //          str=str+"<tr><td>"+s.id+"</td><td>"+s.age+"</td><td>"+s.name+"</td><td>"+s.phone+"</td><td>"+"<input type='button' value='详细' onclick='ajax_change(this.value)'> "+"</td></tr>"
                //     }
                //     str=str+"</table>"
                //     //显示
                //     $("#show").html(str);
                // },"json")

                $('#dg').datagrid({
                    url:'showByPb',
                    striped:'true',
                    pagination:'true',
                    pageSize:3,
                    pageList:[3,5,7,10],
                    columns:[[
                        {field:'id',title:'学号',width:100},
                        {field:'age',title:'年龄',width:100},
                        {field:'name',title:'姓名',width:100,align:'right'},
                        {field:'phone',title:'电话',width:100,align:'right'},
                        {field:'score',title:'分数',width:100,align:'right'}
                    ]]
                });
            })
        })

    </script>

</head>
<body>
<input type="button" value="展示学生数据" id="but">
<%--<div id="show"></div>--%>
<%--<div id="info"></div>--%>
<table id="dg"></table>
</body>
</html>
