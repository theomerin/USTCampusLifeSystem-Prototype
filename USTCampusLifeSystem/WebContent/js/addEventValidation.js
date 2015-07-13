function eventVal() {
    var type = document.getElementById("eventType").value;
    var venue = document.getElementById("eventVenue").value;
    var returnValue = true;

    if (type === 0) {
    	document.getElementById("eventInfoType").className += ' has-warning';
    	document.getElementById("eventInfoType").className += ' has-feedback';
    	document.getElementById("typeInit").className += ' glyphicon glyphicon-warning-sign form-control-feedback';
    	document.getElementById("invalidType").style.display = "block";
    	returnValue = false;
    }
    
    if (venue === 0) {
    	document.getElementById("eventInfoVenue").className += ' has-warning';
    	document.getElementById("eventInfoVenue").className += ' has-feedback';
    	document.getElementById("venueInit").className += ' glyphicon glyphicon-warning-sign form-control-feedback';
    	document.getElementById("invalidVenue").style.display = "block";
    	returnValue = false;
    }
    
    return returnValue;
}

function resetType() {
	document.getElementById("typeInit").className = "";
	document.getElementById("eventInfoType").className = "";
}

function resetVenue() {
	document.getElementById("venueInit").className = "";
	document.getElementById("eventInfoVenue").className = "";
}