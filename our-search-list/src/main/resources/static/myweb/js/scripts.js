/*!
* Start Bootstrap - Simple Sidebar v6.0.2 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {
	// Toggle the side navigation
	const sidebarToggle = document.body.querySelector('#sidebarToggle');
	if (sidebarToggle) {
		// Uncomment Below to persist sidebar toggle between refreshes
		// if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
		//     document.body.classList.toggle('sb-sidenav-toggled');
		// }
		sidebarToggle.addEventListener('click', event => {
			event.preventDefault();
			document.body.classList.toggle('sb-sidenav-toggled');
			localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
		});
	}
});


function startEditMode() {
	//수정모드 돌입
	if (document.getElementById('saveList').style.display == 'none') {
		document.getElementById('saveList').style.display = 'block';
		document.getElementById('editList').style.display = 'none';
		let normalList = document.getElementsByClassName('normal-mode');
		for (let i = 0; i < normalList.length; i++) {
			normalList[i].style.display = 'none';
		}
		let editList = document.getElementsByClassName('edit-mode');
		for (let j = 0; j < editList.length; j++) {
			editList[j].style.display = 'block';
		}
		//저장버튼 클릭
	} else {
		document.getElementById('saveList').style.display = 'none';
		document.getElementById('editList').style.display = 'block';
		let normalList = document.getElementsByClassName('normal-mode');
		for (let i = 0; i < normalList.length; i++) {
			normalList[i].style.display = 'block';
		}
		let editList = document.getElementsByClassName('edit-mode');
		for (let j = 0; j < editList.length; j++) {
			editList[j].style.display = 'none';
		}
	}
}

function up(list) {
	//document.getElementById().parentElement
	alert(list.parentElement);
}
function down() {

}

/*
var $ul = $('ul')

$('.up').click(function () {
	var $li = $( this ).parent();

	if ( $li.is(':first-child') )
		$ul.append($li);
	else 
		$li.insertBefore($li.prev());
});

$('.down').click(function () {
	var $li = $( this ).parent();

	if ( $li.is(':last-child') )
		$ul.prepend( $li );        
	else
		$li.insertAfter($li.next());
});*/
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

function addYoutubeChannel() {
	let youtubeURL = document.getElementById('youtubeURL').value;
	let folderName = document.getElementById('folderName').value;
	//console.log(youtubeURL);
	//console.log(folderName);
	$.ajax({
		type: "post",
		url: "/addYoutubeChannel",
		data: {"youtubeURL" : youtubeURL, "folderName" : folderName},
		success: function(result) {
			alert(result);
		}//success
	});//ajax
}

function createFolderToMyYoutubeChannelList(){
	document.getElementById("createFolderForm").submit();
}

function addYoutubeChannel(){
	document.getElementById("addYoutubeChannel").submit();
}