<%@ page language="java" pageEncoding="UTF-8"%>
   <div class="modal fade" id="soob_prib" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">201 - СООБЩЕНИЕ О ПРИБЫТИИ</h4>
        <hr>
      </div>
      <div class="modal-body">
      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="nom_poezd" class="col-sm-2 control-label">Номер поезда</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="nom_poezd" value="3474">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="index_poezd1" class="col-sm-2 control-label">Индекс поезда</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="index_poezd1" value="6686">
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="index_poezd2" value="040">
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="index_poezd3" value="6600">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="naprav_prib" class="col-sm-2 control-label">Направление прибытия</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="naprav_prib" value="668600 - Никельтау">
            </div>
          </div>
          <br><br>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="date" class="col-sm-2 control-label">Дата</label>
            <div class="col-sm-4">
              <input type="date" class="form-control" id="date" value="2016-01-01">
            </div>
            <label for="time" class="col-sm-2 control-label">Время</label>
            <div class="col-sm-4">
              <input type="time" class="form-control" id="time" value="10:00">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="park" class="col-sm-2 control-label">Парк</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="park" value="0">
            </div>
            <label for="put" class="col-sm-2 control-label">Путь</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="put" value="0">
            </div>
          </div>
           <br><br>
          <div class="form-group">
            <label for="rabota_s_lol" class="col-sm-2 control-label">Работа с локомотивом</label>
            <div class="col-sm-4">
              <select class="form-control" id="rabota_s_lol">
                <option>работы нет</option>
                <option>отцепка локомотива</option>
                <option>смена бригад</option>
              </select>
            </div>
            <label for="kol_lok" class="col-sm-2 control-label">Кол-во локомотивов</label>
            <div class="col-sm-4">
              <select class="form-control" id="kol_lok">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
              </select>
            </div>
          </div>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="kod_serii_lok" class="col-sm-4 control-label">Код серии локомотива</label>
            <div class="col-sm-5">
              <select class="form-control" id="kod_serii_lok">
                <option>572 - 0039 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0049 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0061 - 2ТЭ10МК - секций - 2</option>
                <option>572 - 0078 - 2ТЭ10МК - секций - 2</option>
              </select>
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="nom_lok" class="col-sm-4 control-label">Номер локомотива</label>
            <div class="col-sm-5">
              <input type="text" class="form-control" id="nom_lok" value="07921">
            </div>
          </div>
          <br><br>
          <div class="form-group">
            <label for="vid_sled_lok" class="col-sm-4 control-label">Вид следования локомотива</label>
            <div class="col-sm-5">
              <select class="form-control" id="vid_sled_lok">
                <option>Движение в голове локомотива</option>
                <option>Движение в двойной тяге</option>
                <option>Движение в пересылке</option>
              </select>
            </div>
          </div>
          <br><br>
        </div>
      </div>

      <div class="panel panel-primary">
        <div class="panel-body">
          <div class="form-group">
            <label for="fam_mash" class="col-sm-2 control-label">Фамилия машиниста</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="fam_mash">
            </div>
            <label for="vrem_mash" class="col-sm-2 control-label">Время</label>
            <div class="col-sm-4">
              <input type="time" class="form-control" id="vrem_mash" value="10:00">
            </div>
          </div>
<br><br>
          <div class="form-group">
            <label for="depo_prop" class="col-sm-2 control-label">Депо прописки</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="depo_prop" value="07921">
            </div>
            <label for="tab_nom" class="col-sm-2 control-label">Табельный номер</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="tab_nom" value="0000">
            </div>
          </div>

        </div>
      </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
        <button type="button" class="btn btn-primary" id="soob_otpr_save">Принять</button>
      </div>
    </div>
  </div>
</div>