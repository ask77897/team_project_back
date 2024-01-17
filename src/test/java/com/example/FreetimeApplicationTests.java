package com.example;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.MarketDAO;
import com.example.dao.MentorDAO;
import com.example.dao.MysqlDAO;
import com.example.dao.UserDAO;
import com.example.domain.MentorVO;
import com.example.service.MarketService;

@SpringBootTest
class FreetimeApplicationTests {
	@Autowired
	MysqlDAO mdao;
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	MentorDAO mendao;
	
	@Autowired
	MarketDAO dao;
	
	@Autowired
	MarketService sevice;

	@Test
	void contextLoads() {
		mdao.now();
	}
	/*
	@Test
	void list() {
		udao.list();
	}
	*/
	@Test //mentor insert
	void insert() {
		MentorVO vo = new MentorVO();
		vo.setMid("test8");
		vo.setUid("test9");
		vo.setMtid("");
		mendao.insert(vo);
	}
	/*
	@Test //mentor list
	void list() {
		QueryVO vo = new QueryVO();
		vo.setPage(1);
		vo.setSize(3);
		mendao.list(vo);
	}
	
	@Test //market insert
	public void insert() {
		MarketVO vo = new MarketVO();
		vo.setUid("test9");
		vo.setTitle("testTitle");
		vo.setPhoto("");
		vo.setContents("testContents");
		vo.setPrice(0);
		vo.setPhotonum("");
		sevice.photoIn(vo);
	}
	
	@Test //market list
	public void list() {
		QueryVO vo=new QueryVO();
		vo.setPage(1);
		vo.setSize(3);
		vo.setQuery("");
		dao.list(vo);
	}

	@Test //market delete
	public void delete() {
		dao.delete(3);
	}
	
	@Test //mentor delete
	public void delete() {
		mendao.delete("5c2926e9-2");
	}
	
	@Test //mentor update
	public void update() {
		MentorVO vo = new MentorVO();
		vo.setMtid("b389e765-8");
		vo.setMid("test3");
		vo.setUid("test1");
		mendao.update(vo);
	}
	
	@Test //mentor read
	public void read() {
		mendao.read("d3977cf9-f");
	}*/
}
