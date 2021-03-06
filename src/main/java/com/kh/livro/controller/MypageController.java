package com.kh.livro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.livro.biz.DonationBiz;
import com.kh.livro.biz.MypageBIz;

@Controller
public class MypageController {

	@Autowired
	private MypageBIz mypageBiz;

	@Autowired
	private DonationBiz donationBiz;
	
	private Logger logger = LoggerFactory.getLogger(MypageController.class);

	// 마이페이지 인덱스 : 관리자로 갈건지 일반유저로 갈건지
	@RequestMapping("/mypageIndex.do")
	public String indexPage() {
		return "mypage/mypageIndex";
	}

	// 일반유저 페이지로 이동
	@RequestMapping("/userPage.do")
	public String userPage(Model model, String member_id) {
		model.addAttribute("profiledto", mypageBiz.selectProfile(member_id));
		model.addAttribute("followdto", mypageBiz.showFollow(member_id));
		return "mypage/userPage";
	}

	// 아티스트 페이지로 이동
	@RequestMapping("/artistPage.do")
	public String artistPage(Model model, String member_id) {
		model.addAttribute("profiledto", mypageBiz.selectProfile(member_id));
		model.addAttribute("followdto", mypageBiz.showFollow(member_id));
		model.addAttribute("followerdto", mypageBiz.showFollower(member_id));
		model.addAttribute("rankdto", mypageBiz.countNrank(member_id));
		return "mypage/artistPage";
	}

}