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

import com.example.dao.TimetableDAO;
import com.example.dao.UserDAO;
import com.example.domain.TimetableVO;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
	@Autowired
	TimetableDAO dao;
	
	@GetMapping("/list.json")
	public List<HashMap<String, Object>> list() {
		return dao.list();
	}
	
	@GetMapping("/read/{tid}") //http://localhost:8080/timetable/read/tid
	public HashMap<String, Object> read(@PathVariable int tid){
		return dao.read(tid);
	}
	
	@PostMapping("/insert") // http://localhost:8080/timetable/insert (완료)
	public void insert(@RequestBody TimetableVO vo) {
		dao.insert(vo);
	}
	
	@PostMapping("/update") //http://localhost:8080/timetable/update (완료)
	public void update(@RequestBody TimetableVO vo) {
		dao.update(vo);
	}
	
	@GetMapping("/delete") //http://localhost:8080/timetable/delete?tid=1
	public void delete(@RequestParam("tid") int tid) {
		dao.delete(tid);
	}	
}

