<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="poezd" type="kz.railways.entities.Poezd"
	scope="request" />
<jsp:useBean id="user" type="kz.railways.entities.User" scope="session" />

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">201 - ПРИБЫТИЕ</h4>
			<h5 class="modal-title" id="myModalLabel">
				<font color="#337ab7"><b>Станция прибытия поезда</b> - ${user.station.kod } ${user.station.naim }</font>
			</h5>
		</div>
		<div class="modal-body pribitie">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form class="form" action="pribmodal" method="post">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Номер поезда</span> <input
									type="text" class="form-control input-sm" name="nPoezd"
									value="${poezd.nPoezd }">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Индекс поезда</span> <input
									type="text" class="form-control input-sm" name="stForm"
									value="${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }"
									readonly>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Направление прибытия</span> <input
									type="text" class="form-control input-sm" name="stPer"
									value="${poezd.stPer } ${poezd.naimStPer }" readonly>
							</div>
						</div>
						<div class="form-group">
							<div class="form-inline">
								<div class="form-group">
									<label>Парк</label>
									<jsp:useBean id="POPark"
										type="java.util.List<kz.railways.entities.Park>"
										scope="session" />
									<c:if test="${POPark.size()>0 }">
										<select class="form-control input-sm" id="park" name="nPark">
											<c:forEach var="park" items="${POPark }">
												<option>${park.nPark }</option>
											</c:forEach>
										</select>
									</c:if>
								</div>
								<div class="form-group">
									<label>Путь</label> <input type="text" class="form-control input-sm"
										name="nPut" value="">
								</div>
							</div>
						</div>
						
						<div class="container">
    <div class="row">
        <div class='col-sm-4'>
            <div class="form-group">
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
    </div>
</div>

					</form>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
			<button type="button" class="btn btn-primary" id="soob_otpr_save" onclick="$('.panel-body > form').submit();">Принять</button>
		</div>
	</div>
</div>