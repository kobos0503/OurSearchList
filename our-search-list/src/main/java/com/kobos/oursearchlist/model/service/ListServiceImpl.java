package com.kobos.oursearchlist.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobos.oursearchlist.model.mapper.ListMapper;
import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

@Service
public class ListServiceImpl implements ListService {
	@Autowired
	ListMapper listMapper;

	@Override
	public void createFolderToMyYoutubeChannelList(String folderName, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("folderName", folderName);
		map.put("id", id);
		listMapper.createFolderToMyYoutubeChannelList(map);
	}

	@Override
	public List<YoutubeChannelVO> getYoutubeChannelListById(String id) {
		List<YoutubeChannelVO> list = listMapper.getYoutubeChannelListById(id);
		return list;
	}

	@Override
	public void addYoutubeChannel(String id, String folderName, String youtubeChannelInfo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("folderName", folderName);
		map.put("youtubeChannelInfo", youtubeChannelInfo);
		listMapper.addYoutubeChannel(map);
	}
	
	@Override
	public List<String> getFolderListById(String id) {
		List<String> list = listMapper.getFolderListById(id);
		return list;
	}
	
}
