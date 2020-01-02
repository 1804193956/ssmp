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
		<script src="js/teacher.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
	<div id="tb" style="padding:5px;height: 3%;color: #44444;font-size: 12px;">
		 
		姓名：<input type="text" id="search_teacherName" class="easyui-textbox"/>&nbsp;&nbsp;
		老师职位：<input type="text" id="search_teacherJob" class="easyui-textbox"/>&nbsp;&nbsp;
		<a href="javascript:query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
	</div>
	<div style="height: 95.5%;">
		<table id="dg"></table>
	</div>
		<table id="dg"></table>
		<div id="dd" class="easyui-dialog" title="编辑窗体" style="width:400px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,buttons:'#bb'">
			<form id="ff" method="post">
				<input type="hidden" name="teacherId" />
				<table class="center">
					<tr>
						<td>教师姓名:</td>
						<td><input class="easyui-textbox" type="text" id="teacherName" name="teacherName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><input type="radio" id="teacherSex" name="teacherSex" value="1" checked="checked" />男
							<input type="radio" id="teacherSex" name="teacherSex" value="0" />女
						</td>
					</tr>
					<tr>
						<td>联系方式:</td>
						<td><input class="easyui-textbox" type="text" id="teacherPhone" name="teacherPhone" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>联系地址:</td>
						<td><input class="easyui-textbox" type="text" id="teacherAddress" name="teacherAddress" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>教师学历:</td>
						<td><input class="easyui-textbox" type="text" id="teacherEduLevel" name="teacherEduLevel" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>教师职称:</td>
						<td><input class="easyui-textbox" type="text" id="teacherSkill" name="teacherSkill" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>毕业学校名称:</td>
						<td><input class="easyui-textbox" type="text" id="teacherSchoolName" name="teacherSchoolName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>毕业专业名称:</td>
						<td><input class="easyui-textbox" type="text" id="teacherMajorName" name="teacherMajorName" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>毕业日期:</td>
						<td><input class="easyui-datebox" type="date" id="teacherLeaveSchoolDate" name="teacherLeaveSchoolDate" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>工作职位:</td>
						<td><input class="easyui-textbox" type="text" id="teacherJob" name="teacherJob" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>入职日期:</td>
						<td><input class="easyui-datebox" type="date" id="teacherEntryDate" name="teacherEntryDate" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>离职日期:</td>
						<td><input class="easyui-datebox" type="date" id="teacherEndDate" name="teacherEndDate" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><input type="radio" id="teacherStatue" name="teacherStatue" value="1" checked="checked" />在职
							<input type="radio" id="teacherStatue" name="teacherStatue" value="2" />离职
						</td>
					</tr>
					<tr>
						<td>头像:</td>
						<td><input class="easyui-textbox" type="text" id="teacherPic" name="teacherPic" data-options="required:true" /></td>
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