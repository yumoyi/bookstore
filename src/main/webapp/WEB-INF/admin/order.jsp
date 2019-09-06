<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                订单管理 <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">订单管理</a></li>
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

                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <form  name="index" method="post" action="${pageContext.request.contextPath }/admin/order">
                                    <div class="col-md-8 data">
                                        <input type="text" class="form-control input-sm" value="${ orderId}" name="orderId" placeholder="订单编号" onkeydown="if(event.keyCode==32||event.keyCode==13){return false;}">
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
                        <font color="red">${msg}</font>
                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>

                                <th class="sorting_asc">序号</th>
                                <th class="sorting_asc">订单编号</th>
                                <th class="text-center">订单金额</th>
                                <th class="text-center">用户名</th>
                                <th class="image">收货人</th>
                                <th class="number">订单状态</th>
                                <th class="time">订单生成时间</th>
                                <th class="text-center">订单详情</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageinfo.list}" var="p" varStatus="status">

                                <tr>
                                    <td>${status.count}</td>
                                    <td>${p.orderId}</td>
                                    <td>${p.orderTotal}</td>
                                    <td>${p.userName}</td>
                                    <td><a href="#" data-toggle="modal" data-target="#addressDialog" onclick="selectAddress(${p.orderId})">${p.addressName}</a></td>
                                    <td>
                                        <c:if test="${p.orderState==1}">未付款</c:if>
                                        <c:if test="${p.orderState==2}">
                                            <a href="${pageContext.request.contextPath}/admin/orderUpdate?orderState=3&orderId=${p.orderId}&index=1" onclick="return confirm('您确定要发货吗？');">已付款</a>
                                        </c:if>
                                        <c:if test="${p.orderState==3}">已发货</c:if>
                                        <c:if test="${p.orderState==4}">已完成</c:if>
                                    </td>
                                    <td><fmt:formatDate value="${p.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs"
                                                onclick="location.href='${pageContext.request.contextPath}/admin/orderAll?orderId=${p.orderId}&orderState=${orderState}'">订单详情</button>
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

                <div class="modal fade" id="addressDialog" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">收货人信息</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" id="address_form">
                                    <div class="form-group">
                                        <label for="address_name" class="col-sm-2 control-label">收货人</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="address_name" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="address_address" class="col-sm-2 control-label">收货地址</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="address_address" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="address_phone" class="col-sm-2 control-label">收货人电话</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="address_phone" readonly="readonly">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>


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
                            <li><a href="${pageContext.request.contextPath}/admin/order?page=1&size=${pageinfo.pageSize}&orderId=${orderId}&userName=${userName}" aria-label="Previous">首页</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/order?page=${pageinfo.pageNum-1}&size=${pageinfo.pageSize}&orderId=${orderId}&userName=${userName}">上一页</a></li>
                            <c:forEach begin="1" end="${pageinfo.pages}" var="pageNum">
                                <li><a href="${pageContext.request.contextPath}/admin/order?page=${pageNum}&size=${pageinfo.pageSize}&orderId=${orderId}&userName=${userName}">${pageNum}</a></li>
                            </c:forEach>

                            <li><a href="${pageContext.request.contextPath}/admin/order?page=${pageinfo.pageNum+1}&size=${pageinfo.pageSize}&orderId=${orderId}&userName=${userName}">下一页</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/order?page=${pageinfo.pages}&size=${pageinfo.pageSize}&orderId=${orderId}&userName=${userName}" aria-label="Next">尾页</a></li>
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
        location.href = "${pageContext.request.contextPath}/admin/order?orderId=${orderId}&userName=${userName}&page=1&size="
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

    function selectAddress(orderId) {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/admin/selectAddress",
            data:{"orderId":orderId},
            success:function(data) {
                $("#address_name").val(data.addressName);
                $("#address_address").val(data.addressAddress);
                $("#address_phone").val(data.addressPhone);
            }
        });
    }


</script>
</body>

</html>












