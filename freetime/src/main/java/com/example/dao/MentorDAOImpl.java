package com.example.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MentorVO;

@Repository
public class MentorDAOImpl implements MentorDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MentorMapper";
	@Override
	public HashMap<String, Object> read(String mtid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read" + mtid);
	}
	@Override
	public void insert(MentorVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert" + vo);
	}
	@Override
	public void update(MentorVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update" + vo);
	}
	@Override
	public void delete(String mtid) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete" + mtid);
	}
	
	
}
