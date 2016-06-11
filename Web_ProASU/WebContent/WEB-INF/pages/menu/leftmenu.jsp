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

<li class="treeview "><a href="#"><i class="fa fa-sitemap"></i>
		<span>Парки станции</span> <i class="fa fa-angle-left pull-right"></i></a>
	<ul class="treeview-menu">
		<jsp:useBean id="POPark" type="java.util.List<kz.railways.entities.Park>" scope="session"/>
		<c:if test="${POPark.size()>0 }">			
			<li class="kodS1"><a href="#"><i class="fa fa-code-fork"></i>ПОП(1-нечетный) <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<c:forEach var="park" items="${POPark }">
						<c:if test="${park.kodS == 1 }">
							<li id="park${park.nPark }"><a href="#"><i class="fa fa-road"></i>${park.nPark }<i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<c:if test="${park.putList.size()>0 }">
										<c:forEach var="put" items="${park.putList }">
											<c:choose>
												<c:when test="${put.poezd.nPoezd != null}">
							       				    <li id="put${put.nPut }"><a href="park?kodS=${park.kodS }&park=${park.nPark }&put=${put.nPut }"><i class="fa fa-train"></i>${put.nPut } - ${put.poezd.nPoezd } ${put.poezd.stForm } ${put.poezd.nSost } ${put.poezd.stNazn }</a></li>
							    		    	</c:when>
												<c:otherwise>
							       					 <li id="put${put.nPut }"><a href="#"><i class="fa fa-train"></i>${put.nPut }</a></li>
							   					</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if> 
								</ul>
							</li>					
						</c:if>
					</c:forEach>
				</ul>
			</li>
			<li class="kodS2"><a href="#"><i class="fa fa-code-fork"></i>ПОП(2-четный) <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<c:forEach var="park" items="${POPark }">
						<c:if test="${park.kodS == 2 }">
							<li id="park${park.nPark }"><a href="#"><i class="fa fa-road"></i>${park.nPark }<i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<c:if test="${park.putList.size()>0 }">
										<c:forEach var="put" items="${park.putList }">
											<c:choose>
												<c:when test="${put.poezd.nPoezd != null}">
							       				    <li id="put${put.nPut }"><a href="park?kodS=${park.kodS }&park=${park.nPark }&put=${put.nPut }"><i class="fa fa-train"></i>${put.nPut } - ${put.poezd.nPoezd } ${put.poezd.stForm } ${put.poezd.nSost } ${put.poezd.stNazn }</a></li>
							    		    	</c:when>
												<c:otherwise>
							       					 <li id="put${put.nPut }"><a href="#"><i class="fa fa-train"></i>${put.nPut }</a></li>
							   					</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if> 
								</ul>
							</li>					
						</c:if>
					</c:forEach>
				</ul>
			</li>						
		</c:if>		
		
	<jsp:useBean id="sortPark" type="java.util.List<kz.railways.entities.Put>" scope="session"/>
		<li><a href="#"><i class="fa fa-random"></i>СОРТ<i class="fa fa-angle-left pull-right"></i></a>
			<ul class="treeview-menu">
				<c:forEach var="sput" items="${sortPark }">
					<li><a href="#">${sput.nPut } - ${sput.naimPut }</a></li>
				</c:forEach>
			</ul></li>

	</ul>
</li>
