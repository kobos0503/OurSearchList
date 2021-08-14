package com.kobos.oursearchlist.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
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
		System.out.println("ListServiceImpl : createFolderToMyYoutubeChannelList");
		Map<String, String> map = new HashMap<String, String>();
		map.put("folderName", folderName);
		map.put("id", id);
		listMapper.createFolderToMyYoutubeChannelList(map);
	}

	@Override
	public List<YoutubeChannelVO> getYoutubeChannelListById(String id) {
		System.out.println("ListServiceImpl : getYoutubeChannelListById");
		List<YoutubeChannelVO> list = listMapper.getYoutubeChannelListById(id);
		for (int i = 0; i < list.size(); i++) {
			String channelInfo = list.get(i).getChannelInfo();
			JSONObject obj = new JSONObject(channelInfo);
			String regionCode = (String) obj.get("regionCode");
			/*String title =(String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("title");
			String videoId = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("id").get("videoId");*/
			String thumbnails = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet")
					.getJSONObject("thumbnails").getJSONObject("default").get("url");
			String channelId = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet")
					.get("channelId");
			String channelTitle = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet")
					.get("channelTitle");
			list.get(i).setChannelId(channelId);
			list.get(i).setChannelTitle(channelTitle);
			list.get(i).setRegionCode(regionCode);
			list.get(i).setThumbnails(thumbnails);
			/*list.get(i).setTitle(title);
			list.get(i).setVideoId(videoId);*/
		}
		return list;
	}

	@Override
	public List<HashMap<String, String>> getYoutubeChannelListByIdWithMap(String id) {
		System.out.println("ListServiceImpl : getYoutubeChannelListByIdWithMap");
		List<HashMap<String, String>> list = listMapper.getYoutubeChannelListByIdWithMap(id);
		return list;
	}

	@Override
	public void addYoutubeChannel(String id, String folderName, String youtubeChannelInfo) throws Exception {
		System.out.println("ListServiceImpl : addYoutubeChannel");
		JSONObject obj = new JSONObject(youtubeChannelInfo);
		String channelId = null;
		try {
			channelId = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("channelId");
		} catch (Exception e) {
			throw new Exception("존재하지 않는 채널입니다. 조금 더 정확한 채널명을 입력해주세요.");
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("folderName", folderName);
		map.put("youtubeChannelInfo", youtubeChannelInfo);
		map.put("channelId", channelId);
		try {
			listMapper.addYoutubeChannel(map);
		} catch (Exception e) {
			throw new Exception("중복되는 채널입니다. 폴더에 동일한 채널이 있어요.");
		}
	}

	@Override
	public List<String> getFolderListById(String id) {
		System.out.println("ListServiceImpl : getFolderListById");
		List<String> list = listMapper.getFolderListById(id);
		return list;
	}

	@Override
	public void deleteChannelFolder(YoutubeChannelVO youtubeChannelVO) {
		System.out.println("ListServiceImpl : deleteChannelFolder");
		listMapper.deleteChannelFolder(youtubeChannelVO);
	}

	@Override
	public void deleteChannel(YoutubeChannelVO youtubeChannelVO) {
		System.out.println("ListServiceImpl : deleteChannel");
		listMapper.deleteChannel(youtubeChannelVO);
	}

}
