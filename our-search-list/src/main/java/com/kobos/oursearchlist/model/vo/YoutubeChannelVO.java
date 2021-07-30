package com.kobos.oursearchlist.model.vo;

public class YoutubeChannelVO {

	String folderName;
	String channelId;
	String channelTitle;
	String thumbnailsDefaultURL;
	String thumbnailsMediumURL;
	String thumbnailsHightURL;
	String region_code;

	public YoutubeChannelVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YoutubeChannelVO(String folderName, String channelId, String channelTitle, String thumbnailsDefaultURL,
			String thumbnailsMediumURL, String thumbnailsHightURL, String region_code) {
		super();
		this.folderName = folderName;
		this.channelId = channelId;
		this.channelTitle = channelTitle;
		this.thumbnailsDefaultURL = thumbnailsDefaultURL;
		this.thumbnailsMediumURL = thumbnailsMediumURL;
		this.thumbnailsHightURL = thumbnailsHightURL;
		this.region_code = region_code;
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

	@Override
	public String toString() {
		return "YoutubeChannelVO [folderName=" + folderName + ", channelId=" + channelId + ", channelTitle="
				+ channelTitle + ", thumbnailsDefaultURL=" + thumbnailsDefaultURL + ", thumbnailsMediumURL="
				+ thumbnailsMediumURL + ", thumbnailsHightURL=" + thumbnailsHightURL + ", region_code=" + region_code
				+ "]";
	}

}
