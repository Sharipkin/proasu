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
			//alert(data['park']);
//			var firstBtn = $("ul.sidebar-menu > li.treeview:last > a"); 
//			firstBtn.click();
//			var secBtn = $("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']+ ' > a');			
//			secBtn.click();
//			var thirdBtn = $("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']+ ' ul.treeview-menu > li#park'+data['park']+' > a');
//			thirdBtn.click();
//			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']+ ' ul.treeview-menu > li#park'+data['park']+' ul.treeview-menu > li#put'+data['put']+ ' > a').css('color', 'red');
			$("ul.sidebar-menu > li.treeview:last").addClass('active');
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']).addClass('active');
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']+ ' ul.treeview-menu > li#park'+data['park']).addClass('active');
			$("ul.sidebar-menu > li.treeview:last > ul.treeview-menu > li.kodS"+data['kodS']+ ' ul.treeview-menu > li#park'+data['park']+' ul.treeview-menu > li#put'+data['put']+ ' > a').css('color', 'red');
		}	
});