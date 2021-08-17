package com.kobos.oursearchlist.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobos.oursearchlist.model.mapper.ListMapper;
import com.kobos.oursearchlist.model.vo.PagingBean;
import com.kobos.oursearchlist.model.vo.PostVO;
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
	public String getYoutubeChannelListByIdAndFolderName(String id, String folderName) {
		System.out.println("ListServiceImpl : getYoutubeChannelListByIdAndFolderName");
		List<String> list = listMapper.getYoutubeChannelListByIdAndFolderName(id, folderName);
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			array.put(list.get(i));
		}
		return array.toString();
	}

	/*	@Override
		public List<HashMap<String, String>> getYoutubeChannelListByIdWithMap(String id) {
			System.out.println("ListServiceImpl : getYoutubeChannelListByIdWithMap");
			List<HashMap<String, String>> list = listMapper.getYoutubeChannelListByIdWithMap(id);
			return list;
		}*/

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

	@Override
	public void registerPostToOurSearchList(PostVO postVO) {
		String jsonArray = this.getYoutubeChannelListByIdAndFolderName(postVO.getId(), postVO.getFolderName());
		postVO.setChannelInfo(jsonArray);
		listMapper.registerPostToOurSearchList(postVO);
		// System.out.println(jsonArray);
	}

	@Override
	public ArrayList<PostVO> getOurYoutubeList(PagingBean pagingBean) {
		int startRowNumber = pagingBean.getStartRowNumber();
		int endRowNumber = pagingBean.getEndRowNumber();
		ArrayList<PostVO> list = listMapper.getOurYoutubeList(startRowNumber, endRowNumber);
		return list;
	}

	@Override
	public PagingBean getPagingBean(String nowPage, String postCountPerPage) {
		int totalPostCount = listMapper.getTotalPostCount();
		PagingBean pagingBean = null;
		if (nowPage == null && postCountPerPage == null) {
			pagingBean = new PagingBean(totalPostCount);
		} else if (postCountPerPage == null) {
			pagingBean = new PagingBean(totalPostCount, Integer.parseInt(nowPage));
		} else {
			pagingBean = new PagingBean(totalPostCount, Integer.parseInt(nowPage), Integer.parseInt(postCountPerPage));
		}
		return pagingBean;
	}

	@Override
	public void addOurYoutubeChannelListToMyYoutubeChannel(String id, String num, String folderName) {
		String channelList = listMapper.getOurYoutubeListbyPostNum(num);
		// System.out.println(channelList);
		JSONArray json = new JSONArray(channelList);
		// System.out.println(json.get(0));
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("id", id);
		map2.put("folderName", folderName);
		listMapper.createFolderToMyYoutubeChannelList(map2);
		for (int i = 0; i < json.length(); i++) {
			JSONObject obj = new JSONObject(json.get(i).toString());
			//System.out.println(obj);
			// listMapper.addYoutubeChannel(null);
			String channelId = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("channelId");
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("folderName", folderName);
			map.put("youtubeChannelInfo", obj.toString());
			map.put("channelId", channelId);
			System.out.println(folderName);
			System.out.println(id);
			System.out.println(obj.toString());
			System.out.println(channelId);
			listMapper.addYoutubeChannel(map);
		}
	}

}
