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

import com.example.dao.GradeCalcDAO;
import com.example.domain.GradecalcVO;

@RestController
@RequestMapping("/gradecalc")
public class GradeCalcController {
	@Autowired
	GradeCalcDAO dao;
	

	@GetMapping("/list.json") // http://localhost:8080/gradecalc/list.json
	public List<HashMap<String, Object>> list() {
		return dao.list();
	}
	
	@GetMapping("/read/{gid}") //http://localhost:8080/gradecalc/read/gid
	public HashMap<String, Object> read(@PathVariable int gid){
		return dao.read(gid);
	}
	
	@PostMapping("/insert") // http://localhost:8080/gradecalc/insert
	public void insert(@RequestBody GradecalcVO vo) {
		dao.insert(vo);
	}
	
	@PostMapping("/update") //http://localhost:8080/gradecalc/update
	public void update(@RequestBody GradecalcVO vo) {
		dao.update(vo);
	}
	
	@GetMapping("/delete") //http://localhost:8080/gradecalc/delete?gid=1
	public void delete(@RequestParam("gid") int gid) {
		dao.delete(gid);
	}
}