<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="poezd"	type="kz.railways.entities.Poezd" scope="request" />

<div class="col-md-12">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">Номер поезда: <span class="badge bg-light-blue">${poezd.nPoezd }</span> &nbsp;&nbsp;&nbsp;Индекс&nbsp;поезда: <span class="badge bg-light-blue">${poezd.stForm } ${poezd.nSost } ${poezd.stNazn }</span> &nbsp;&nbsp;&nbsp;Операция: <u>${poezd.mnkdOp }</u>&nbsp;&nbsp;&nbsp;Время операции: <u><fmt:formatDate value="${poezd.dvOper }" pattern="dd.MM.yy hh:mm:ss" /></u></h3>
		</div><!-- /.box-header -->
		<div class="box-body">
			<div class="row">
				<div class="col-md-4">
					<table class="table table-bordered">
						<tr>
  							<td>Количество вагонов</td>	              
  							<td><span class="label label-success">${poezd.kolVag }</span></td>
						</tr>
						<tr>
  							<td>Вес поезда</td>
  							<td><span class="label label-success">${poezd.brutto }</span></td>
     					</tr>
     					<tr>
       						<td>Условная длина поезда</td>	              
       						<td><span class="label label-success">${poezd.udl }</span></td>
						</tr>
						<tr>
  							<td>Количсетво осей в поезде</td>
  							<td><span class="label label-success">${poezd.kolOs }</span></td>
						</tr>
						<tr>
  							<td>Количсетво роликов в поезде</td>
  							<td><span class="label label-success">${poezd.kolRol }</span></td>
						</tr>
						
   					</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered">     					
						<tr>
  							<td>Состояние ТГНЛ</td>
  							<td><span class="label label-success">${poezd.sTgnl }</span></td>
       					</tr>
       					<tr>
       						<td>Характеристика поезда</td>	              
       						<td><span class="label label-success">${poezd.harP }</span></td>
						</tr>
						<tr>
  							<td>Индекс негабаритности</td>
  							<td><span class="label label-success">${poezd.negab }</span></td>
						</tr>
						<tr>
  							<td>Отметка о живности</td>
  							<td><span class="label label-success">${poezd.givn }</span></td>
						</tr>
						<tr>
  							<td>Маршрут</td>
  							<td><span class="label label-success">${poezd.marsh }</span></td>
       					</tr>
     				</table>
				</div>
				<div class="col-md-4">
					<table class="table table-bordered">
						<tr>
  							<td>Код прикрытия</td>
  							<td><span class="label label-success">${poezd.prik }</span></td>
						</tr>
						<tr>
  							<td>Признак охраны</td>
  							<td><span class="label label-success">${poezd.prOhr }</span></td>
       					</tr>
       					<tr>
  							<td>Номер головного вагона</td>
  							<td><span class="label label-success">${poezd.nvagN }</span></td>
       					</tr>
       					<tr>
  							<td>Номер хвостового вагона</td>
  							<td><span class="label label-success">${poezd.nvagK }</span></td>
       					</tr>            					
       					<tr>
  							<td>Признак работы с локомотивом</td>
  							<td><span class="label label-success">${poezd.rabLok }</span></td>
       					</tr>    
     				</table>
				</div>
			</div>  
		</div><!-- /.box-body -->
		<div class="box box-solid collapsed-box">
          <div class="box-header with-border">
            <h3 class="box-title">Просмотр ТГНЛ</h3>
            <div class="box-tools pull-right">
              <button class="btn btn-sm " data-widget="collapse"><i class="fa fa-plus"></i></button>
            </div><!-- /.box-tools -->
          </div><!-- /.box-header -->
          <div class="box-body">
            
          </div><!-- /.box-body -->
        </div><!-- /.box -->
		    
	</div><!-- /.box -->
</div>