package com.kobos.oursearchlist.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

@Mapper
public interface ListMapper {

	void createFolderToMyYoutubeChannelList(Map<String, String> map);

	List<YoutubeChannelVO> getYoutubeChannelListById(String id);

}
