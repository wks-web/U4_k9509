﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript" type="text/javascript">
  $(function () {//加载
    //1.发送异步请求获取类型，进行加载
    $.post("getTypeData",null,function (data) {
      //加载类型
      for (var i=0;i<data.length;i++){
        //创建option
        var optionon=$("<option value="+data[i].id+">"+data[i].name+"</option>");
        //将option添加到下拉列表
        $("#typeId").append(optionon);
      }
      //设置类型的选中项
      $("#typeId").val(${house.typeId});
    },"json");
  //1.发送异步请求获取类型，进行加载
    $.post("getAllDistrictData",null,function (data) {
      //加载类型
      for (var i=0;i<data.length;i++){
        //创建option
        var optionon=$("<option value="+data[i].id+">"+data[i].name+"</option>")
        //将option添加到下拉列表
        $("#district_id").append(optionon)
      }
      $("#district_id").val(${house.districtid})
    },"json")
    //二级联动给区域下拉列拉添加选项改变事件
    $("#district_id").change(function () {
      //取当前区域选项的id
      var did=$(this).val();
      //清空原有选项
      $("#street_id>option:gt(0)").remove();
    //发异步请求加载街道
    $.post("getStreetByDistrict",{"did":did},function (data) {
      //加载类型
      for (var i=0;i<data.length;i++){
        //创建option
        var optionon1=$("<option value="+data[i].id+">"+data[i].name+"</option>");
        //将option添加到下拉列表
        $("#street_id").append(optionon1)
      }
      $("#street_id").val(${house.streetId})
    },"json")
  })
  })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../admin/images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>修改房屋信息</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action enctype="multipart/form-data"
action="upHouse">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
<%--    修改传递编号--%>
    <input type="hidden" name="id" value="${house.id}">
<%--        修改传递原图路径--%>
  <input type="hidden" name="oldPicPath" value="${house.path}">
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId id="typeId"><OPTION value="">请选择</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value="<f:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区： <SELECT class=text id="district_id" name=district_id>
      <option value="">请选择</option>
    </SELECT>
       街：  <SELECT class=text name=did id="street_id">
        <OPTION  value="">请选择</OPTION>
      </SELECT> </TD></TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description></TEXTAREA></TD></TR>
  <TR>
    <TD class=field>图片：</TD>
    <TD><img src="//localhost:80/${house.path}" height="100" width="100" ><input type="file" name="pf"></TD>
  </TR>
  </TBODY></TABLE>
<DIV class=buttons><INPUT value=立即发布 type="submit">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
