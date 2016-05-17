$(document).ready(function() {
  var tr_id = 0;
  $(function(){
    $('#example2').contextMenu({
      selector: 'tr',
      callback: function(key, options) {
        var tr = $(this).closest('tr').attr('id');
        alert(tr);
      },
      items: {
        "Subgroup1": {
          "name": "ОПЕРАЦИИ С ПОЕЗДАМИ",
          "items": {
            soob_prib: {name: "201 - СООБЩЕНИЕ О ПРИБЫТИИ",
            callback:
              function(key, options) {
                var tr = $(this).closest('tr').attr('id');
                $('#soob_prib').modal('show');
              }
            },
            "soob_prosled": {"name": "202 - СООБЩЕНИЕ О ПРОСЛЕДОВАНИИ"
            },
            "soob_pererashet": {"name": "ПЕРЕРАСЧЕТ ИТОГОВЫХ ДАННЫХ"},
            "soob_udalenie": {"name": "УДАЛЕНИЕ СОСТАВА ИЗ ПОДХОДА"},
          }
        },
        "Subgroup2": {
          "name": "ТЕХНОЛОГИЧЕСКИЕ ДОКУМЕНТЫ НА СОСТАВ",
          "items": {
            "tekh_docum": {"name": "ДОКУМЕНТЫ"},
          }
        },
        "Subgroup3": {
          "name": "ОПЕРАТИВНЫЕ СПРАВКИ",
          "items": {
            "oper_spr": {"name": "СПРАВКИ"},
          }
        },
        "Subgroup4": {
          "name": "ЗАПРОС В АСОУП",
          "items": {
            "asoup_zapros": {"name": "ЗАПРОС"},
          }
        },
      }
    });
  });

  $('#soob_prib_save').click(function(event) {
    $('#soob_prib').modal('hide');
    alert("данные сохранены!");
  });
});