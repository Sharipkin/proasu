<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Вход ИСУ Перевозки</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <!--link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"-->
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/framework/plugins/iCheck/square/blue.css">

  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
          <img src="${pageContext.request.contextPath }/framework/dist/img/ktz.jpg" class="img-circle" alt="User Image">
          <br>
        <a href="/WEB-INF/pages/main.html"><b>ИСУ</b> Перевозки</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Введите данные, чтобы начать работу</p>
        <form action="j_security_check" method="post">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Логин" name="j_username">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Пароль" name="j_password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> Запомнить
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Вход</button>
            </div><!-- /.col -->
          </div>
        </form>

        <a href="#" class="text-center">Подать заявку на регистрацию</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
     
    <!-- jQuery 2.1.4 -->
    <script src="${pageContext.request.contextPath }/framework/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="${pageContext.request.contextPath }/framework/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath }/framework/plugins/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>