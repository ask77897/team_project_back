package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.MarketDAO;
import com.example.dao.MentorDAO;
import com.example.dao.MysqlDAO;
import com.example.dao.UserDAO;
import com.example.domain.MarketVO;
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
	
	@Test
	void insert() {
		MentorVO vo = new MentorVO();
		vo.setMid("test2");
		vo.setUid("test1");
		vo.setMtid(UUID.randomUUID().toString().substring(0, 10));
		mendao.insert(vo);
	}
	
	@Test
	void list() {
		QueryVO vo = new QueryVO();
		vo.setPage(1);
		vo.setSize(3);
		mendao.list(vo);
	}*/
	
	@Test
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
	/*
	@Test
	public void list() {
		QueryVO vo=new QueryVO();
		vo.setPage(1);
		vo.setSize(3);
		vo.setQuery("");
		dao.list(vo);
	}

	@Test
	public void delete() {
		dao.delete(3);
	}*/
}
