<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="poezdList"
	type="java.util.List<kz.railways.entities.Poezd>" scope="request" />
<div class="col-xs-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				<c:choose>
					<c:when test="${naprNaim == null}">
       				    Все направления
    		    	</c:when>
					<c:otherwise>
       					Подход с направления: ${naprNaim } 
   					</c:otherwise>
				</c:choose>
			</h3>
			<div class="box-tools pull-right">
                      <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Свернуть"><i class="fa fa-minus"></i></button>
                      <!--button class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Удалить"><i class="fa fa-times"></i></button-->
                      <button class="btn btn-box-tool" data-widget="print" data-toggle="tooltip" title="Печать"><i class="fa fa-print"></i></button>
                    </div>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="table-responsive">
				<!--table id="example2" class="table table-bordered table-hover context-menu-one dataTable"-->
				<table id="podhod" class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="blue">
							<th>№</th>
							<th colspan="2">Номер&nbsp;и&nbsp;индекс&nbsp;поезда</th>
							<th>Откуда</th>
							<th>Время&nbsp;отпр.&nbsp;&emsp;</th>
							<th>Ваг</th>
							<th>Удл</th>
							<th>Вес</th>
							<th>Оси</th>
							<th>Негаб</th>
							<th>Ж</th>
							<th>М</th>
							<th>ПР</th>
							<th>Охр</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${poezdList }" varStatus="status">
							<tr id="ind${p.indPoezd.trim() }" data-ind="${p.indPoezd.trim() }" 
							                                  data-target="#prib" 
							                                  data-remote="pribmodal?indPoezd=${p.indPoezd.trim() }"
							                                  data-cat="<c:if test="${p.stForm == '000000'}">p</c:if>">
								<td>${status.index + 1}</td>
								<td><span>${p.nPoezd }</span></td>
								<td><i class="fa fa-train"></i> ${p.stForm } ${p.nSost } ${p.stNazn }  </td>
								<td>${p.naimStPer }</td>
								<td><fmt:formatDate value="${p.dvOtpr }" pattern="dd.MM.yy hh:mm:ss" />
								</td>
								<td>${p.kolVag }</td>
								<td>${p.udl }</td>
								<td>${p.brutto }</td>
								<td>${p.kolOs }/${p.kolRol }</td>
								<td>${p.negab }</td>
								<td>${p.givn }</td>
								<td>${p.marsh }</td>
								<td>${p.prik }</td>
								<td>${p.prOhr }</td>
								<%-- <td><a data-toggle="mymodal" href="pribmodal?indPoezd=${p.indPoezd.trim() }">
								     <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span></a>
								<a href="prib?indPoezd=${p.indPoezd.trim() }">
								     <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span></a> 
								 <a data-toggle="mymodal2" href="pribmodal?indPoezd=${p.indPoezd.trim() }" data-target="#prib">Click me</a> 
								     
								     </td> --%> 
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!--table-responsive-->
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
              <button type="button" class="btn btn-default pull-right">Печать</button>
        </div>

	</div>
	<!-- /.box-->
</div>
<!-- /.col -->
<c:forEach var="p" items="${poezdList }">
	<div class="col-xs-12 collapse" id="dind${p.indPoezd.trim() }">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Индекс поезда - ${p.indPoezd.trim() }</h3>
				<div class="box-tools pull-right">
				    <button class="btn btn-box-tool" data-widget="print" data-toggle="tooltip" title="Печать"><i class="fa fa-print"></i></button>
				</div>
			</div>
			<!-- /.box-header -->

			<div class="box-body">
				<div class="table-responsive">
					<table id="tgnl" class="table table-bordered table-hover">
						<thead>
							<tr class="yellow">
								<th>п/н</th>
								<th>вагон</th>
								<th>сб</th>
								<th>р</th>
								<th>вес</th>
								<th>назн</th>
								<th>груз</th>
								<th>получ</th>
								<th>м</th>
								<th>п</th>
								<th>ж</th>
								<th>пл</th>
								<th>гк</th>
								<th>пк</th>
								<th>КВП</th>
								<th>УВТ</th>
								<th>примеч</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vag" items="${p.vagonList }">
								<tr>
									<td><c:out value="${vag.npp }" /></td>
									<td><c:out value="${vag.nVag }" /></td>
									<td>${vag.kodSob }</td>
									<td>${vag.rolik }</td>
									<td>${vag.vesGr }</td>
									<td>${vag.stNaznV }</td>
									<td>${vag.kodGr }</td>
									<td>${vag.grPol }</td>
									<td>${vag.marsh }</td>
									<td>${vag.prik }</td>
									<td>${vag.givn }</td>
									<td>${vag.kolPl }</td>
									<td>${vag.grKont }</td>
									<td>${vag.porKont }</td>
									<td>${vag.esrVp }</td>
									<td>${vag.taraUt }</td>
									<td>${vag.prim }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--table-responsive-->

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
              <button type="button" class="btn btn-default pull-right">Печать</button>
        </div>
		</div>
		<!-- /.box-->
		
	</div>
	<!-- /.col -->

</c:forEach>
	
<div class="modal fade" id="prib" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-md">
        <div class="modal-content" style="background-color: #eee;">
            
        </div>
    </div>
</div>

