/**
 * 
 */

function signIn() {
	if (document.getElementById("inputId").value=="") {
		alert("아이디를 입력해주세요");
		return false;
	};

	if (document.getElementById("inputPassword").value=="") {
		alert("비밀번호를 다시 확인해주세요");
		return false;
	}

	let signInSubmit = document.getElementById("signInSubmit");
	
	signInSubmit.submit();
	
}
