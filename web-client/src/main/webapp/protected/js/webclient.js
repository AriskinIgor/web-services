function addBook() {
	var url = 'http://localhost:8080/web-services/atheneum/add';
	var data = ({
		name : $('#name').val(),
		author : $('#author').val(),
		description : $('#description').val()
	});
	var options = ({
		type: "PUT",
		success : function(data) {
			alert(data);
		}
	});
	ajaxPostRequest(url, data, options);
}


function ajaxGetRequest(url, extOptions) {
	var data = null;
	$.ajaxSetup({
		cache : false
	});
	$.ajax({
		url : url,
		dataType : 'json',
		data : data,
		contentType : "application/json",
		beforeSend : options.beforeSend,
		success : options.success,
		complete : options.complete,
		error : options.error
	});
}


function ajaxPostRequest(url, data, extOptions) {
	var defaults = ({
		timeout : 20000,
		beforeSend : function() {
			$("div.msgload").show();
		},
		complete : function() {
			$("div.msgload").hide();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			var rateLimitError = jQuery.parseJSON(jqXHR.responseText);
			if (rateLimitError.rateLimit == true) {
				showModalRateLimit(parseInt(rateLimitError.resetTime));
			} else if (jqXHR.readyState != 0) {
				$("div.msgErrorOnLoad").text(
						" " + textStatus + ": " + errorThrown);
				$("div.msgErrorOnLoad").show();
			}
		}
	});
	var options = $.extend(defaults, extOptions);
	$.ajaxSetup({
		cache : false
	});
	$.ajax({
		timeout : options.timeout,
		url : url,
		type : options.type,
		dataType : 'json',
		contentType : "application/json",
		data : JSON.stringify(data),
		beforeSend : options.beforeSend,
		complete : options.complete,
		error : options.error,
		success : options.success
	});
}