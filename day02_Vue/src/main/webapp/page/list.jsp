<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script language="JavaScript" type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript" type="text/javascript">
  //实现分页导航带条件的跳转
  //pageNum表示页码
  function goPage(pageNum) {
    //设置页码
    $("#pageNum").val(pageNum);
    //提交表单
    // $("#sform").submit
    document.getElementById("sform").submit();
  }
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
      },"json")
    })
  })
</script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../admin/images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action="getBroswerHouse">
    <!--隐藏保存当前页码-->
    <input type="hidden" value="1" name="page" id="pageNum">
  <DT>
    标题:<input type="text" name="title" value="${HouseCondition.title}">
    区域:<select id="district_id" name="did"><option value="">请选择</option></select>
    街道:<select id="street_id" name="sid"><option value="">请选择</option></select>
    类型:<select id="typeId" name="tid"><option value="">请选择</option></select>
    价格:<input type="text" size="10" value="${HouseCondition.startPrice}" name="startPrice">-<input value="${HouseCondition.endPrice}" size="10"  type="text" name="endPrice">
    <input type="submit" value="搜索" name="submitz">
  </FORM>
</DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${pageInfo.list}" var="h">
  <TR>
    <TD class=house-thumb><span><A href="details.html" target="_blank"><img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.html" target="_blank">${h.title}</A></DT>
        <DD>${h.dname}-${h.sname},${h.floorage}<BR>联系方式：${h.contact} </DD></DL></TD>
    <TD class=house-type>${h.tname}</TD>
    <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD></TR>
  <TR class=odd>
    <TD class=house-thumb><span><A href="details.html" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
  </c:forEach>
  </TBODY>
</TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:goPage(1)">首页</A></LI>
  <LI><A href="javascript:goPage(${pageInfo.pageNum-1})">上一页</A></LI>
  <LI><A href="javascript:goPage(${pageInfo.pageNum+1})">下一页</A></LI>
  <LI><A href="javascript:goPage(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
