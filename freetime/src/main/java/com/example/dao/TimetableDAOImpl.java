package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.TimetableVO;

@Repository
public class TimetableDAOImpl implements PostsDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.TimetableMapper";
	
	@Override
	public List<HashMap<String, Object>> list() {
		return session.selectList(namespace + ".list");
	}
	
	@Override
	public void insert(TimetableVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void delete(int pid) {
		session.delete(namespace + ".delete", pid);
	}

	@Override
	public void update(TimetableVO vo) {
		session.update(namespace + ".update", vo);
	}

}