<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<script type="text/javascript">
			$(function() {
				$('#menu').tree({
					url: 'menu.json',
					animate: true,
					lines: true,
					onClick: function(node) {
						var title = node.text;
						var url = node.attributes.url;
						// 在用户点击的时候提示
						if($('#tt').tabs('exists', title)) {
							$('#tt').tabs('select', title);
						} else {
							$('#tt').tabs('add', {
								title: title,
								content: "<iframe src='" + url + "' style='width: 100%;height: 100%' frameborder='0'></iframe>",
								closable: true
							});
						}
					}
				});

			});
		</script>
	</head>

	<body>
		<div id="cc" class="easyui-layout" fit="true">
			<div data-options="region:'north'" style="height:100px;">
				<h1>XXX后台管理系统</h1>

			</div>
			<div data-options="region:'west'" style="width:150px;">

				<div id="aa" class="easyui-accordion" fit="true">
					<div title="系统管理">
						<ul id="menu"></ul>
					</div>
					<div title="功能管理">

					</div>
					<div title="菜单管理">

					</div>
					<div title="个性化管理">

					</div>
				</div>

			</div>
			<div data-options="region:'center',border:false">
				<div id="tt" class="easyui-tabs" fit="true" border="false">
					<div title="主页面">
						<h3>欢迎进入经分系统管理后台</h3>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>