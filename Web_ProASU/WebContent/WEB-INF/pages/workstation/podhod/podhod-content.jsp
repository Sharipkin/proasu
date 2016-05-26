<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="poezdList"
	type="java.util.List<kz.railways.entities.Poezd>" scope="request" />
<div class="col-xs-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Подход</h3>

			<div class="box-tools pull-right">
				<button class="btn btn-box-tool" data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button class="btn btn-box-tool" data-widget="remove">
					<i class="fa fa-times"></i>
				</button>
			</div>

		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="table-responsive">
				
				<table id="example2"
					class="table table-bordered table-hover context-menu-one dataTable">
					<thead>
						<tr class="info">
							<%-- <th>Вагоны</th> --%>
							<th>Станция передачи</th>
							<th>№ поезда</th>
							<th>Станция формирования</th>
							<th>№ состава</th>
							<th>Станция назначения</th>
							<th style="width: 100px;">Дата отпр.</th>
							<th>Усл. дл.</th>
							<th>Кол. ваг..</th>
							<th>Вес поезд.</th>
							<th>Охр</th>
							<th>Негаб.</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${poezdList }">
							<tr>
								<%--<td><a class="btn btn-primary" role="button"
					data-toggle="collapse" href="#ind${p.indPoezd.trim() }"
					aria-expanded="false" aria-controls="ind${p.indPoezd }"> вагоны
				</a></td>--%>
								<td>${p.stPer }</td>
								<td>${p.nPoezd }</td>
								<td>${p.stForm }</td>
								<td>${p.nSost }</td>
								<td>${p.stNazn }</td>
								<td><fmt:formatDate value="${p.dvOtpr }" type="both"
										dateStyle="short" timeStyle="short" /></td>
								<td>${p.udl }</td>
								<td>${p.kolVag }</td>
								<td>${p.brutto }</td>
								<td>-</td>
								<td>${p.negab}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:forEach var="p" items="${poezdList }">

					<div class="collapse" id="ind${p.indPoezd.trim() }">
						<div class="well">
							<c:forEach var="vag" items="${p.vagonList }">
								<c:out value="${vag.nVag }" />
							</c:forEach>
						</div>
					</div>

				</c:forEach>

			</div>
			<!--table-responsive-->

		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box-->
</div>
<!-- /.col -->

