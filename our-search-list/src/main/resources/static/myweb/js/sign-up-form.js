/**
 * 
 */

window.onload = function() {
	const inputId = document.getElementById("inputId");
	inputId.addEventListener('keyup', () => {
		//console.log(inputId.value);

		if (inputId.value == "") {
			document.getElementById("idConfirm").innerHTML = "<p style='color:black'>아이디를 입력해주세요</p>";
		} else {
			fetch("/user/checkIdDuplicate?id=" + inputId.value)
				.then(response => response.text())
				.then(text => {
					if (text == "ok") {
						document.getElementById("idConfirm").innerHTML = "<p style='color:blue'>사용할 수 있는 아이디 입니다.</p>";
					} else {
						document.getElementById("idConfirm").innerHTML = "<p style='color:red'>중복되는 아이디 입니다.</>";
					}
				})
		}
	})

	const inputPassword = document.getElementById("inputPassword");
	const inputPassword2 = document.getElementById("inputPassword2");
	inputPassword.addEventListener('keyup', () => {
		//console.log(inputPassword.value);
		//console.log(inputPassword2.value);
		let passwordConfirm = document.getElementById("passwordConfirm");
		if (inputPassword.value == "" & inputPassword2.value == "") {
			passwordConfirm.innerHTML = ""
		} else if (inputPassword.value == inputPassword2.value) {
			passwordConfirm.innerHTML = "<p style='color:blue'>비밀번호가 일치합니다.</p>";
		} else if (inputPassword.value != inputPassword2.value & inputPassword.value != "" & inputPassword2.value != "") {
			passwordConfirm.innerHTML = "<p style='color:red'>비밀번호가 불일치합니다.</>";
		}
	})

	inputPassword2.addEventListener('keyup', () => {
		//console.log(inputPassword.value);
		//console.log(inputPassword2.value);
		let passwordConfirm = document.getElementById("passwordConfirm");
		if (inputPassword.value == "" & inputPassword2.value == "") {
			passwordConfirm.innerHTML = ""
		} else if (inputPassword.value == inputPassword2.value) {
			passwordConfirm.innerHTML = "<p style='color:blue'>비밀번호가 일치합니다.</p>";
		} else if (inputPassword.value != inputPassword2.value & inputPassword.value != "" & inputPassword2.value != "") {
			passwordConfirm.innerHTML = "<p style='color:red'>비밀번호가 불일치합니다.</>";
		}
	})

	/*const inputEmail = document.getElementById("inputEmail");
	inputEmail.addEventListener('keyup', () => {
		//console.log(inputEmail.value);

	})*/
}

function signUp() {
	if (document.getElementById("inputId").value == "") {
		alert("아이디를 입력해주세요");
		return false;
	};

	if (document.getElementById("idConfirm").innerText == "중복되는 아이디 입니다.") {
		alert("중복된 아이디 입니다. 다른 아이디를 입력해주세요");
		return false;
	};

	if(document.getElementById("inputPassword").value=="" | document.getElementById("inputPassword2").value==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}

	if (document.getElementById("passwordConfirm").innerText != "비밀번호가 일치합니다.") {
		alert("비밀번호를 다시 확인해주세요");
		return false;
	}

	let signUpSubmit = document.getElementById("signUpSubmit");
	signUpSubmit.submit();
}
