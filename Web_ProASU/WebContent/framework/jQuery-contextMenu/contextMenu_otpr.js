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
            soob_otpr: {name: "200 - ОТПРАВЛЕНИЕ",
            callback:
              function(key, options) {
                var tr = $(this).closest('tr').attr('id');
                $('#soob_otpr').modal('show');
              }
            },
            "soob_prosled": {"name": "205 - ГОТОВНОСТЬ К ОТПРАВЛЕНИЮ"
            },
            "soob_pererashet": {"name": "209 - ИЗМЕНЕНИЕ ИНДЕКСА ПОЕЗДА"},
           }
    });
  });

  $('#soob_otpr_save').click(function(event) {
    $('#soob_otpr').modal('hide');
    alert("данные сохранены!");
  });
});