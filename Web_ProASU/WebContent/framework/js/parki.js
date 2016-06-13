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
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li#park"+data['park']+' ul.treeview-menu > li#put'+data['put']+ ' > a').css('color', 'red');
		}
		
	$("qwea").click(function(){
		var put = $(this).parent("li").attr("id");
		if (put.substring(0,3)=='put'){
			$(".content").empty();
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li > ul.treeview-menu > li > a").css('color', '#8aa4af');
		}
	});
});