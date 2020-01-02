<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>easyui</title>
		<style type="text/css">
			.center {
				margin: 0 auto;
				padding: 20px 0;
			}
		</style>
		<script src="js/classesListen.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
	<div id="tb"
		style="padding: 5px; height: 3%; color: #44444; font-size: 12px;">

		班级名称：<input type="text" id="search_classesName" class="easyui-textbox" />&nbsp;&nbsp;

		<a href="javascript:query()" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">查询</a>
	</div>
	<div style="height: 95.5%;">
		<table id="dg"></table>
	</div>
		<table id="dg"></table>
		<div id="dd" class="easyui-dialog" title="编辑窗体" style="width:400px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,buttons:'#bb'">
			<form id="ff" method="post">
				<input type="hidden" name="classesId" id="classesId" value="0" />
				<table class="center">
					<tr>
						<td>试听班级名称:</td>
						<td><input class="easyui-textbox" type="text" id="classesName" name="classesName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>试听专业:</td>
						<td>
							<input type="text" name="majorId" class="easyui-combobox" data-options="required:true,valueField:'id',textField:'name',url:'major/queryAll'"></select>
						</td>
					</tr>
					<tr>
					<td>班主任编号：</td>
					<td><input type="text" name="managerId" class="easyui-textbox"
						data-options="required:true"></td>
				</tr>
					<tr>
						<td>代课老师:</td>
						<td>
							<input type="text" name="teacherId" class="easyui-combobox" data-options="required:true,valueField:'teacherId',textField:'teacherName',url:'teacher/queryAll'"></select>
						</td>
					</tr>
					<tr>
						<td>教室名称:</td>
						<td><input class="easyui-textbox" type="text" id="classesRoom" name="classesRoom" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>试听开始时间:</td>
						<td><input class="easyui-datebox" type="date" id="beginDate" name="beginDate" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>试听结束时间:</td>
						<td><input class="easyui-datebox" type="date" id="endDate" name="endDate" data-options="required:true" /></td>
					</tr>
				</table>
				<div id="bb">
					<a href="#" id="zz" class="easyui-linkbutton" data="zz">保存</a>
					<a href="#" id="dialog_close" class="easyui-linkbutton">关闭</a>
				</div>
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