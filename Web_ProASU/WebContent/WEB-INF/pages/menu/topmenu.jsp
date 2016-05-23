<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="user" type="kz.railways.entities.User" scope="session" />

<ul class="nav navbar-nav">
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown" aria-expanded="false">${user.station.naim }
			<span class="caret"></span>
	</a>
		<ul class="dropdown-menu" role="menu">
			<c:forEach var="st" items="${user.listStations }">
				<li><a href="switchstation?userkodst=${st.kod}"><c:out
							value="${st.naim} (${st.kod})" /></a></li>
			</c:forEach>
		</ul></li>
</ul>

<!-- Аза проверь -->
