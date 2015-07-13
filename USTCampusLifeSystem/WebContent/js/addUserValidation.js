function userVal() {
	var initPass = document.getElementById("password").value;
    var confPass = document.getElementById("passwordRep").value;
    var college = document.getElementById("collegeAff").value;
    var studNo = document.getElementById("studNo").value;
    var returnValue = true;

    if (initPass != confPass) {
    	document.getElementById("passField").className += ' has-error';
    	document.getElementById("passField").className += ' has-feedback';
    	document.getElementById("passInit").className += ' glyphicon glyphicon-remove form-control-feedback';
    	document.getElementById("passConf").className += ' glyphicon glyphicon-remove form-control-feedback';
    	document.getElementById("invalidPass").style.display = "block";
    	returnValue = false;
    }
    
    if (college === 0) {
    	document.getElementById("acadInfoCollege").className += ' has-warning';
    	document.getElementById("acadInfoCollege").className += ' has-feedback';
    	document.getElementById("collegeInit").className += ' glyphicon glyphicon-warning-sign form-control-feedback';
    	document.getElementById("invalidCollege").style.display = "block";
    	returnValue = false;
    }
    
    if (studNo.length != 10) {
    	document.getElementById("acadInfoStudNo").className += ' has-error';
    	document.getElementById("acadInfoStudNo").className += ' has-feedback';
    	document.getElementById("studNoInit").className += ' glyphicon glyphicon-remove form-control-feedback';
    	document.getElementById("invalidStudNo").style.display = "block";
    	returnValue = false;
    }
    
    
    return returnValue;
}

function resetPassInit() {
	document.getElementById("passInit").className = "";
	document.getElementById("passField").className = "form-group";
}

function resetPassConf() {
	document.getElementById("passConf").className = "";
	document.getElementById("passField").className = "form-group";
}

function resetCol() {
	document.getElementById("collegeInit").className = "";
	document.getElementById("acadInfoCollege").className = "form-group";
}

function resetStudNo() {
	document.getElementById("studNoInit").className = "";
	document.getElementById("acadInfoStudNo").className = "form-group";
}