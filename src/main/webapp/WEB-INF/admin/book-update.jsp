<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

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
				书籍详情管理 <small>数据列表</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="#">书籍详情管理</a></li>
				<li class="active">数据列表</li>
			</ol>
			</section>
			<!-- 内容头部 /-->


			<!-- 正文区域 -->
			<form id="saveform" method="post" enctype="multipart/form-data">
			<section class="content-header"> <!--书籍信息-->
			
				<div class="panel panel-default">
				
					<div class="panel-heading">书籍信息</div>
					<div class="row data-type">
						<div class="col-md-2 title">书籍ID</div>
						<div class="col-md-10 data">
							<input type="text" id="bookId" class="form-control" readonly="readonly" name="bookId" value="${book.bookId}">
						</div>

						<div class="col-md-2 title">书籍名称</div>
						<div class="col-md-10 data">
							<input type="text" id="bookName" class="form-control" name="bookName" placeholder="书籍名称" value="${book.bookName}">
						</div>					

						<div class="col-md-2 title">书籍分类</div>
						<div class="col-md-10 data">
							<select class="form-control select2" style="width: 100%" name="categoryId" id="categoryId">
								<c:forEach items="${categoryList}" var="c">
									<option value="${c.categoryId}" <c:if test="${c.categoryId == book.categoryId}">selected="selected"</c:if>>${c.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						
					
						<div class="col-md-2 title">是否在架</div>
						<div class="col-md-10 data">
							<select class="form-control select2" style="width: 100%" name="bookFlag" id="bookFlag">
								<option value="2" <c:if test="${book.bookFlag==2}">selected="selected"</c:if>>未在架</option>
								
								<option value="1" <c:if test="${book.bookFlag==1}">selected="selected"</c:if>>在架</option>
							</select>
						</div>			

						<div class="col-md-2 title">书籍价格</div>
						<div class="col-md-10 data">
							<div class="input-group">
								<span class="input-group-addon">¥</span>
								<input type="text" class="form-control" id="bookPrice" name="bookPrice" placeholder="书籍价格" value="${book.bookPrice}">
							</div>
						</div>

						<div class="col-md-2 title">书籍库存量</div>
						<div class="col-md-10 data">
							<div class="input-group">
							<span class="input-group-addon">本</span>
							<input type="text" class="form-control" placeholder="书籍库存量" id="bookNum"  name="bookNum" value="${book.bookNum}">
							</div>
						</div>

						<div class="col-md-2 title">书籍照片</div>
						<div class="col-md-10 data">
					 	<c:if test="${book.bookImage!=null}"> 
								<img src="/pic/${book.bookImage}" width="100" height="100">
						</c:if>
							<input id="upload" type="file" class="form-control" name="bookImages">

						</div>  

						<div class="col-md-2 title ">书籍描述</div>
						<div class="col-md-10 data ">
							<textarea class="form-control" rows="10" placeholder="书籍描述" name="bookDesc" id="bookDesc">${book.bookDesc}</textarea>
						</div>
						<div class="box-tools text-center">
							<button type="button" class="btn bg-maroon" onclick="save()">保存</button>
							<button type="reset" class="btn bg-green">重置</button>
							<button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
				       </div>
					</div>
			
			</div>
			
			<!-- 正文区域 /-->		
			</section>
			</form>
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
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}
		
		//日期
		$(document).ready(function() {

            
            // datetime picker   
            $('#pdate').datetimepicker({
                format: "yyyy-mm-dd hh:ii:ss",
                autoclose: true,
                todayBtn: true,
                language: 'zh-CN'
            });
        });

		function save(){
			var formData = new FormData();
			var bookName = $("#bookName").val();
			var categoryId = $("#categoryId").val();
			var bookDesc = $("#bookDesc").val();
			var bookId = $("#bookId").val();
			var bookPrice = $("#bookPrice").val();
			var bookNum = $("#bookNum").val();
			var bookFlag = $("#bookFlag").val();
			formData.append("bookImages",$("#upload")[0].files[0]);
			formData.append("bookName",bookName);
			formData.append("categoryId",categoryId);
			formData.append("bookDesc",bookDesc);
			formData.append("bookId",bookId);
			formData.append("bookPrice",bookPrice);
			formData.append("bookNum",bookNum);
			formData.append("bookFlag",bookFlag);
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/bookUpdate",
				type:"POST",
				dataType:"json",
				data : formData,
				// 告诉jQuery不要去处理发送的数据，用于对data参数进行序列化处理 这里必须false
				processData : false,
				// 告诉jQuery不要去设置Content-Type请求头
				contentType : false, 
				success:function(data){
					 if(data.success){
							location.href="${pageContext.request.contextPath }/admin/book?bookFlag="+bookFlag.toString();
						 }else{
							alert(data.message); 
					 }
				}
			})
		}
		
		
	</script>


</body>

</html>