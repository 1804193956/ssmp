﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.center {
				margin: 0 auto;
				padding: 20 0;
			}
			
			* {
				padding: 0;
				margin: 0;
			}
		</style>
		<script type="text/javascript" src="js/student.js"></script>
	</head>

	<body>
		<div id="tb" style="padding:5px;height: 3%;color: #44444;font-size: 12px;">

			姓名：<input type="text" id="search_name" class="easyui-textbox" />&nbsp;&nbsp; 账号：
			<input type="text" id="search_username" class="easyui-textbox" />&nbsp;&nbsp; 性别：
			<select id="search_sex" style="height: 25px;color: #44444;font-size: 12px;">
				<option value="-1">--请选择--</option>
				<option value="1">男</option>
				<option value="0">女</option>
			</select>&nbsp;&nbsp;
			<a href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		</div>
		<div style="height: 95.5%;">
			<table id="dg"></table>
		</div>

		<div id="dd" class="easyui-dialog" title="新增" style="width:400px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">
			<form id="ff" method="post">
				<input type="hidden" name="id" value="0" />
				<table class="center">
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="name" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>账号：</td>
						<td><input type="text" name="username" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><input type="text" name="age" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							<input type="radio" name="sex" checked="checked" value="1">男
							<input type="radio" name="sex" value="0">女
						</td>
					</tr>
					<tr>
						<td>生日：</td>
						<td><input type="text" name="birthday" class="easyui-datebox" data-options="required:true,editable:false"></td>
					</tr>

				</table>
			</form>
		</div>

	</body>

</html>