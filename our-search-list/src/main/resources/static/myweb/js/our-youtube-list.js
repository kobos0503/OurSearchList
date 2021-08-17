/**
 * 
 */
function getYoutubeChannelListByIdAndFolderName(folderName) {
	//console.log(data.value);
	let selectedFolderName = document.getElementById("selectedFolderName");
	let parent = document.getElementById("myChannelListByFolderName");

	fetch("/getYoutubeChannelListByIdAndFolderName?folderName=" + folderName.value)
		.then(response => response.json())
		//.then(data => console.log(data))
		.then(json => {
			parent.innerHTML = "";
			selectedFolderName.value = "";
			for (let i = 0; i < json.length; i++) {
				//console.log(json.length);
				//console.log(json);
				//console.log(json[0]);
				//console.log(JSON.parse(json[0]).items[0].snippet.channelId);
				//console.log(JSON.parse(json[0]).items[0].snippet.title);
				//console.log(JSON.parse(json[0]).items[0].snippet.thumbnails.default.url);
				let jsonArray = JSON.parse(json[i]).items[0];
				//console.log(jsonArray.snippet.channelId);
				//console.log(jsonArray.snippet.title);
				//console.log(jsonArray.snippet.thumbnails.default.url);
				//console.log(parent);
				let channel = document.createElement("span");
				channel.innerHTML = "<br><button onclick='window.open(\"http://www.youtube.com/channel/" + jsonArray.snippet.channelId + "\")'><img style='width:30px;height:30px' src='"  + jsonArray.snippet.thumbnails.default.url + "'>" +  jsonArray.snippet.title + "</button><br><br>";
				parent.append(channel);
				selectedFolderName.value = folderName.value;
			}//for
			console.log(selectedFolderName.value);
		})
}

function postSubmit() {
	if (document.getElementById("title").value == "") {
		alert("제목을 입력해주세요");
		return false;
	} else if (document.getElementById("content").value == "") {
		alert("내용을 입력해 주세요");
		return false;
	} else if (document.getElementById("selectedFolderName").value == "") {
		alert("추천하실 폴더를 선택해주세요");
		return false;
	}
	document.getElementById("postSubmit").submit;
}

function addOurYoutubeChannelListToMyYoutubeChannel(data){
	if(confirm("채널을 가져가시겠습니까?")){
		//alert(data.value);
		let addChannelSubmit = data.parentNode;
		console.log(addChannelSubmit);
		addChannelSubmit.submit();
	}
}
