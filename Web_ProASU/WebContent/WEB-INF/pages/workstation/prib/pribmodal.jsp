<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" type="kz.railways.entities.User" scope="session" />
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
			<h3 class="box-title">
				<font color="#337ab7"><b>Станция прибытия поезда</b> -
					${user.station.kod } ${user.station.naim }</font>
			</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="prib form-horizontal" action="pribmodal" method="post">
			<div class="box-body">
				<div class="form-group">
					<label class="col-sm-4 control-label">Номер поезда</label>
					<div class="col-sm-4">
						<input class="form-control input-sm" type="text" name="nPoezd"
							value="${poezd.nPoezd }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Индекс поезда</label>
					<div class="col-sm-6">
						<input class="form-control input-sm" type="text" name="stForm"
							value="${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }"
							readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Направление прибытия</label>
					<div class="col-sm-6">
						<input class="form-control input-sm" type="text" name="stPer"
							value="${poezd.stPer } ${poezd.naimStPer }" readonly>
					</div>
				</div>
				<jsp:useBean id="POPark"
					type="java.util.List<kz.railways.entities.Park>" scope="session" />
				<c:if test="${POPark.size()>0 }">
					<div class="form-group">
						<label class="col-sm-4 control-label">Парк</label>
						<div class="col-sm-2">


							<select class="form-control input-sm" name="nPark" id="park">
								<c:forEach var="park" items="${POPark }">
									<option>${park.nPark }</option>
								</c:forEach>
							</select>

						</div>
						<label class="col-sm-1 control-label">Путь</label>
						<div class="col-sm-2" id="puti">
							<select class="form-control input-sm" name="nPut" id="park">
								<c:forEach var="put" items="${POPark.get(0).putList }">
									<option
										<c:if test="${put.poezd.nPoezd != null}"> disabled</c:if>>${put.nPut }</option>
								</c:forEach>
							</select>

						</div>
					</div>
				</c:if>

				<div class="form-group">
					<label class="col-sm-4 control-label">Дата и время</label>
					<div class="col-sm-6">
						<div class='input-group date' id='datetimepicker'>
							<input type='text' class="form-control" name="dvOper" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
				<script type="text/javascript">
            $(function () {
                $('#datetimepicker').datetimepicker({
                    locale: 'ru',
                    //format: 'YYYY-MM-DD HH:mm:ss'
                    format: 'DD.MM.YYYY HH:mm'
                });
            });
        </script>


			</div>
			<!-- /.box-body -->
		</form>
	</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
	<button type="button" class="btn btn-primary"
		onclick="$('form.prib').submit();">Выполнить</button>
</div>


<script type="text/javascript">
    $(function () { 
        $('#park').change(function()
        {

            // получаем выбранный id
            var id = $(this).val();
            $.ajax({
                type: 'GET',
                url: 'getput?npark=' + id,
                success: function (data) {
                     
                    // заменяем содержимое присланным частичным представлением
                    $('#puti').replaceWith(data);
                }
            });
        });
    })
</script>
