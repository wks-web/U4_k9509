<%@page pageEncoding="utf-8" contentType="text/html; utf-8"  language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>街道管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js" language="JavaScript" type="text/javascript"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js" language="JavaScript" type="text/javascript"></script>

    <script language="JavaScript" type="text/javascript" src="js/house.js"></script>
</head>
<body>
<!--显示区域的表格-->
    <table id="dg"></table>

    <!—定义工具栏-->
    <div id="ToolBar">
        <div style="height: 60px;">
            <a href="javascript:goadd()" class="easyui-linkbutton"
               iconCls="icon-add" plain="true">批量审批</a>
        </div>
    </div>

</body>
</html>