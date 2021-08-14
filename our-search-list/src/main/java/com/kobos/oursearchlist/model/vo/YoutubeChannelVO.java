package com.kobos.oursearchlist.model.vo;

public class YoutubeChannelVO {
	String id;
	String folderName;
	String channelInfo;
	String channelId;
	String channelTitle;
	String thumbnails;
	String regionCode;
	String description;

	public YoutubeChannelVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YoutubeChannelVO(String id, String folderName, String channelInfo, String channelId, String channelTitle,
			String thumbnails, String regionCode, String description) {
		super();
		this.id = id;
		this.folderName = folderName;
		this.channelInfo = channelInfo;
		this.channelId = channelId;
		this.channelTitle = channelTitle;
		this.thumbnails = thumbnails;
		this.regionCode = regionCode;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(String channelInfo) {
		this.channelInfo = channelInfo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "YoutubeChannelVO [id=" + id + ", folderName=" + folderName + ", channelInfo=" + channelInfo
				+ ", channelId=" + channelId + ", channelTitle=" + channelTitle + ", thumbnails=" + thumbnails
				+ ", regionCode=" + regionCode + ", description=" + description + "]";
	}

}
