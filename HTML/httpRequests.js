var xhttp = new XMLHttpRequest();

//function getRequest(URL){
//	xhttp.open("GET", URL, false);
//	xhttp.send(null);
//	return xhttp.responseText;
//}

function getRequestAsync(URL, callback){
	xhttp.onreadystatechange = function(){
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			callback(xhttp.responseText);
		}
		xhttp.open("GET", URL, true);
		xhttp.send(null);
	}
}


