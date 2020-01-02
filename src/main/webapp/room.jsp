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
		<script src="js/room.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<table id="dg"></table>
		<div id="dd" class="easyui-dialog" title="编辑窗体" style="width:400px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,buttons:'#bb'">
			<form id="ff" method="post">
				<input type="hidden" name="roomId" value="0" />
				<table class="center">
					<tr>
						<td>房间名称:</td>
						<td><input class="easyui-textbox" type="text" id="roomName" name="roomName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>房间地址:</td>
						<td><input class="easyui-textbox" type="text" id="roomAddress" name="roomAddress" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>容纳人数:</td>
						<td><input class="easyui-textbox" type="text" id="roomTotalSize" name="roomTotalSize" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>空余床位:</td>
						<td><input class="easyui-textbox" type="text" id="roomEmptySize" name="roomEmptySize" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>住宿性别:</td>
						<td><input type="radio" id="roomPersonSex" name="roomPersonSex" value="1" checked="checked" />男
							<input type="radio" id="roomPersonSex" name="roomPersonSex" value="0" />女
						</td>
					</tr>
					<tr>
						<td>每月住宿费:</td>
						<td><input class="easyui-textbox" type="text" id="roomMoney" name="roomMoney" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>房间押金:</td>
						<td><input class="easyui-textbox" type="text" id="roomDeposit" name="roomDeposit" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>房东:</td>
						<td><input class="easyui-textbox" type="text" id="roomManager" name="roomManager" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>房东电话:</td>
						<td><input class="easyui-textbox" type="text" id="roomManagerPhone" name="roomManagerPhone" data-options="required:true" /></td>
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