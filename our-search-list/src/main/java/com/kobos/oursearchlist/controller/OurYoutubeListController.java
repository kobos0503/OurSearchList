package com.kobos.oursearchlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//OurYoutubeList 게시판에 관한 컨트롤러
@Controller
public class OurYoutubeListController {
	@RequestMapping("/user/ourYoutubeList")
	public String ourYoutubeList() {
		System.out.println("ourYoutubeList");
		return "our-youtube-list";
	}
}
