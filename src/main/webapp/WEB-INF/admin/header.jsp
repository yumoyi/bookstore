<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 页面头部 -->
<header class="main-header">
	<!-- Logo -->
	<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>书籍</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>书籍</b>后台管理</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
						class="user-image" alt="User Image"> <span class="hidden-xs">
					${admin.adminName}
					</span>

				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
							class="img-circle" alt="User Image"></li>

						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat" data-toggle="modal" data-target="#userDialog" onclick="selectPassword(${admin.adminId})">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="${pageContext.request.contextPath}/admin/loginout"
									class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>
<!-- 页面头部 /-->

<div class="modal fade" id="userDialog" tabindex="-1" role="dialog"
	 aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改密码</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="user_form">
					<div class="form-group">
						<div class="col-sm-10">
							<input type="hidden" class="form-control" id="admin_id" readonly="readonly" name="adminId">
						</div>
					</div>

					<div class="form-group">
						<label for="admin_name" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="admin_name" readonly="readonly" name="adminName">
						</div>
					</div>
					<div class="form-group">
						<label for="admin_password" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="admin_password" name="adminPassword">
						</div>
					</div>
					<div class="form-group">
						<label for="address_repassword" class="col-sm-2 control-label">确定密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="address_repassword" >
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updatePassword()">保存修改</button>
			</div>
		</div>
	</div>
</div>

<script>
	function selectPassword(adminId) {
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/admin/selectPassword",
			data:{"adminId":adminId},
			success:function(data) {
				$("#admin_id").val(data.adminId);
				$("#admin_name").val(data.adminName);
			}
		});
	}
	function updatePassword() {
		$.post("${pageContext.request.contextPath}/admin/updatePassword",$("#user_form").serialize(),function(data){
			// 	data 返回boolean
			if(data){
				alert("密码更新成功！");
				location.href="${pageContext.request.contextPath }/admin/loginout";
			}else{
				alert("密码更新失败！");
			}


		});
	}


</script>
