var title;
var url;
$(function() {
	$("#dg").datagrid({
		idField: "id",
		url: "roomFeeStudent/queryByPage",
		fitColumns: true,
		fit: true,
		columns:[[  
			{field:'',checkbox:true},  
	        {field:'roomName',title:'房间名称',width:100,align:'center'},    
	        {field:'studentName',title:'学生',width:100,align:'center'},    
	        {field:'useWater',title:'水费',width:50,align:'center'},
	        {field:'useElectricity',title:'电费',width:50,align:'center'},
	        {field:'roomFee',title:'物业费',width:100,align:'center'},
	        {field:'totalFee',title:'总费用',width:100,align:'center'},
	        {field:'createDate',title:'费用产生日期',width:100,align:'center'},
	        {field:'createTime',title:'创建时间',width:150,align:'center'}
    	]],
		pagination: true,
		pageSize: 20,
		scrollbarSize: 0,
		toolbar: [{
			text: "新增",
			iconCls: 'icon-add',
			handler: function() {
				title = "新增";
				url = "add";
				//重置form表单数据
				$("#ff").form("reset");
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
				location.href = "roomFeeStudent/downloadAll";
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
				location.href = "roomFeeStudent/downloadPart?ids="+ids;
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
					url: 'roomFeeStudent/addMore',
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
				location.href = "roomFeeStudent/downloadMode?fileName=学生宿舍缴费模板.xls";
			}
		}]
	});
	$("#booten").click(function() {
		$("#uploadExcel").form('submit');
		$("#importExcel").dialog("close");
	});
});
//打开对话框
function openDialog() {
	getStudnet();
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
		url: "roomFeeStudent/" + url,
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
				ids += array[i].id + ",";
			}
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				type: "post",
				url: "roomFeeStudent/deleteMore",
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
function getStudnet(){
	$('#student').combogrid({    
	    panelWidth:282,    
	    value:'',
	    idField:'id',    
	    textField:'name',    
	    url:'studentStudy/queryAll',
	    mode:'remote',
	    columns:[[    
	        {field:'name',title:'姓名',width:80,align:'center'},    
	        {field:'sex',title:'性别',width:50,align:'center',formatter: function(value,row,index){
				if (value==1){
					return "男";
				} else {
					return "女";
				}
			}},
	        {field:'phone',title:'联系电话',width:150,align:'center'}
	    ]]    
	});  
}
