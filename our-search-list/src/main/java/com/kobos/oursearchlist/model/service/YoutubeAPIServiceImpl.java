package com.kobos.oursearchlist.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;


@Service
public class YoutubeAPIServiceImpl implements YoutubeAPIService {
	/**
	 * 유튜브 채널 정보 검색
	 */
	@Override
	public String searchYoutubeChannelInfo(String youtubeURL) throws IOException {

		System.out.println("YoutubeServiceImpl : searchYoutubeChannel");
		// 유저가 입력한 youtubeURL 이 channel type 인지, video type 인지 구분.
		String type = null;
		if (youtubeURL.contains("www.youtube.com/c/") || youtubeURL.contains("www.youtube.com/channel/")) {
			type = "channel";
		} else if (youtubeURL.contains("www.youtube.com/watch")) {
			type = "video";
		}
		//유튜브 API 쿼리 스트링
		String apiurl = "https://www.googleapis.com/youtube/v3/search";
		apiurl += "?key=AIzaSyAc9qohXMlubgv9I8-Mk0SzW6_RrwzGX6A";// api키
		apiurl += "&part=snippet";
		apiurl += "&type=" + type;
		apiurl += "&maxResults=1";
		//apiurl += "&q=" + URLEncoder.encode(youtubeURL, "UTF-8");
		apiurl += "&q=" + youtubeURL;

		System.out.println(apiurl);
		URL url = new URL(apiurl);
		System.out.println(url);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		
		return response.toString();
	}

	/**
	 * 유튜브 비디오 정보 검색
	 */
	public String searchYoutubeVideoInfo(String YoutubeURL) {
		return null;
	}
}
