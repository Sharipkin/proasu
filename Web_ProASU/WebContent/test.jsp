<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">201 - ПРИБЫТИЕ</h4>
	</div>
	<div class="modal-body">
		<div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Станция прибытия поезда -  660007 КАНДЫГАШ</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form class="prib form-horizontal" action="pribmodal" method="post">
                  <div class="box-body">
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Номер поезда</label>
                      <div class="col-sm-4">
                        <input class="form-control input-sm" type="text"  name="nPoezd" value="${poezd.nPoezd }">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Индекс поезда</label>
                      <div class="col-sm-6">
                        <input class="form-control input-sm" type="text" name="stForm"
									value="${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }" readonly>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Направление прибытия</label>
                      <div class="col-sm-6">
                        <input class="form-control input-sm" type="text" name="stPer"
									value="${poezd.stPer } ${poezd.naimStPer }" readonly>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Парк</label>
                      <div class="col-sm-2">
                        <jsp:useBean id="POPark"
										type="java.util.List<kz.railways.entities.Park>"
										scope="session" />
									<c:if test="${POPark.size()>0 }">
										<select class="form-control input-sm" name="nPark">
										    <option></option>
											<c:forEach var="park" items="${POPark }">
												<option>${park.nPark }</option>
											</c:forEach>
										</select>
									</c:if>
                      </div>
                      <label class="col-sm-1 control-label">Путь</label>
                      <div class="col-sm-2">
                        <input class="form-control input-sm" type="text" name="nPut">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="col-sm-4 control-label">Дата и время</label>
                      <div class="col-sm-6">
              	  <div class='input-group date' id='datetimepicker'>
                    <input type='text' class="form-control" name="dvOper"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                </div>
            </div>
            <script type="text/javascript">
            $(function () {
                $('#datetimepicker').datetimepicker({
                    locale: 'ru',
                    format: 'YYYY-MM-DD HH:mm:ss'
                });
            });
        </script>

                    
                  </div><!-- /.box-body -->
                </form>
              </div>
	</div>
	<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
			<button type="button" class="btn btn-primary" onclick="$('form.prib').submit();">Принять</button>
		</div>
