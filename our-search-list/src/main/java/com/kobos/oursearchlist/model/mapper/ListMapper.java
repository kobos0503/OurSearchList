package com.kobos.oursearchlist.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ListMapper {

	void createFolderToMyYoutubeChannelList(Map<String, String> map);

}
