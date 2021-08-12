package com.kobos.oursearchlist.model.service;

import java.util.HashMap;
import java.util.List;

import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

public interface ListService {

	void createFolderToMyYoutubeChannelList(String folderName, String id);

	List<YoutubeChannelVO> getYoutubeChannelListById(String id);

	void addYoutubeChannel(String id, String folderName, String youtubeChannelInfo) throws Exception;

	List<String> getFolderListById(String id);

	List<HashMap<String, String>> getYoutubeChannelListByIdWithMap(String id);

	void deleteChannelFolder(YoutubeChannelVO youtubeChannelVO);

	void deleteChannel(YoutubeChannelVO youtubeChannelVO);

}
