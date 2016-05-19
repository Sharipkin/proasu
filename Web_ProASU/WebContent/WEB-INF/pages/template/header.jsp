<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Main Header -->
<header class="main-header">

	<!-- Logo -->
	<a href="./" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>А</b>СУ</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>АСУ</b> Перевозки</span>
	</a>

	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> </a>


		<jsp:include page="/WEB-INF/pages/menu/topmenu.jsp"/>

		<!--  div class="btn">
           <button type="button" class="btn btn-primary">Кандыагаш&nbsp;&nbsp;&nbsp;<i class="fa fa-flag-o"></i></button>
           <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true">
            <span class="caret"></span>
            <span class="sr-only"></span>
            </button>
            <ul class="dropdown-menu">
              <li><a href="#">Кандыагаш</a></li>
              <li><a href="#">Алга</a></li>
              <li><a href="#">Темир</a></li>
              <li><a href="#">Достык</a></li>
            </ul>
           </div>  -->


		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu">
					<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
						class="label label-success">1</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header"><b>У вас 1 сообщения</b></li>
						<li class="footer"><a href="#">Просмотреть сообщения</a></li>
					</ul>
				</li>
				<!-- /.messages-menu -->

				<!-- Notifications Menu -->
				<!--li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header"><b>У вас 10 уведомлений</b></li>
                  <li class="footer"><a href="#">Просмотреть</a></li>
                </ul>
              </li-->

				<!-- Tasks Menu -->
				<li class="dropdown tasks-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span
						class="label label-danger">4</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header"><b>4 поездов в подходе</b></li>
						<li class="footer"><a href="#">Перейти в подход</a></li>
					</ul>
				</li>
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="framework/dist/img/ktz.jpg" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">Работник станции</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="framework/dist/img/ktz.jpg"
							class="img-circle" alt="User Image">
							<p>
								<%= request.getRemoteUser() %>
							</p></li>
						<li class="user-footer">
							<div class="pull-right">
								<a href="logout" class="btn btn-danger btn-flat">Выход</a>
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>
	</nav>
</header>