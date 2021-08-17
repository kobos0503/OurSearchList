package com.kobos.oursearchlist.model.vo;

import java.util.Date;

public class PostVO {
	int num;
	String title;
	String content;
	String channelInfo;
	String folderName;
	Date postingDate;
	String recommendType;
	int hits;
	int likes;
	int certified;
	String id;
	String nickname;

	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PostVO [num=" + num + ", title=" + title + ", content=" + content + ", channelInfo=" + channelInfo
				+ ", folderName=" + folderName + ", postingDate=" + postingDate + ", recommendType=" + recommendType
				+ ", hits=" + hits + ", likes=" + likes + ", certified=" + certified + ", id=" + id + ", nickname="
				+ nickname + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getCertified() {
		return certified;
	}

	public void setCertified(int certified) {
		this.certified = certified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public PostVO(int num, String title, String content, String channelInfo, String folderName, Date postingDate,
			String recommendType, int hits, int likes, int certified, String id, String nickname) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.channelInfo = channelInfo;
		this.folderName = folderName;
		this.postingDate = postingDate;
		this.recommendType = recommendType;
		this.hits = hits;
		this.likes = likes;
		this.certified = certified;
		this.id = id;
		this.nickname = nickname;
	}

}
