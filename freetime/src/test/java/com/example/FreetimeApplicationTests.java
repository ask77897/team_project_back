package com.example;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.MysqlDAO;
import com.example.dao.UserDAO;

@SpringBootTest
class FreetimeApplicationTests {
	@Autowired
	MysqlDAO mdao;
	
	@Autowired
	UserDAO udao;

	@Test
	void contextLoads() {
		mdao.now();
	}
	
	@Test
	void list() {
		udao.list();
	}

}
