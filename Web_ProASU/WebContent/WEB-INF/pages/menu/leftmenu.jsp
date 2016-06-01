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

<li class="treeview<c:if test="${pageName == 'podhod-view.jsp'}"> active</c:if>"><a href="#"><i class="fa fa-home"></i> <span>Подход</span>
		<i class="fa fa-angle-left pull-right"></i></a>
	<ul class="treeview-menu">
		<li<c:if test="${empty param.napr}"> class="active"</c:if>><a href="podhod">Все направления</a></li>
		
		<li><c:out value="${napr.naim}" /></li>
		
		<c:forEach var="napr" items="${naprs }">
			<li <c:if test="${napr.kod == param.napr}">class="active"</c:if>><a href="podhod?napr=${napr.kod }">${napr.kod } - ${napr.naim }</a></li>
		</c:forEach>

	</ul></li>

<li class="treeview"><a href="#"><i class="fa fa-sitemap"></i>
		<span>Парки станции</span> <i class="fa fa-angle-left pull-right"></i></a>
	<ul class="treeview-menu">

		<li><a href="#"><i class="fa fa-code-fork"></i>ПОП<i
				class="fa fa-angle-left pull-right"></i></a>
			<ul class="treeview-menu">
				<li class="puti"><a href="park_01.html">01 - Предгорочный <i
						class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>00</a></li>
						<li><a href="#"><i class="fa fa-road"></i>01</a></li>
						<li><a href="#"><i class="fa fa-road"></i>02 <i
								class="fa fa-angle-left pull-right"></i></a>
							<ul>
								<li><a href="tgnl_02.html"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>3471 6611 053 6600</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>03 <i
								class="fa fa-angle-left pull-right"></i></a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>3478 6686 074 6600</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>04 <i
								class="fa fa-angle-left pull-right"></i></a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>4401 6606 018 6600</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>05</a></li>
						<li><a href="#"><i class="fa fa-road"></i>06 <i
								class="fa fa-angle-left pull-right"></i></a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>3002 6678 025 6600</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>07</a></li>
						<li><a href="#"><i class="fa fa-road"></i>08 <i
								class="fa fa-angle-left pull-right"></i></a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>0108 6600 004 6600</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>09</a></li>
					</ul></li>
				<li class="puti"><a href="#">02 - Отправочный<i
						class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>00</a></li>
						<li><a href="#"><i class="fa fa-road"></i>43</a></li>
						<li><a href="#"><i class="fa fa-road"></i>44</a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>3402 6600 178 6611</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>45</a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>2829 6600 045 6669</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>46</a></li>
						<li><a href="#"><i class="fa fa-road"></i>47</a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>2833 6600 071 6831</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>48</a></li>
						<li><a href="#"><i class="fa fa-road"></i>49</a></li>
						<li><a href="#"><i class="fa fa-road"></i>50</a>
							<ul>
								<li><a href="#"><i class="fa fa-train"></i><font
										color="#FF0000"> <b>402 6600 177 6611</b></font></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-road"></i>55</a></li>
					</ul></li>
				<li><a href="#">04 - ПОП<i
						class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>00</a></li>
						<li><a href="#"><i class="fa fa-road"></i>01</a></li>
						<li><a href="#"><i class="fa fa-road"></i>02</a></li>
						<li><a href="#"><i class="fa fa-road"></i>03</a></li>
						<li><a href="#"><i class="fa fa-road"></i>04</a></li>
						<li><a href="#"><i class="fa fa-road"></i>05</a></li>
						<li><a href="#"><i class="fa fa-road"></i>06</a></li>
						<li><a href="#"><i class="fa fa-road"></i>07</a></li>
						<li><a href="#"><i class="fa fa-road"></i>08</a></li>
					</ul></li>
				<li><a href="#">05 - Грузовой<i
						class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>00</a></li>
						<li><a href="#"><i class="fa fa-road"></i>26</a></li>
						<li><a href="#"><i class="fa fa-road"></i>27</a></li>
						<li><a href="#"><i class="fa fa-road"></i>28</a></li>
					</ul></li>
				<li><a href="#">06</a></li>
				<li><a href="#">07 - МВРП<i
						class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>00</a></li>
						<li><a href="#"><i class="fa fa-road"></i>23</a></li>
						<li><a href="#"><i class="fa fa-road"></i>31</a></li>
						<li><a href="#"><i class="fa fa-road"></i>32</a></li>
						<li><a href="#"><i class="fa fa-road"></i>33</a></li>
						<li><a href="#"><i class="fa fa-road"></i>34</a></li>
						<li><a href="#"><i class="fa fa-road"></i>35</a></li>
					</ul></li>
				<li><a href="#">08<i class="fa fa-angle-left pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="#"><i class="fa fa-road"></i>01</a></li>
						<li><a href="#"><i class="fa fa-road"></i>02</a></li>
						<li><a href="#"><i class="fa fa-road"></i>03</a></li>
						<li><a href="#"><i class="fa fa-road"></i>04</a></li>
						<li><a href="#"><i class="fa fa-road"></i>05</a></li>
						<li><a href="#"><i class="fa fa-road"></i>06</a></li>
						<li><a href="#"><i class="fa fa-road"></i>07</a></li>
						<li><a href="#"><i class="fa fa-road"></i>08</a></li>
						<li><a href="#"><i class="fa fa-road"></i>09</a></li>
						<li><a href="#"><i class="fa fa-road"></i>10</a></li>
						<li><a href="#"><i class="fa fa-road"></i>11</a></li>
						<li><a href="#"><i class="fa fa-road"></i>12</a></li>
						<li><a href="#"><i class="fa fa-road"></i>13</a></li>
						<li><a href="#"><i class="fa fa-road"></i>14</a></li>
					</ul></li>
				<li><a href="#">09<i class="fa fa-angle-left pull-right"></i></a>

				</li>
			</ul></li>

		<li><a href="#"><i class="fa fa-random"></i>СОРТ<i
				class="fa fa-angle-left pull-right"></i></a>
			<ul class="treeview-menu">
				<li><a href="#">02</a></li>
				<li><a href="#">03</a></li>
				<li><a href="#">04</a></li>
				<li><a href="#">05</a></li>
				<li><a href="#">06</a></li>
				<li><a href="#">07</a></li>
				<li><a href="#">08</a></li>
				<li><a href="#">09</a></li>
				<li><a href="#">10</a></li>
				<li><a href="#">11</a></li>
				<li><a href="#">12</a></li>
				<li><a href="#">13</a></li>
				<li><a href="#">14</a></li>
				<li><a href="#">15</a></li>
				<li><a href="#">16</a></li>
				<li><a href="#">17</a></li>
				<li><a href="#">18</a></li>
				<li><a href="#">19</a></li>
				<li><a href="#">20</a></li>
				<li><a href="#">21</a></li>
				<li><a href="#">22</a></li>
			</ul></li>

	</ul></li>
