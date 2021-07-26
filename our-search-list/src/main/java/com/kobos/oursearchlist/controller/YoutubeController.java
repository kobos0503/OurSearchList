package com.kobos.oursearchlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoutubeController {

	// 유튜브 즐겨찾기 리스트 보여주기
	@RequestMapping("/user/addYoutubeChannelVideo")
	public String addYoutubeChannelVideo() {
		System.out.println("addYoutubeChannelVideo");
		return "add-youtube-channel-video";
	}

	// 유튜브 즐겨찾기 리스트 보여주기
	@RequestMapping("/user/myYoutubeChannelList")
	public String myYoutubeChannelList() {
		System.out.println("myYoutubeChannelList");
		return "my-youtube-channel-list";
	} // 유튜브 즐겨찾기 리스트 보여주기

	@RequestMapping("/user/myYoutubeVideoList")
	public String myYoutubeVideoList() {
		System.out.println("myYoutubeVideoList");
		return "my-youtube-video-list";
	} // 유튜브 즐겨찾기 리스트 보여주기

	@RequestMapping("/user/ourYoutubeList")
	public String ourYoutubeList() {
		System.out.println("ourYoutubeList");
		return "our-youtube-list";
	}

}
