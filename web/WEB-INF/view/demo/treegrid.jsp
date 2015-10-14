<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/12
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>treegrid</title>
  <link rel="stylesheet" type="text/css" href="<%=path%>/assert/plugin/jquery-easyui-1.4.3/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="<%=path%>/assert/plugin/jquery-easyui-1.4.3/themes/icon.css">
  <script type="text/javascript" src="<%=path%>/assert/plugin/jquery-easyui-1.4.3/jquery.min.js"></script>
  <script type="text/javascript" src="<%=path%>/assert/plugin/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
</head>

<body>
<h2>Basic TreeGrid</h2>
<p>TreeGrid allows you to expand or collapse group rows.</p>
<div style="margin:20px 0;"></div>
<table id="test" title="Folder Browser" class="easyui-treegrid" style="width:700px;height:250px"
       data-options="
                url: 'getJsonTree',
                method: 'get',
                rownumbers: true,
                idField: 'id',
                treeField: 'name'
            ">
  <thead>
  <tr>
    <th data-options="field:'name'" width="220">Name</th>
  </tr>
  </thead>
</table>
</body>
</html>
