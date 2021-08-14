/**
 * 
 */

/*window.onload = function(){
	let folderList = document.getElementById('folderList').value;
	let channelList = document.getElementById('channelList').value;
	let obj = JSON.parse(channelList);
	console.log(folderList);
	console.log(channelList);
	console.log(obj.items[0].snippet);
	console.log(obj.items[0].snippet.channelId);
	console.log(obj.items[0].snippet.channelTitle);
	console.log(obj.items[0].snippet.thumbnails.default.url);
	console.log(obj.items[0].snippet.channelId);
}*/

function searchWithChannel(data) {
	//console.log(data.nextElementSibling);
	//console.log(data.parentNode.parentNode.parentNode.parentNode.firstChild.nextSibling.value);
	//let query=data.parentNode.parentNode.parentNode.parentNode.firstChild.nextSibling.value;
	//let query = document.getElementById();
	//let queryId =  'query'+data.nextElementSibling.value;
	//console.log(queryId);
	let query = document.getElementById('query' + data.nextElementSibling.value).value;
	console.log(query)
	let url = 'http://www.youtube.com/channel/' + data.value + '/search?query=' + query;
	window.open(url);
}

function serchWithAllChannels(data) {
	//console.log(data.value+'channelTitle');
	let channelTitleList = document.getElementsByName((data.value + 'channelTitle'));
	//console.log(channelTitleList);
	//let query = document.getElementById('query'+data.value).value;
	//console.log(query);
	let channel = "";
	for (let i = 0; i < channelTitleList.length; i++) {
		//console.log(channelTitleList[i].value);
		if (i != channelTitleList.length - 1) {
			//channel += "\"" + channelTitleList[i].value.replace(/(\s*)/g, "") + "\"" + "|";
			channel += "\"" + channelTitleList[i].value + "\"" + "|";
		} else if (i == channelTitleList.length - 1) {
			//channel += "\"" + channelTitleList[i].value.replace(/(\s*)/g, "") + "\"";
			channel += "\"" + channelTitleList[i].value + "\"";
		}
	}
	//console.log(channel);
	let folderName = data.value;
	let query = document.getElementById('query' + folderName).value;
	let url = 'https://www.youtube.com/results?search_query=' + '(' + channel + ')' + '%26' + query;
	//let url = 'https://www.youtube.com/results?search_query=' + '(' + channel + ')'+ query;
	//console.log(url);
	window.open(url);
}

function addYoutubeChannel() {
	let youtubeURL = document.getElementById('youtubeURL').value;
	let folderName = document.getElementById('folderName').value;
	//console.log(youtubeURL);
	//console.log(folderName);
	$.ajax({
		type: "post",
		url: "/addYoutubeChannel",
		data: { "youtubeURL": youtubeURL, "folderName": folderName },
		success: function(result) {
			alert(result);
		}//success
	});//ajax
}

function createFolderToMyYoutubeChannelList() {
	let folderList = document.getElementsByName("folderNameList");
	//console.log(folderList[0].innerText);
	let newFolderName = document.getElementById("newFolderName").value;
	console.log(newFolderName);
	for(let i=0;i<folderList.length;i++){
		if(folderList[i].innerText==newFolderName){
			alert("폴더명이 중복됩니다.");
			return false;
		}
	}
	document.getElementById("createFolderForm").submit();
}

function addYoutubeChannel() {
	
	document.getElementById("addYoutubeChannel").submit();
}

function deleteChannelFolder(data) {
	//console.log(data.value);
	//document.getElementById("deleteChannelFolder").submit();
	if (confirm(data.value + " 폴더를 삭제하시겠습니까?")) {
		data.nextElementSibling.submit();
	}

}

function deleteChannel(data) {
	//console.log(data);
	//document.getElementById("deleteChannel").submit();
	data.nextElementSibling.nextElementSibling.submit();


}