package com.kobos.oursearchlist;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kobos.oursearchlist.model.service.ListService;
import com.kobos.oursearchlist.model.service.MemberService;
import com.kobos.oursearchlist.model.service.YoutubeAPIService;
import com.nimbusds.jose.shaded.json.JSONArray;

@SpringBootTest
class OurSearchListApplicationTests {

	@Autowired
	ListService listService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	YoutubeAPIService youtubeAPIService;
	
	@Test
	void contextLoads() {
		
		//listService.createFolderToMyYoutubeChannelList("aa", "1");
		
		//System.out.println(listService.getYoutubeChannelListById("1"));
		
		/*List<HashMap<String, String>> list = listService.getYoutubeChannelListByIdWithMap("1");
		System.out.println(list.get(0).get("folder_name"));
		System.out.println(list.get(0).get("id"));
		String info = list.get(0).get("channel_info");
		try {
			
			JSONObject obj = new JSONObject(info);
			//System.out.println(obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").get("url"));
			
			String regionCode = (String) obj.get("regionCode");
			String title =(String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("title");
			String videoId = (String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("id").get("videoId");
			String thumbnails =(String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").get("url");
			String channelId =(String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("channelId");
			String channelTitle =(String) obj.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").get("channelTitle");
			
			System.out.println(regionCode);
			System.out.println(title);
			System.out.println(videoId);
			System.out.println(thumbnails);
			System.out.println(channelId);
			System.out.println(channelTitle);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(listService.getYoutubeChannelListById("1"));
		System.out.println();
		
		//listService.addYoutubeChannel("1", "aa", "bb");
	}

}
