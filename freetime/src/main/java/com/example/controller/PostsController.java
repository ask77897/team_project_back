package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PostsDAO;
import com.example.domain.PCommentsVO;
import com.example.domain.PostsVO;
import com.example.domain.QueryVO;
import com.example.service.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	@Autowired
	PostsDAO dao;
	
	@Autowired
	PostsService service;

	@GetMapping("/list.json")
	public HashMap<String, Object> list(QueryVO vo) {
		System.out.println(vo.toString());
		return service.list(vo);
	}

	@GetMapping("/delete/{pid}")
	public void delete(@PathVariable("pid") int pid) {
		dao.delete(pid);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody PostsVO vo) {
		dao.insert(vo);
	}

	@GetMapping("/read/{pid}")
	public HashMap<String, Object> read(@PathVariable int pid){
		return dao.read(pid);
	}

	@GetMapping("/info/{pid}")
	public HashMap<String, Object> info(@PathVariable int pid, String writer){
		return service.read(pid, writer);
	}

	@GetMapping("/comment/list.json")
	public HashMap<String, Object> comment(@RequestParam("pid") int pid, @RequestParam("page") int page, @RequestParam("size") int size){
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", dao.comment(pid, page, size));
		map.put("total", dao.commTotal(pid));
		return map;
	}

	@PostMapping("/update")
	public void update(@RequestBody PostsVO vo) {
		dao.update(vo);
	}
	

	@PostMapping("/comment/insert")
	public void incomm(@RequestBody PCommentsVO vo) {
		service.inComm(vo);
	}

	@GetMapping("/comment/delete")
	public void delcomm(@RequestParam("pcid") int pcid) {
		service.delComm(pcid);
	}

	@PostMapping("/comment/update")
	public void upcomm(@RequestBody PCommentsVO vo) {
		dao.commUp(vo);
	}
	
	@GetMapping("/insert/favorites")
	public void insert(int pid, String uid) {
		service.insertFavorites(pid, uid);
	}
	
	@GetMapping("/delete/favorites")
	public void delete(int pid, String uid) {
		service.deleteFavorites(pid, uid);
	}
}
