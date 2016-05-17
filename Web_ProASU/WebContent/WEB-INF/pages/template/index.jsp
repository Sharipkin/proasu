<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
Главная форма
-->
<html>
    <head>
        <title>Добро пожаловать в АСУ-Перевозки</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap/css/bootstrap.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/font-awesome/css/font-awesome.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/datatables/dataTables.bootstrap.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/dist/css/AdminLTE.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/dist/css/skins/_all-skins.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/iCheck/flat/blue.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/morris/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/datepicker/datepicker3.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/daterangepicker/daterangepicker-bs3.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
       
        <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/jQuery-contextMenu/jquery.contextMenu.css">
         
    </head>
<body class="hold-transition skin-blue sidebar-mini">
     <!--Шапка и меню-->
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">

        <!-- Logo -->
        <a href="./" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>А</b>СУ</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>АСУ</b> Перевозки</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          </a>
          
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
                <!-- Menu toggle button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">1</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header"><b>У вас 1 сообщения</b></li>
                  <li class="footer"><a href="#">Просмотреть сообщения</a></li>
                </ul>
              </li><!-- /.messages-menu -->

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
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-flag-o"></i>
                  <span class="label label-danger">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header"><b>4 поездов в подходе</b></li>
                  <li class="footer"><a href="#">Перейти в подход</a>
                  </li>
                </ul>
              </li>
              <!-- User Account Menu -->
              <li class="dropdown user user-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <!-- The user image in the navbar-->
                  <img src="framework/dist/img/ktz.jpg" class="user-image" alt="User Image">
                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                  <span class="hidden-xs">Работник станции</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- The user image in the menu -->
                  <li class="user-header">
                    <img src="framework/dist/img/ktz.jpg" class="img-circle" alt="User Image">
                    <p>
                      <%= request.getRemoteUser() %>
                    </p>
                  </li>
                  <li class="user-footer">
                    <div class="pull-right">
                      <a href="logout" class="btn btn-danger btn-flat">Выход</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

          <ul class="sidebar-menu">
            <!-- Optionally, you can add icons to the links -->
            
           <jsp:include page="/WEB-INF/pages/menu/mymenu.jsp"/>
           
           
            
            
     
          </ul><!-- /.sidebar-menu -->
           
          <!-- Sidebar Menu -->
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            ${param.title}
            <small>  </small>
          </h1>
        </section>
        
        <!-- Main content -->
        <section class="content" >        
            <div class="row">
             <div class="col-xs-12">
                <div class="box">
                  <div class="box-header"><h3 class="box-title">Кандыагаш</h3></div><!-- /.box-header -->
                   <div class="box-body">
                     <div class="table-responsive">   
                     <jsp:include page="${param.content}.jsp"/>                                            
                   </div><!--table-responsive-->
                   
                  </div><!-- /.box-body -->     
                </div><!-- /.box-->
             </div><!-- /.col -->
          </div><!-- /.row -->
       
          
        </section><!-- /.content -->

          <!-- Your Page Content Here -->
      
      </div><!-- /.content-wrapper -->

      
      
      
      <!-- Main Footer -->
      <footer class="main-footer">
          
          
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Входящии сообщения </h3>
                  <!-- tools box -->
                  <div class="pull-right box-tools">
                    <button class="btn btn-default btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
                  </div><!-- /. tools -->
                </div><!-- /.box-header -->
                <div class="box-body pad">
                  <form>
                      <textarea class="textarea" placeholder="Place some text here" style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
(:0497 BЦ RVIM 1167005 05 02 11 41 002:
  Ю1 0001 09 003 000 6669+030+6600:
  Ю2 000 .14 6669+030+6600:
  Ю1 0001 09 004 000 6669+028+6600:
  Ю2 000 .14 6669+028+6600:)

                      </textarea>
                  </form>
                </div>
              </div>
          
          
          
          
        <!-- To the right 
        <div class="pull-right hidden-xs">
          Клуб великих разработчиков Java
        </div>
       
        <strong>ЦЛР-Актобе &copy; 2016.</strong-->
      </footer>

      
      
      
      
      
      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane active" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Дополнительно</h3>
            <ul class="control-sidebar-menu">
            <li>
              <a href="#"><i class="fa fa-link"></i> <span>Журнал учета</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Системный журнал</a></li>
              </ul>
            </li>
            
            <li>
              <a href="#"><i class="fa fa-link"></i> <span>Сервис</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Нормативные документы</a></li>
                <li><a href="pages/calendar.html">Календарь</a></li>
                <li><a href="#">Справка</a></li>
              </ul>
            </li>
            </ul><!-- /.control-sidebar-menu -->


          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
              <h3 class="control-sidebar-heading">Основные настройки</h3>

            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
      
      
      
      
      
      
      
      
      
      
    </div>
    
   <div class="modal fade" id="soob_prib" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">201 - СООБЩЕНИЕ О ПРИБЫТИИ</h4>
        <hr>
      </div>
      <div class="modal-body">
      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="nom_poezd" class="col-sm-2 control-label">Номер поезда</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="nom_poezd" value="3474">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="index_poezd1" class="col-sm-2 control-label">Индекс поезда</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="index_poezd1" value="6686">
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="index_poezd2" value="040">
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="index_poezd3" value="6600">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="naprav_prib" class="col-sm-2 control-label">Направление прибытия</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="naprav_prib" value="668600 - Никельтау">
            </div>
          </div>
          <br><br>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="date" class="col-sm-2 control-label">Дата</label>
            <div class="col-sm-4">
              <input type="date" class="form-control" id="date" value="2016-01-01">
            </div>
            <label for="time" class="col-sm-2 control-label">Время</label>
            <div class="col-sm-4">
              <input type="time" class="form-control" id="time" value="10:00">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="park" class="col-sm-2 control-label">Парк</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="park" value="0">
            </div>
            <label for="put" class="col-sm-2 control-label">Путь</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="put" value="0">
            </div>
          </div>
           <br><br>
          <div class="form-group">
            <label for="rabota_s_lol" class="col-sm-2 control-label">Работа с локомотивом</label>
            <div class="col-sm-4">
              <select class="form-control" id="rabota_s_lol">
                <option>работы нет</option>
                <option>отцепка локомотива</option>
                <option>смена бригад</option>
              </select>
            </div>
            <label for="kol_lok" class="col-sm-2 control-label">Кол-во локомотивов</label>
            <div class="col-sm-4">
              <select class="form-control" id="kol_lok">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
              </select>
            </div>
          </div>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="kod_serii_lok" class="col-sm-4 control-label">Код серии локомотива</label>
            <div class="col-sm-5">
              <select class="form-control" id="kod_serii_lok">
                <option>572 - 0039 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0049 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0061 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0078 - 2ТЭ10МК - секций - 2</option>
              </select>
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="nom_lok" class="col-sm-4 control-label">Номер локомотива</label>
            <div class="col-sm-5">
              <input type="text" class="form-control" id="nom_lok" value="07921">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="vid_sled_lok" class="col-sm-4 control-label">Вид следования локомотива</label>
            <div class="col-sm-5">
              <select class="form-control" id="vid_sled_lok">
                <option>Движение в голове локомотива</option>
                <option>Движение в двойной тяге</option>
                <option>Движение в пересылке</option>
              </select>
            </div>
          </div>
          <br><br>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="fam_mash" class="col-sm-2 control-label">Фамилия машиниста</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="fam_mash">
            </div>
            <label for="vrem_mash" class="col-sm-2 control-label">Время</label>
            <div class="col-sm-4">
              <input type="time" class="form-control" id="vrem_mash" value="10:00">
            </div>
          </div>
<br><br>
          <div class="form-group">
            <label for="depo_prop" class="col-sm-2 control-label">Депо прописки</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="depo_prop" value="07921">
            </div>
            <label for="tab_nom" class="col-sm-2 control-label">Табельный номер</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="tab_nom" value="0000">
            </div>
          </div>

        </div>
      </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
        <button type="button" class="btn btn-primary" id="soob_otpr_save">Принять</button>
      </div>
    </div>
  </div>
</div>
    
    

       
       
       
       
       
       
       
       
            
            
  
    
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
    
    </body>
    
</html>