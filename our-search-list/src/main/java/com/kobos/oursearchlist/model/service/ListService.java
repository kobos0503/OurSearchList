package com.kobos.oursearchlist.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kobos.oursearchlist.model.vo.PagingBean;
import com.kobos.oursearchlist.model.vo.PostVO;
import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

public interface ListService {

	void createFolderToMyYoutubeChannelList(String folderName, String id);

	List<YoutubeChannelVO> getYoutubeChannelListById(String id);

	void addYoutubeChannel(String id, String folderName, String youtubeChannelInfo) throws Exception;

	List<String> getFolderListById(String id);

	/*	List<HashMap<String, String>> getYoutubeChannelListByIdWithMap(String id);
	*/
	void deleteChannelFolder(YoutubeChannelVO youtubeChannelVO);

	void deleteChannel(YoutubeChannelVO youtubeChannelVO);

	String getYoutubeChannelListByIdAndFolderName(String id, String folderName);

	void registerPostToOurSearchList(PostVO postVO);

	PagingBean getPagingBean(String nowPage, String postCountPerPage);

	ArrayList<PostVO> getOurYoutubeList(PagingBean pagingBean);

	void addOurYoutubeChannelListToMyYoutubeChannel(String id, String num, String folderName);


}
