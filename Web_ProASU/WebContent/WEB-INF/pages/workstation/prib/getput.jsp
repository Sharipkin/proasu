<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-sm-2" id="puti">
<jsp:useBean id="POPark"
	type="java.util.List<kz.railways.entities.Park>" scope="session" />
<c:if test="${POPark.size()>0 }">
	<c:forEach var="park" items="${POPark }">
		<c:if test="${park.nPark == param.npark }">
			<select class="form-control input-sm" name="nPut" id="park">
				<c:forEach var="put" items="${park.putList }">
					<option<c:if test="${put.poezd.nPoezd != null}"> disabled</c:if>>${put.nPut }</option>
				</c:forEach>
			</select>
		</c:if>
	</c:forEach>
</c:if>
</div>

