<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<script type="text/javascript" src="js/major.js"></script>
	</head>

	<body>
		<div id="tb" style="padding:5px;height: 3%;color: #44444;font-size: 12px;">

			专业名称：<input type="text" id="search_name" class="easyui-textbox" />&nbsp;&nbsp;

			<a href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		</div>
		<div style="height: 95.5%;">
			<table id="dg"></table>
		</div>

		<div id="dd" class="easyui-dialog" title="新增" style="width:400px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">
			<form id="ff" method="post">
				<input type="hidden" name="id" />
				<table class="center">
					<tr>
						<td>专业名称：</td>
						<td><input type="text" name="name" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>专业负责人：</td>
						<td><input type="text" name="manager" class="easyui-textbox" data-options="required:true"></td>
					</tr>
					<tr>
						<td>创建日期：</td>
						<td><input type="text" name="beginDate" class="easyui-datebox" data-options="required:true,editable:false"></td>
					</tr>
					<tr>
						<td>专业描述：</td>
						<td><textarea rows="4" cols="30" name="remark"></textarea></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 配置导入框 -->
		<div id="importExcel" class="easyui-dialog" title="导入excel文件" style="width: 400px; height: 150px;padding-top: 20px" data-options="resizable:false,modal:true,closed:true">
			<center>
				<form id="uploadExcel" method="post" action="major/addMore" enctype="multipart/form-data">
					选择文件：　<input id="excel" name="excel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">
				</form>
				<div style="text-align: center; padding: 5px 0;">
					<a id="booten" href="javascript:void(0)" class="easyui-linkbutton" style="width: 80px">导入</a>
				</div>
			</center>
		</div>

	</body>

</html>