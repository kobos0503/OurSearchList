package com.kobos.oursearchlist.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobos.oursearchlist.model.service.ListService;
import com.kobos.oursearchlist.model.vo.MemberVO;
import com.kobos.oursearchlist.model.vo.PagingBean;
import com.kobos.oursearchlist.model.vo.PostVO;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

//OurYoutubeList 게시판에 관한 컨트롤러
@Controller
public class OurYoutubeListController {
	@Resource
	ListService listService;

	// Our Youtube List
	@RequestMapping("/user/ourYoutubeList")
	public String ourYoutubeList(@Nullable String nowPage, @Nullable String postCountPerPage, Model model) {
		System.out.println("OurYoutubeListController : ourYoutubeList");
		PagingBean pagingBean = listService.getPagingBean(nowPage, postCountPerPage);
		ArrayList<PostVO> list = listService.getOurYoutubeList(pagingBean);
		model.addAttribute("pagingBean", pagingBean);
		model.addAttribute("list", list);
		return "our-youtube-list";
	}

	// 글쓰기 폼
	@RequestMapping("/ourYoutubePostWriteForm")
	public String ourYoutubePostWriteForm(Model model) {
		System.out.println("OurYoutubeListController : ourYoutubePostWriteForm");
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		model.addAttribute("folderList", listService.getFolderListById(id));
		return "our-youtube-post-write-form";
	}

	// 글쓰기 폼에서 폴더별 채널 가져오기
	@ResponseBody
	@RequestMapping("getYoutubeChannelListByIdAndFolderName")
	public String getYoutubeChannelListByIdAndFolderName(String folderName) {
		System.out.println("OurYoutubeListController : getYoutubeChannelListByIdAndFolderName");
		// System.out.println(folderName);
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		return listService.getYoutubeChannelListByIdAndFolderName(id, folderName);
	}

	// 글 작성하기
	@PostMapping("registerPostToOurSearchList")
	public String registerPostToOurSearchList(String title, String content, String folderName) {
		System.out.println("OurYoutubeListController : registerPostToOurSearchList");
		// System.out.println(title+content+folderName);
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();

		PostVO postVO = new PostVO();
		postVO.setId(id);
		postVO.setTitle(title);
		postVO.setContent(content);
		postVO.setFolderName(folderName);
		postVO.setRecommendType("channel");
		listService.registerPostToOurSearchList(postVO);

		return "redirect:/user/ourYoutubeList";
	}

	// 채널 가져가기
	@PostMapping("/addOurYoutubeChannelListToMyYoutubeChannel")
	public String addOurYoutubeChannelListToMyYoutubeChannel(String num, String folderName) {
		System.out.println("OurYoutubeListController : addOurYoutubeChannelListToMyYoutubeChannel");
		// 로그인한 유저 정보 가져오기
		MemberVO memberVO = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = memberVO.getId();
		listService.addOurYoutubeChannelListToMyYoutubeChannel(id, num, folderName);
		return "redirect:/user/ourYoutubeList";
	}
}
