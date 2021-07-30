package com.kobos.oursearchlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//MyYoutubeVideoList 에 관한 컨트롤러
@Controller
public class MyYoutubeVideoListController {
	@RequestMapping("/user/myYoutubeVideoList")
	public String myYoutubeVideoList() {
		System.out.println("myYoutubeVideoList");
		return "my-youtube-video-list";
	} // 유튜브 즐겨찾기 리스트 보여주기
}
