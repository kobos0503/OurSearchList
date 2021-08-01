package com.kobos.oursearchlist.model.vo;

public class YoutubeChannelVO {
	String folderName;
	String id;
	String description;
	String channelInfo;
	String regionCode;
	String title;
	String videoId;
	String thumbnails;
	String channelId;
	String channelTitle;

	public YoutubeChannelVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YoutubeChannelVO(String folderName, String id, String description, String channelInfo, String regionCode,
			String title, String videoId, String thumbnails, String channelId, String channelTitle) {
		super();
		this.folderName = folderName;
		this.id = id;
		this.description = description;
		this.channelInfo = channelInfo;
		this.regionCode = regionCode;
		this.title = title;
		this.videoId = videoId;
		this.thumbnails = thumbnails;
		this.channelId = channelId;
		this.channelTitle = channelTitle;
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

	public String getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(String channelInfo) {
		this.channelInfo = channelInfo;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
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

	@Override
	public String toString() {
		return "YoutubeChannelVO [folderName=" + folderName + ", id=" + id + ", description=" + description
				+ ", channelInfo=" + channelInfo + ", regionCode=" + regionCode + ", title=" + title + ", videoId="
				+ videoId + ", thumbnails=" + thumbnails + ", channelId=" + channelId + ", channelTitle=" + channelTitle
				+ "]";
	}

}
