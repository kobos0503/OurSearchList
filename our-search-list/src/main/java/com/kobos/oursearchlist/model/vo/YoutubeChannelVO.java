package com.kobos.oursearchlist.model.vo;

public class YoutubeChannelVO {
	String channelInfo;
	String folderName;
	String id;
	String description;

	public YoutubeChannelVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YoutubeChannelVO(String channelInfo, String folderName, String id, String description) {
		super();
		this.channelInfo = channelInfo;
		this.folderName = folderName;
		this.id = id;
		this.description = description;
	}

	public String getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(String channelInfo) {
		this.channelInfo = channelInfo;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "YoutubeChannelVO [channelInfo=" + channelInfo + ", folderName=" + folderName + ", id=" + id
				+ ", description=" + description + "]";
	}

}
