<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 导航侧栏 -->
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>${admin.adminName}</p>
							<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
						</div>
					</div>
					

					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu">
						<li class="header">菜单</li>

						<li id="admin-index">
							<a href="${pageContext.request.contextPath }/admin/main"><i class="fa fa-dashboard"></i> <span>首页</span></a>
						</li>

						<!-- 菜单 -->

						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>分类管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="${pageContext.request.contextPath}/admin/category">
										<i class="fa fa-circle-o"></i> 分类管理
									</a>
								</li>

							</ul>
						</li>
						
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>书籍管理</span>
									<span class="pull-right-container">
                    				    <i class="fa fa-angle-left pull-right"></i>
			                    	</span>
							</a>
							<ul class="treeview-menu">

								<li id="charts-chartjs">
									<a href="${pageContext.request.contextPath }/admin/book?bookFlag=1">
										<i class="fa fa-circle-o"></i> 在架书籍管理
									</a>
								</li>

								<li id="charts-morris">
									<a href="${pageContext.request.contextPath }/admin/book?bookFlag=2">
										<i class="fa fa-circle-o"></i> 未上架书籍管理
									</a>
								</li>
							</ul>
						</li>	
						
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>订单管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/order">
										<i class="fa fa-circle-o"></i> 全部订单管理
									</a>
								</li>

								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/order?orderState=1">
										<i class="fa fa-circle-o"></i> 未付款订单管理
									</a>
								</li>
								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/order?orderState=2">
										<i class="fa fa-circle-o"></i> 已付款订单管理
									</a>
								</li>

								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/order?orderState=3">
										<i class="fa fa-circle-o"></i> 已发货订单管理
									</a>
								</li>

								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/order?orderState=4">
										<i class="fa fa-circle-o"></i> 已完成订单管理
									</a>
								</li>
							</ul>
						</li>
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>用户管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="${pageContext.request.contextPath }/admin/user">
										<i class="fa fa-circle-o"></i> 用户信息管理
									</a>
								</li>
							</ul>
						</li>
						<!-- 菜单 /-->
					</ul>
				</section>
				<!-- /.sidebar -->
			</aside>
<!-- 导航侧栏 /-->