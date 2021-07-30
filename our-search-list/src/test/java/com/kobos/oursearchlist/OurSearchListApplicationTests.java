package com.kobos.oursearchlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kobos.oursearchlist.model.service.ListService;
import com.kobos.oursearchlist.model.service.MemberService;
import com.kobos.oursearchlist.model.service.YoutubeAPIService;

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
		
		
		
	}

}
