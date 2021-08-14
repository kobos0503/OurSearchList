package com.kobos.oursearchlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kobos.oursearchlist.model.service.ListService;
import com.kobos.oursearchlist.model.service.YoutubeAPIService;
import com.kobos.oursearchlist.model.vo.MemberVO;
import com.kobos.oursearchlist.model.vo.YoutubeChannelVO;

//MyYoutubeChannelLinst, MyYoutubeVideoList 에 관한 컨트롤러
@Controller
public class MyYoutubeChannelListController {
	@Autowired
	YoutubeAPIService youtubeAPIService;

	@Autowired
	ListService listService;

	// 유튜브 즐겨찾기 리스트 보여주기
	@RequestMapping("/user/myYoutubeChannelList")
	public String myYoutubeChannelList(Model model) {
		System.out.println("MyYoutubeChannelListController : myYoutubeChannelList");
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			return "my-youtube-channel-list";
		} else {
			MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String id = memberVO.getId();
			List<String> folderList = listService.getFolderListById(id);
			List<YoutubeChannelVO> channelList = listService.getYoutubeChannelListById(id);
			model.addAttribute("folderList", folderList);
			model.addAttribute("channelList", channelList);
			return "my-youtube-channel-list";
		}
	}

	// 폴더 추가
	@PostMapping("/createFolderToMyYoutubeChannelList")
	public String createFolderToMyYoutubeChannelList(String folderName, Model model) {
		System.out.println("MyYoutubeChannelListController : createFolderToMyYoutubeChannelList");
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		listService.createFolderToMyYoutubeChannelList(folderName, id);
		return "redirect:user/myYoutubeChannelList";
	}
	
	// 채널 추가
	@PostMapping("/addYoutubeChannel")
	public String addYoutubeChannel(String youtubeURL, String folderName, Model model) {
		System.out.println("YoutubeController : /addYoutubeChannel");
		// youtube api 로 채널 정보 가져오기
		String youtubeChannelInfo = null;
		try {
			youtubeChannelInfo = youtubeAPIService.searchYoutubeChannelInfo(youtubeURL);
			// 로그인한 유저 정보 가져오기
			MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String id = memberVO.getId();
			// 유저 테이블에 채널 정보 넣기
			listService.addYoutubeChannel(id, folderName, youtubeChannelInfo);
			return "redirect:user/myYoutubeChannelList";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			//System.out.println(e.getMessage());
			return "add-youtube-channel-fail";
		}
	}
	
	// 폴더 삭제
	@PostMapping("/deleteChannelFolder")
	public String deleteChannelFolder(YoutubeChannelVO youtubeChannelVO) {
		System.out.println("YoutubeController : /deleteChannelFolder");
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		youtubeChannelVO.setId(id);
		// System.out.println(youtubeChannelVO);
		listService.deleteChannelFolder(youtubeChannelVO);
		return "redirect:user/myYoutubeChannelList";
	}

	// 채널 삭제
	@PostMapping("/deleteChannel")
	public String deleteChannel(YoutubeChannelVO youtubeChannelVO) {
		System.out.println("YoutubeController : /deleteChannel");
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		youtubeChannelVO.setId(id);
		// System.out.println(youtubeChannelVO);
		listService.deleteChannel(youtubeChannelVO);
		return "redirect:user/myYoutubeChannelList";
	}

	// 유튜브 채널 등록, ajax, 미사용
	/*@ResponseBody
	@PostMapping("/addYoutubeChannel")
	public String addYoutubeChannel(String youtubeURL, String folderName) {
		System.out.println("YoutubeController : /addYoutubeChannel");
		// System.out.println(youtubeURL);
		// youtube api 로 채널 정보 가져오기
		String youtubeChannelInfo = null;
		try {
			youtubeChannelInfo = youtubeAPIService.searchYoutubeChannelInfo(youtubeURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		// 유저 테이블에 채널 정보 넣기
	
		System.out.println(youtubeChannelInfo);
		return youtubeChannelInfo;
	}*/

}
