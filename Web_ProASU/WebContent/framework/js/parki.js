$(document).ready(function () {
	function parseUrlQuery() {
	    var data = {};
	    if(location.search) {
	        var pair = (location.search.substr(1)).split('&');
	        for(var i = 0; i < pair.length; i ++) {
	            var param = pair[i].split('=');
	            data[param[0]] = param[1];
	        }
	    }
	    return data;
	}
	
	var data = parseUrlQuery();			
		if (data.hasOwnProperty('park')) {		
			$("ul.sidebar-menu > li.treeview:last").addClass('active');
			//$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']).addClass('active');
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li#park"+data['park']).addClass('active');
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li#park"+data['park']+' ul.treeview-menu > li#put'+data['put']).addClass('active');
			$(".content-header > h1").text("Парк: "+data['park']+" путь: "+data['put']);
		}
		
	$("a.emptyPut").click(function(){
		var put = $(this).parent("li").attr("id");
		if (put.substring(0,3)=='put'){
			$(".content").empty();
			$(".content-header > h1").empty();
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li > ul.treeview-menu > li").removeClass('active');
		}
	});
});