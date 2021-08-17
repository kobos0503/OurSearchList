package com.kobos.oursearchlist.model.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kobos.oursearchlist.model.vo.PagingBean;
import com.kobos.oursearchlist.model.vo.PostVO;
import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

@Mapper
public interface ListMapper {

	void createFolderToMyYoutubeChannelList(Map<String, String> map);

	List<YoutubeChannelVO> getYoutubeChannelListById(String id);

	void addYoutubeChannel(Map<String, String> map);

	List<String> getFolderListById(String id);

	List<HashMap<String, String>> getYoutubeChannelListByIdWithMap(String id);

	void deleteChannelFolder(YoutubeChannelVO youtubeChannelVO);

	void deleteChannel(YoutubeChannelVO youtubeChannelVO);

	List<String> getYoutubeChannelListByIdAndFolderName(String id, String folderName);

	void registerPostToOurSearchList(PostVO postVO);

	int getTotalPostCount();

	ArrayList<PostVO> getOurYoutubeList(int startRowNumber, int endRowNumber);

	String getOurYoutubeListbyPostNum(String num);



}
