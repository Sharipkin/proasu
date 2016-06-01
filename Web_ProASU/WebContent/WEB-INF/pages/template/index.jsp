<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--Главная форма-->
<html>
<head>
<title>Добро пожаловать в АСУ-Перевозки</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/bootstrap/css/bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/font-awesome/css/font-awesome.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/framework/jQuery-contextMenu/jquery.contextMenu.css">
	
<link rel="stylesheet" href="${pageContext.request.contextPath }/framework/css/user_style.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!--Шапка и меню-->
	<div class="wrapper">


		<jsp:include page="/WEB-INF/pages/template/header.jsp" />

		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<ul class="sidebar-menu">
					<!-- Optionally, you can add icons to the links -->

					<jsp:include page="/WEB-INF/pages/menu/leftmenu.jsp" />

				</ul>
				<!-- /.sidebar-menu -->

				<!-- Sidebar Menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					
				</h1>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">	
					<jsp:include page="${param.content}.jsp" />					
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->

			<!-- Your Page Content Here -->

		</div>
		<!-- /.content-wrapper -->
		<!-- Main Footer -->
		<jsp:include page="/WEB-INF/pages/template/footer.jsp" />
		<!-- Control Sidebar -->
		<jsp:include page="/WEB-INF/pages/menu/controlsidebar.jsp" />

	</div>

	<jsp:include page="/WEB-INF/pages/workstation/prib/prib.jsp" />

	<!-- jQuery 2.1.4 -->
	<script src="framework/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="framework/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="framework/dist/js/app.min.js"></script>

	<!-- jQuery-contextMenu -->
	<script src="framework/jQuery-contextMenu/jquery.contextMenu.js"></script>
	<script src="framework/jQuery-contextMenu/contextMenu.js"></script>


	<script>
/*      $(document).ready(function () {
      $('ul.treeview-menu li.puti a').on("click", function(e){
        var child_li_arr = $(this).next();
        if ($(child_li_arr).find('li.active').length > 0) {
          $(child_li_arr).find('li').has('ul').removeClass('active');
          $(child_li_arr).find('li').find('ul').removeClass('menu-open').css('display','none');
          return e.preventDefault();
        }
        setTimeout(
          function(child_li_arr) {
            $(child_li_arr).find('li').has('ul').addClass('active');
            $(child_li_arr).find('li').find('ul').addClass('menu-open').css('display','block');
          },
          800,
          child_li_arr
        );
      });
    }); */
    
   
    </script>
    
    <script>
	$('#podhod tr').click(function() {
		//alert('#'+$(this).attr('id'));
		//alert($('#'+$(this).attr('id')+' div').attr('id'));
		//$(this).css( "background-color","red");
		$(this).addClass("selected").siblings().removeClass("selected");
		//$(this).hasClass("selected").removeClass("selected");
		//$(this).removeClass("selected");
		//$(this).toggleClass("selected");
		$('.collapse').collapse('hide');
		
		$('#d'+$(this).attr('id')).collapse('toggle');
	});
</script>

</body>

</html>