package com.kobos.oursearchlist.model.service;

import java.util.List;

import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

public interface ListService {

	void createFolderToMyYoutubeChannelList(String folderName, String id);

	List<YoutubeChannelVO> getYoutubeChannelListById(String id);

	void addYoutubeChannel(String id, String folderName, String youtubeChannelInfo);

	List<String> getFolderListById(String id);

}
