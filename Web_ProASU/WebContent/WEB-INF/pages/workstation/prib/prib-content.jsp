<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:useBean id="poezd"
	type="kz.railways.entities.Poezd" scope="request" />	
		
<div class="col-xs-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Прибытие</h3>
			<div class="box-tools pull-right">
				<button class="btn btn-box-tool" data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button class="btn btn-box-tool" data-widget="remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<form class="form-horizontal" action="prib" method="post">
                  <div class="box-body">
                    <div class="col-sm-8">
                    <div class="panel panel-primary">
                    <div class="panel-body">
                  	<div class="form-group">
                      <label class="col-sm-4 control-label">Номер поезда</label>
                      <div class="col-sm-2">
                        <input class="form-control" type="text" name="nPoezd" value="${poezd.nPoezd }">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Индекс поезда</label>
                      <div class="col-sm-3">
                        <input class="form-control" type="text" name="stForm" value="${poezd.stForm }">
                      </div>
                      <div class="col-sm-2">
                        <input class="form-control" type="text" name="nSost" value="${poezd.nSost }">
                      </div>
                      <div class="col-sm-3">
                        <input class="form-control" type="text" name="stNazn" value="${poezd.stNazn }">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Дата</label>
                      <div class="col-sm-4">
                        <input class="form-control" type="text" name="dvOper" value="">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Парк</label>
                      <div class="col-sm-2">
                        <input class="form-control" type="text" name="nPark" value="">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Путь</label>
                      <div class="col-sm-2">
                        <input class="form-control" type="text" name="nPut" value="">
                      </div>
                    </div>
                    </div>
                    </div>
                    </div>
                  </div><!-- /.box-body -->
                  <div class="box-footer">
                    <button type="submit" class="btn btn-info pull-right">Прибытие</button>
                  </div><!-- /.box-footer -->
        </form>
		<!-- /.box-body -->
	</div>
	<!-- /.box-->
</div>
<!-- /.col -->