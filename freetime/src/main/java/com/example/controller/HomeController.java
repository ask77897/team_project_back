package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello.............";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("pageName", "about");
		return "home";
	}

	@GetMapping("/display")
	public ResponseEntity<Resource> display(String file) {
		Resource resource = new FileSystemResource("c:" + file);
		if (!resource.exists())
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		HttpHeaders header = new HttpHeaders();
		try {
			Path filePath = Paths.get("c:" + file);
			header.add("Content-type", Files.probeContentType(filePath));
		} catch (Exception e) {
			System.out.println("오류:" + e.toString());
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	  KakaoAPI kakaoApi = new KakaoAPI();

	    @RequestMapping(value="/login")
	    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
	        ModelAndView mav = new ModelAndView();
	        // 1번 인증코드 요청 전달
	        String accessToken = kakaoApi.getAccessToken(code);
	        // 2번 인증코드로 토큰 전달
	        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);

	        System.out.println("login info : " + userInfo.toString());

	        if(userInfo.get("email") != null) {
	            session.setAttribute("userId", userInfo.get("email"));
	            session.setAttribute("accessToken", accessToken);
	        }
	        mav.addObject("userId", userInfo.get("email"));
	        mav.setViewName("index");
	        return mav;
	    }

	    @RequestMapping(value="/logout")
	    public ModelAndView logout(HttpSession session) {
	        ModelAndView mav = new ModelAndView();

	        kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
	        session.removeAttribute("accessToken");
	        session.removeAttribute("userId");
	        mav.setViewName("index");
	        return mav;
	    }
	}



