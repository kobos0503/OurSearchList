package com.kobos.oursearchlist.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobos.oursearchlist.model.service.MemberService;
import com.kobos.oursearchlist.model.vo.MemberVO;
//로그인, 로그아웃, 회원가입에 대한 컨트롤러
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/accessDeniedView")
	public String accessDeniedView() {
		System.out.println("MemberController : accessDeniedView");
		return "sign-in-form";
	}
	
	// 로그인 폼
	@RequestMapping("/user/signInForm")
	public String loginForm() {
		System.out.println("MemberController : signInForm");
		return "sign-in-form";
	}

	// 구글 로그인 성공
	@RequestMapping("/loginSuccess")
	public String googleAuth(@AuthenticationPrincipal OAuth2User principal) throws Exception {
		System.out.println("MemberController : google login : " + principal);
		return "index";
	}
	
	// 로그인 실패
	@RequestMapping("/user/signInFormFail")
	public String signInFormFail() {
		return "sign-in-form-fail";
	}
	
	// 회원가입 폼
	@RequestMapping("/user/signUpForm")
	public String signUpForm() {
		System.out.println("MemberController : signUpForm");
		return "sign-up-form";
	}

	// 회원가입 하기
	@PostMapping("/user/signUp")
	public String signup(MemberVO memberVO) {
		System.out.println("MemberController : signup");
		memberVO.setCertified(certified_key());
		memberService.registerMember(memberVO);
		System.out.println("sigin up : " + memberVO);
		return "redirect:/user/signInForm";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping("/user/checkIdDuplicate")
	public String checkIdDuplicate(String id) {
		System.out.println("MemberController : checkIdDuplicate");
		String result = memberService.idcheck(id);
		return result;
	}
	
	
	// 회원가입 인증 이메일용 난수 키 만들기
	private String certified_key() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;
		do {
			num = random.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}
		} while (sb.length() < 10);
		return sb.toString();
	}

}
