<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="poezd"	type="kz.railways.entities.Poezd" scope="request" />

<div class="col-md-12">
	<div class="box">
		<div class="box-header with-border">
			<table class="table table-bordered parki-table-header">
				<tr>
					<td>Номер поезда:</td>	              
					<td>${poezd.nPoezd }</td>
					<td>Индекс&nbsp;поезда:</td>	              
					<td>${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }</td>
					<td>Операция:</td>
					<td>${poezd.mnkdOp }</td>
					
				</tr>
			</table>			 
		</div><!-- /.box-header -->
		<div class="box-body">
			<div class="row">
				<div class="col-md-4">
					<table class="table table-bordered parki-table">
						<tr>
							<td>Время операции:</td>
							<td><fmt:formatDate value="${poezd.dvOper }" pattern="dd.MM.yy hh:mm:ss" /></td>
						</tr>
						<tr>
  							<td>Количество вагонов</td>	              
  							<td>${poezd.kolVag }</td>
						</tr>
						<tr>
  							<td>Вес поезда</td>
  							<td>${poezd.brutto }</td>
     					</tr>
     					<tr>
       						<td>Условная длина поезда</td>	              
       						<td>${poezd.udl }</td>
						</tr>
						<tr>
  							<td>ОСИ</td>
  							<td>${poezd.kolOs }/${poezd.kolRol }</td>
						</tr>
   					</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered parki-table">     					
						<tr>
  							<td>Состояние ТГНЛ</td>
  							<td>${poezd.sTgnl }</td>
       					</tr>
       					<tr>
       						<td>Характеристика поезда</td>	              
       						<td>${poezd.harP }</td>
						</tr>
						<tr>
  							<td>Индекс негабаритности</td>
  							<td>${poezd.negab }</td>
						</tr>
						<tr>
  							<td>Отметка о живности</td>
  							<td>${poezd.givn }</td>
						</tr>
						<tr>
  							<td>Маршрут</td>
  							<td>${poezd.marsh }</td>
       					</tr>
     				</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered parki-table">
						<tr>
  							<td>Код прикрытия</td>
  							<td>${poezd.prik }</td>
						</tr>
						<tr>
  							<td>Признак охраны</td>
  							<td>${poezd.prOhr }</td>
       					</tr>
       					<tr>
  							<td>Номер головного вагона</td>
  							<td>${poezd.nvagN }</td>
       					</tr>
       					<tr>
  							<td>Номер хвостового вагона</td>
  							<td>${poezd.nvagK }</td>
       					</tr>            					
       					<tr>
  							<td>Признак работы с локомотивом</td>
  							<td>${poezd.rabLok }</td>
       					</tr>    
     				</table>
				</div>
			</div>  
		</div><!-- /.box-body -->
		<c:if test="${poezd.vagonList.size() > 0}">
			<div class="box box-solid collapsed-box">
	          <div class="box-header with-border">
	            <h3 class="box-title">Просмотр ТГНЛ</h3>
	            <div class="box-tools pull-right">
	              <button class="btn btn-sm " data-widget="collapse"><i class="fa fa-plus"></i></button>
	            </div><!-- /.box-tools -->
	          </div><!-- /.box-header -->
	          <div class="box-body">
	          	<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="blue">
							<th>п/н</th>
							<th>Вагон</th>
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
	            <c:forEach var="vagon" items="${poezd.vagonList }">	
	         		<tr>
						<td>${vagon.npp }</td>
						<td>${vagon.nVag }</td>
						<td>${vagon.kodSob }</td>
						<td>${vagon.rolik }</td>
						<td>${vagon.vesGr }</td>
						<td>${vagon.stNaznV }</td>
						<td>${vagon.kodGr }</td>
						<td>${vagon.grPol }</td>
						<td>${vagon.marsh }</td>
						<td>${vagon.prik }</td>
						<td>${vagon.givn }</td>
						<td>${vagon.kolPl }</td>
						<td>${vagon.grKont }</td>
						<td>${vagon.porKont }</td>
						<td>${vagon.esrVp }</td>
						<td>${vagon.taraUt }</td>
						<td>${vagon.prim }</td>
					</tr>
	            		
	            </c:forEach>
	            </tbody>
	     			</table>
	          </div><!-- /.box-body -->
	        </div><!-- /.box -->
		 </c:if>
	</div><!-- /.box -->
</div>