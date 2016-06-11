<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="poezd"	type="kz.railways.entities.Poezd" scope="request" />

<div class="col-xs-12">
	<div class="box">
		<div class="box-body">
			<div class="table-responsive">
				<!--table id="example2" class="table table-bordered table-hover context-menu-one dataTable"-->
				<table id="poezd" class="context-menu-one dataTable">
					<thead>
						<tr class="info">
							<th>№</th>
							<th>Индекс&nbsp;поезда</th>
							<th>Операция</th>														
							<th>Время операции</th>							
							<th>Ваг</th>
							<th>Вес</th>
							<th>Удл</th>
							<th>ОСИ</th>
							<th>Ролик</th>
							<th>Сост.НЛП</th>
							<th>Хар.п.</th>
							<th>НЕГ</th>
							<th>Ж</th>
							<th>М</th>
							<th>ПР</th>
							<th>ОХР</th>
							<th>ГОЛ.В.</th>
							<th>ХВ.В.</th>
							<th>Раб.лок.</th>
						</tr>
					</thead>
					<tbody>						
						<tr>							
							<td><span>${poezd.nPoezd }</span></td>
							<td><i class="fa fa-train"></i> ${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }  </td>
							<td>${poezd.mnkdOp }</td>							
							<td><fmt:formatDate value="${poezd.dvOper }" pattern="dd.MM.yy hh:mm:ss" /></td>
							<td>${poezd.kolVag }</td>
							<td>${poezd.brutto }</td>
							<td>${poezd.udl }</td>
							<td>${poezd.kolOs }</td>
							<td>${poezd.kolRol }</td>
							<td>${poezd.sTgnl }</td>
							<td>${poezd.harP }</td>
							<td>${poezd.negab }</td>
							<td>${poezd.givn }</td>
							<td>${poezd.marsh }</td>
							<td>${poezd.prik }</td>
							<td>${poezd.prOhr }</td>
							<td>${poezd.nvagN }</td>
							<td>${poezd.nvagK }</td>
							<td>${poezd.rabLok }</td>
														
						</tr>
						
					</tbody>
				</table>

			</div>
			<!--table-responsive-->

		</div>
		<!-- /.box-body -->


	</div>
	<!-- /.box-->
</div>
<!-- /.col -->