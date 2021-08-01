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

function searchWithChannel(data){
	console.log(data.parentNode.parentNode.parentNode.parentNode.firstChild.nextSibling.value);
	let query=data.parentNode.parentNode.parentNode.parentNode.firstChild.nextSibling.value;
	let url = 'http://www.youtube.com/channel/'+data.value+'/search?query='+query;
	window.open(url);
}