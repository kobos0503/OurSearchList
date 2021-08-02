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
			channel += "\"" + channelTitleList[i].value.trim() + "\"" + "|";
		} else if (i == channelTitleList.length - 1) {
			channel += "\"" + channelTitleList[i].value.trim() + "\"";
		}
	}
	//console.log(channel);
	let folderName = data.value;
	let query = document.getElementById('query' + folderName).value;
	let url = 'https://www.youtube.com/results?search_query=' + '(' + channel + ')' + '%26' +"\""+ query+"\"";
	//console.log(url);
	window.open(url);
}