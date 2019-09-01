<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>后台管理界面</title>
<meta name="description" content="后台管理界面">
<meta name="keywords" content="后台管理界面">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				下架书籍管理 <small>数据列表</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="#">下架书籍管理</a></li>
				<li class="active">数据列表</li>
			</ol>
			</section>
		

			<!-- 正文区域 -->
			<section class="content-header"> <!-- .box-body -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">列表</h3>
				</div>

				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--工具栏-->
						<div class="box-tools pull-right">
							<div class="has-feedback">
							<form  name="index" method="post" action="${pageContext.request.contextPath }/admin/book?bookFlag=2">
                                 <div class="col-md-6 data">
                                        <select class="form-control input-sm" style="width: 100%;" name="categoryId" >
                                        <option value="">--请选择书籍类别--</option>
							            <c:forEach items="${categoryList}" var="c">
								        	<option value="${c.categoryId}"<c:if test="${c.categoryId == categoryId}"> selected</c:if>>${c.categoryName}</option>
							            </c:forEach>
     									</select>
                                  </div>
                                  <div class="col-md-4 data">
                                        <input type="text" class="form-control input-sm" value="${bookName}" name="bookName" placeholder="书籍名称" onkeydown="if(event.keyCode==32||event.keyCode==13){return false;}">
                                  </div>
								<button type="sumbit" class="btn btn-info btn-flat" style="height: 30px">GO</button>
							</form>
							</div>
						</div>
						<!--工具栏/-->
						
						<c:if test="${empty pageinfo}">
							<font color="red">${msg}</font>
						</c:if>


						<c:if test="${not empty pageinfo }">
						<!--数据列表-->
						<table id="dataList"
							class="table table-bordered table-striped table-hover dataTable">
							<thead>
								<tr>

									<th class="sorting_asc">序号</th>
									<th class="sorting_asc">书籍名称</th>
									<th class="text-center">书籍分类</th>
									<th class="image">书籍图片</th>
									<th class="number">库存量</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageinfo.list}" var="p" varStatus="status">

									<tr>
										<td>${status.count}</td>
										<td>${p.bookName}</td>
										<td>
											<c:forEach items="${categoryList}" var="c">
												<c:if test="${c.categoryId == p.categoryId}">${c.categoryName}</c:if>
											</c:forEach>
										</td>
										<td><img width="100" height="100" src="/pic/${p.bookImage}"></td>
										<td>${p.bookNum}</td>
										<td class="text-center">
											<button type="button" class="btn bg-olive btn-xs"  
											 onclick="location.href='${pageContext.request.contextPath}/admin/bookAll?bookId=${p.bookId}'">详情</button>
											 <a href="${pageContext.request.contextPath}/admin/bookUp?bookId=${p.bookId}" onclick="return confirm('您确定要上架吗？');">
												<button type="button" class="btn bg-olive btn-xs" >上架</button>
											</a>										
										</td>
									</tr>
								</c:forEach>
							</tbody>
					
						</table>
						<!--数据列表/-->


					</div>
					<!-- 数据表格 /-->


				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<div class="box-footer">
					<div class="pull-left">
						<div class="form-group form-inline">
							当前为第${pageinfo.pageNum}页，总共${pageinfo.pages} 页，共 ${pageinfo.total} 条数据。
						 每页 <select class="form-control" id="changePageSize" onchange="changePageSize()">
								<option selected="selected">${pageinfo.pageSize}</option>
								<option>2</option>
								<option>5</option>
								<option>8</option>
								<option>10</option>
								<option>15</option>
							</select> 条
						</div>
					</div>

					<div class="box-tools pull-right">
						<ul class="pagination">
							<li><a href="${pageContext.request.contextPath}/admin/book?page=1&size=${pageinfo.pageSize}&categoryId=${categoryId}&bookName=${bookName}&bookFlag=2" aria-label="Previous">首页</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/book?page=${pageinfo.pageNum-1}&size=${pageinfo.pageSize}&categoryId=${categoryId}&bookName=${bookName}&bookFlag=2">上一页</a></li>
							<c:forEach begin="1" end="${pageinfo.pages}" var="pageNum"> 
								<li><a href="${pageContext.request.contextPath}/admin/book?page=${pageNum}&size=${pageinfo.pageSize}&categoryId=${categoryId}&bookName=${bookName}&bookFlag=2">${pageNum}</a></li>
							</c:forEach>
						
							<li><a href="${pageContext.request.contextPath}/admin/book?page=${pageinfo.pageNum+1}&size=${pageinfo.pageSize}&categoryId=${categoryId}&bookName=${bookName}&bookFlag=2">下一页</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/book?page=${pageinfo.pages}&size=${pageinfo.pageSize}&categoryId=${categoryId}&bookName=${bookName}&bookFlag=2" aria-label="Next">尾页</a></li>
						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
               </c:if>
			</div>

			</section>
			<!-- 正文区域 /-->

		</div>

		<!-- 内容区域 /-->

	</div>

	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});
		
		function changePageSize() {
			//获取下拉框的值
			var pageSize = $("#changePageSize").val();

			//向服务器发送请求，改变没页显示条数
			location.href = "${pageContext.request.contextPath}/admin/book?bookFlag=2&categoryId=${categoryId}&bookName=${bookName}&page=1&size="
				+ pageSize;
		}

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("admin-index");
		});
	</script>
</body>

</html>












