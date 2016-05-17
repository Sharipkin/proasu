<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<table id="example2" class="table table-bordered table-hover context-menu-one dataTable">
	<thead>
           <tr class="info">
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
			<c:forEach var="podhod" items="${podhodList }">
				<tr>
					<td>${podhod.getStPer() }</td>
					<td>${podhod.getnPoezd() }</td>
					<td>${podhod.getStForm() }</td>
					<td>${podhod.getnSost() }</td>
					<td>${podhod.getStNazn() }</td>
					<td><fmt:formatDate value="${podhod.getDvOtpr() }" type="both" dateStyle ="short" timeStyle ="short"/></td>
					<td>${podhod.getUslDl() }</td>
					<td>${podhod.getKolVag() }</td>
					<td>${podhod.getVesPoezd() }</td>
					<td>-</td>
					<td>${podhod.getNegab()}</td>
				</tr>
			</c:forEach>
	</tbody>
</table>