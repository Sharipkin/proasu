<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="naprs" type="java.util.List<kz.railways.entities.Napr>" scope="session">
    <jsp:getProperty property="naprs" name="kod"/>
    <jsp:getProperty property="naprs" name="naim"/>
</jsp:useBean>	
<% 
	String uri = request.getRequestURI();
	String pageName = uri.substring(uri.lastIndexOf("/")+1);
	pageContext.setAttribute("pageName", pageName);
%>

<li class="treeview podhod<c:if test="${pageName == 'podhod-view.jsp'}"> active</c:if>"><a href="#"><i class="fa fa-home"></i> <span>Подход</span>
		<i class="fa fa-angle-left pull-right"></i></a>
	<ul class="treeview-menu">
		<li<c:if test="${empty param.napr}"> class="active"</c:if>><a href="podhod">Все направления</a></li>
		
		<li><c:out value="${napr.naim}" /></li>
		
		<c:forEach var="napr" items="${naprs }">
			<li <c:if test="${napr.kod == param.napr}">class="active"</c:if>><a href="podhod?napr=${napr.kod }">${napr.kod } - ${napr.naim }</a></li>
		</c:forEach>

	</ul></li>

<jsp:useBean id="user" type="kz.railways.entities.User" scope="session"/>
	<c:choose>	
		<c:when test="${user.station.kodS != 3 }">
			<li class="treeview "><a href="#"><i class="fa fa-sitemap"></i><span>Парки станции</span> <i class="fa fa-angle-left pull-right"></i></a>
			<jsp:useBean id="POPark" type="java.util.List<kz.railways.entities.Park>" scope="session"/>
				<ul class="treeview-menu">
					<c:if test="${POPark.size()>0 }">
						<c:forEach var="park" items="${POPark }">
							<li id="park${park.nPark }"><a href="#"><i class="fa fa-road"></i>${park.nPark } - ${park.name }<i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<c:if test="${park.putList.size()>0 }">
										<c:forEach var="put" items="${park.putList }">
											<c:choose>
												<c:when test="${put.poezd.nPoezd != null}">
							       				    <li id="put${put.nPut }"><a href="park?park=${park.nPark }&put=${put.nPut }"><i class="fa fa-train" style="color:white"></i>${put.nPut } - ${put.poezd.nPoezd } ${put.poezd.stForm } ${put.poezd.nSost } ${put.poezd.stNazn }</a></li>
							    		    	</c:when>
												<c:otherwise>
							       					 <li id="put${put.nPut }"><a href="#"><i class="fa fa-train" style="color:black"></i>${put.nPut }</a></li>
							   					</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if> 
								</ul>
							</li>					 
						</c:forEach>			
					</c:if>
				</ul>
			</li>
		</c:when>		
	</c:choose>
