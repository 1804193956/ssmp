var title;
var url;
$(function() {
	$("#dg").datagrid({
		idField: "id",
		url: "teacher/queryByPage",
		fitColumns: true,
		fit: true,
		columns:[[  
			{field:'',checkbox:true},  
	        {field:'teacherName',title:'教师姓名',width:100,align:'center'},    
	        {field:'teacherSex',title:'性别',width:50,align:'center',formatter: function(value,row,index){
	        	if (value==1){
	        		return "男";
	        	} else {
	        		return "女";
	        	}
	        }
	        },
	        {field:'teacherPhone',title:'联系电话',width:100,align:'center'},
	        {field:'teacherAddress',title:'联系地址',width:100,align:'center'},
	        {field:'teacherEduLevel',title:'教师学历',width:50,align:'center'},
	        {field:'teacherSkill',title:'教师职称',width:100,align:'center'},
	        {field:'teacherSchoolName',title:'毕业学校名称',width:100,align:'center'},
	        {field:'teacherMajorName',title:'毕业专业名称',width:100,align:'center'},
	        {field:'teacherLeaveSchoolDate',title:'毕业日期',width:100,align:'center'},
	        {field:'teacherJob',title:'工作职位',width:100,align:'center'},
	        {field:'teacherEntryDate',title:'入职日期',width:100,align:'center'},
	        {field:'teacherEndDate',title:'离职日期',width:100,align:'center'},
	        {field:'teacherStatue',title:'状态',width:100,align:'center',formatter: function(value,row,index){
	        	if (value==1){
	        		return "在职";
	        	} else {
	        		return "离职";
	        	}
	        }},
	        {field:'teacherPic',title:'头像',width:100,align:'center'},
	        {field:'createTime',title:'创建时间',width:150,align:'center'}
    	]],
		pagination: true,
		pageSize: 20,
		scrollbarSize: 0,
		onLoadSuccess: function(data){                    
	        //如果没有数据  
	       if(data.rows.length==0){  
	           var columnLength = $("#dg").datagrid('getColumnFields').length; // 获取表格列数  
	           var body = $(this).data().datagrid.dc.body2;  
	           body.find('table tbody').append('<tr><td width="'+body.width()+'" style="height: 25px; padding:10px;text-align: center;"  colspan='+columnLength+'>没有任何结果数据显示！</td></tr>');  
	       }
	    },
		toolbar: [{
			text: "新增",
			iconCls: 'icon-add',
			handler: function() {
				title = "新增";
				url = "add";
				//重置form表单数据
				$("#ff").form("clear");
				openDialog();
			}
		}, '-', {
			text: "修改",
			iconCls: 'icon-edit',
			handler: function() {
				title = "修改";
				url = "update";
				updateDialog();
			}
		}, '-', {
			text: "删除",
			iconCls: 'icon-remove',
			handler: function() {
				deleteStudent();
			}
		}, '-', {
			text: "导出全部",
			iconCls: 'icon-undo',
			handler: function() {
				location.href = "teacher/downloadAll";
			}
		}, '-', {
			text: "导出查询全部",
			iconCls: 'icon-undo',
			handler: function() {
				var map = $("#dg").datagrid('getData').rows;
				var ids = "";
				for(var i=0;i<map.length;i++){
					ids += map[i].id + ",";
				}
				ids = ids.substring(0, ids.length - 1);
				location.href = "teacher/downloadPart?ids="+ids;
			}
		}, '-', {
			text: "导入",
			iconCls: 'icon-redo',
			handler: function() {
				$("#importExcel").dialog({
					closed: false,
					title: title
				});
				$("#uploadExcel").form({
					type: 'post',
					url: 'teacher/addMore',
					dataType: "json",
					onSubmit: function() {
						var fileName = $('#excel').filebox('getValue');
						//对文件格式进行校验  
						var d1 = /\.[^\.]+$/.exec(fileName);
						if(fileName == "") {
							$.messager.alert('Excel批量用户导入', '请选择将要上传的文件!');
							return false;
						} else if(d1 != ".xls") {
							$.messager.alert('提示', '请选择xls格式文件！', 'info');
							return false;
						}
						$("#booten").linkbutton('disable');
						return true;
					},
					success: function(result) {
						//把服务器后台返回的json格式字符串转成json对象
						var data = eval("(" + result + ")");
						$.messager.alert("消息框", data.msg, "info");
						if(data.statue == 0) { //数据保存成功
							//关闭对话框
							$("#dd").dialog("close");
							//刷新列表
							$("#dg").datagrid("reload");
						}
					}
				});

			}
		}, '-', {
			text: "模板下载",
			iconCls: 'icon-undo',
			handler: function() {
				location.href = "teacher/downloadMode?fileName=教师模板.xls";
			}
		}]
	});
	$("#booten").click(function() {
		$("#uploadExcel").form('submit');
		$("#importExcel").dialog("close");
	});
});
function query(){
	var teacherName = $("#search_teacherName").val();
	var teacherJob = $("#search_teacherJob").val();
	var param = {"teacherName":teacherName,"teacherJob":teacherJob};
	$("#dg").datagrid('load',param);
}
//打开对话框
function openDialog() {
	$("#dd").dialog({
		closed: false,
		title: title,
		buttons: [{
			text: '保存',
			iconCls: "icon-save",
			handler: function() {
				saveStudent();
			}
		}, {
			text: '关闭',
			iconCls: "icon-cancel",
			handler: function() {
				//关闭对话框
				$("#dd").dialog("close");
			}
		}]
	});
}

function updateDialog() {
	var array = $("#dg").datagrid("getSelections");
	if(array.length != 1) {
		$.messager.alert("提示框", "修改只能选择一条数据", "warning");
		return;
	}
	//加载选择的数据填充到form表单
	$('#ff').form('load', array[0]);
	openDialog();
}
//保存学生信息
function saveStudent() {
	$('#ff').form('submit', {
		url: "teacher/" + url,
		onSubmit: function() {
			return $('#ff').form('validate');
		},
		success: function(result) {
			//把服务器后台返回的json格式字符串转成json对象
			var data = eval("(" + result + ")");
			$.messager.alert("消息框", data.msg, "info");
			if(data.statue == 0) { //数据保存成功
				//关闭对话框
				$("#dd").dialog("close");
				//刷新列表
				$("#dg").datagrid("reload");
			}
		}
	});
}
//删除学生
function deleteStudent() {
	var array = $("#dg").datagrid("getSelections");
	if(array.length == 0) {
		$.messager.alert("提示框", "请选择要删除的数据", "warning");
		return;
	}
	$.messager.confirm("确认框", "您确认要删除这" + array.length + "条数据吗？", function(r) {
		if(r) { //点“确定”按钮
			var ids = "";
			for(var i = 0; i < array.length; i++) {
				ids += array[i].teacherId + ",";
			}
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				type: "post",
				url: "teacher/deleteMore",
				data: "ids=" + ids,
				dataType: "json",
				success: function(result) {
					$.messager.alert("消息框", result.msg, "info");
					if(result.statue == 0) { //数据删除成功
						//清除选中的记录行
						$("#dg").datagrid("clearSelections");
						//刷新列表
						$("#dg").datagrid("reload");
					}
				}
			});
		}
	});
}