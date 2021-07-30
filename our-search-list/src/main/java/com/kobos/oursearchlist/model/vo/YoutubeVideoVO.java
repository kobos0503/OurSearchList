package com.kobos.oursearchlist.model.vo;

public class YoutubeVideoVO {
	String folderName;
	String channelId;
	String channelTitle;
	String thumbnailsDefaultURL;
	String thumbnailsMediumURL;
	String thumbnailsHightURL;
	String region_code;
	String videoId;
	String title;

	public YoutubeVideoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YoutubeVideoVO(String folderName, String channelId, String channelTitle, String thumbnailsDefaultURL,
			String thumbnailsMediumURL, String thumbnailsHightURL, String region_code, String videoId, String title) {
		super();
		this.folderName = folderName;
		this.channelId = channelId;
		this.channelTitle = channelTitle;
		this.thumbnailsDefaultURL = thumbnailsDefaultURL;
		this.thumbnailsMediumURL = thumbnailsMediumURL;
		this.thumbnailsHightURL = thumbnailsHightURL;
		this.region_code = region_code;
		this.videoId = videoId;
		this.title = title;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
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

	public String getThumbnailsDefaultURL() {
		return thumbnailsDefaultURL;
	}

	public void setThumbnailsDefaultURL(String thumbnailsDefaultURL) {
		this.thumbnailsDefaultURL = thumbnailsDefaultURL;
	}

	public String getThumbnailsMediumURL() {
		return thumbnailsMediumURL;
	}

	public void setThumbnailsMediumURL(String thumbnailsMediumURL) {
		this.thumbnailsMediumURL = thumbnailsMediumURL;
	}

	public String getThumbnailsHightURL() {
		return thumbnailsHightURL;
	}

	public void setThumbnailsHightURL(String thumbnailsHightURL) {
		this.thumbnailsHightURL = thumbnailsHightURL;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "YoutubeVideoVO [folderName=" + folderName + ", channelId=" + channelId + ", channelTitle="
				+ channelTitle + ", thumbnailsDefaultURL=" + thumbnailsDefaultURL + ", thumbnailsMediumURL="
				+ thumbnailsMediumURL + ", thumbnailsHightURL=" + thumbnailsHightURL + ", region_code=" + region_code
				+ ", videoId=" + videoId + ", title=" + title + "]";
	}

}
