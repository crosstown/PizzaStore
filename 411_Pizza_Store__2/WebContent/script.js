function checkUserCookie() {
	var userName = getCookie("userName");
	var password = getCookie("password");
	if (userName != "") {
		// alert("Welcome again " + firstName + "!");
		document.getElementById("un").value = userName;
		document.getElementById("pw").value = password;
	} else {
		// firstName = prompt("Enter Name:","<first name only>");
		// if (userName != "" && userName != null) {
		// setCookie("userName", userName, 2);
		document.getElementById("un").value = userName; // }
	}
}
function getCookie(cookieName) {
	var name = cookieName + "=";
	var cookies = document.cookie.split(';');
	for (var i = 0; i < cookies.length; i++) {
		var cookie = cookies[i];
		while (cookie.charAt(0) == ' ')
			cookie = cookie.substring(1);
		if (cookie.indexOf(name) == 0) {
			return cookie.substring(name.length, cookie.length);
		}
	}
	return "";
}
function setCookie(cookieName, cookieValue, cookieDays) {
	var date = new Date();
	date.setTime(date.getTime() + cookieDays * 24 * 60 * 60 * 1000);

	var expires = "expires=" + date.toGMTString();
	document.cookie = cookieName + "=" + cookieValue + "; " + expires;
}
function setAllCookies() {
	if (document.frmData.userName != "")
		setCookie("userName", document.frmData.userName.value, 7);
	if (document.frmData.userName != "")
		setCookie("password", document.frmData.password.value, 7);
	document.getElementById("myform").submit();
//	window.location.assign("products.htm");

}
function clearCookies() {
	var cookies = document.cookie.split(';');
	var eq;
	var name;
	for (i = 0; i < cookies.length; i++) {
		eqIndex = cookies[i].indexOf("=");
		name = cookies[i].substring(0, eval(eqIndex));
		setCookie(name, "", new Date(2015, 1, 1));
	}
	document.getElementById("myForm").reset();
}
function generateCookieTable() {
	var cookies = document.cookie.split(';');
	var eq;
	var name;
	var value;
	for (i = 0; i < cookies.length; i++) {
		eqIndex = cookies[i].indexOf("=");
		name = cookies[i].substring(0, eval(eqIndex));
		value = cookies[i].substring(eval(eqIndex) + 1);
		if (name.indexOf('userName') != -1)
			document.getElementById("un").value = value;
		if (name.indexOf('password') != -1)
			document.getElementById("pw").value = value;
	}
}
function printUser() {
	var firstName = getCookie("userName");
	var info = getCookie("info");
	if (firstName != "") {
		// alert("Paso");
		document.getElementById("greeting").innerHTML = "Hello " + firstName +",";
	}
	if (info != "") {
		if (info == "Beer") {
			document.frmProducts.radio[0].checked = true;
		}
		if (info == "Bread") {
			document.frmProducts.radio[1].checked = true;
		}
		if (info == "Milk") {
			document.frmProducts.radio[2].checked = true;
		}
		if (info == "Wine") {
			document.frmProducts.radio[3].checked = true;
		}
	}
	
}
function printInfo() {
	var firstName = getCookie("userName");
	if (firstName != "") {
		document.getElementById("greeting").innerHTML = "Hello " + firstName
				+ ",";
	}

}
function printInfo2() {
	var firstName = getCookie("userName");
	if (firstName != "") {
		document.getElementById("greeting").innerHTML = "Hello " + firstName
				+ ",";
	}
	var info = getCookie("info");
	if (info != "") {
		document.getElementById("prod").innerHTML = info;

	}
}

function check() {
	var radio1 = document.getElementById("radio1").checked;
	if (radio1) {
		setCookie("info", document.getElementById("beer").innerHTML);
	}
	var radio2 = document.getElementById("radio2").checked;
	if (radio2) {
		setCookie("info", document.getElementById("bread").innerHTML);
	}
	var radio3 = document.getElementById("radio3").checked;
	if (radio3) {
		setCookie("info", document.getElementById("milk").innerHTML);
	}
	var radio4 = document.getElementById("radio4").checked;
	if (radio4) {
		setCookie("info", document.getElementById("wine").innerHTML);
	}

}

function saveProduct() {
	check();
	window.location.assign("info.htm");
}
function backToPage1() {
	window.location.assign("index.htm");
}
function backToPage2() {
	window.location.assign("products.htm");
}
function forgetProduct() {
	var info = getCookie("info");
	if (info != "") {
		setCookie("info", "", new Date(2015, 1, 1));
		window.location.assign("products.htm");
	}

}
function checkForm() {
	var user = document.getElementById("un").value;
	var password = document.getElementById("pw").value;
	if (user != "") {
		if (password != "") {
			setAllCookies();
		} else {
			document.getElementsByName("password")[0].value = "";
			document.getElementsByName("password")[0].placeholder = "Password needed!";
		}
	} else {
		document.getElementsByName("userName")[0].value = "";
		document.getElementsByName("userName")[0].placeholder = "Username needed!";
	}

}
function remOption() {
	check();
}
function seeProduct() {
	window.location.assign("info.htm");
}
