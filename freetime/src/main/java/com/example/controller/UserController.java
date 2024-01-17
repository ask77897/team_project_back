package com.example.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDAO dao;
	
	@PostMapping("/signup")
	public void insert(@RequestBody UserVO vo) {
		// System.out.println(vo.toString());
		dao.insert(vo);
	}

	@PostMapping("/password")
	public void password(@RequestBody UserVO vo) {
		dao.passUpdate(vo);
	}

	@PostMapping("/upload")
	public void upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "uid") String uid)
			throws Exception {
        String filePath = "src/main/resources/static/upload/image/";
        Path uploadPath = Paths.get(System.getProperty("user.dir"), filePath);
		String fileName = System.currentTimeMillis() + ".jpg";
		file.transferTo(new File(uploadPath + "/" + fileName));
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setImage("/static/upload/image/" + fileName);
		dao.image(vo);
	}

//	@PostMapping("/update")
//	public void update(@RequestParam UserVO vo) {
//		// System.out.println(vo.toString());
//		dao.update(vo);
//	}
	@PostMapping("/update")
	public void update(@RequestBody UserVO vo) {
		dao.update(vo);
	}

	@GetMapping("/read")
	public HashMap<String, Object> read(@RequestParam(value = "uid") String uid) {
		return dao.read(uid);
	}

	@PostMapping("/login")
	public int login(@RequestBody UserVO vo) {
		int result = 0;
		UserVO user = dao.login(vo.getUid());

		if (user != null) {
			if (vo.getUpass().equals(user.getUpass())) {
				result = 1;
			} else {
				result = 2;
			}
		}
		return result;
	}
}