package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MentorPostVO;
import com.example.domain.QueryVO;

@Repository
public class MentorPostDAOImpl implements MentorPostDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MentorPostMapper";
	@Override
	public List<HashMap<String, Object>> list(QueryVO vo) {
		vo.setStart((vo.getPage()-1) * vo.getSize());
		return session.selectList(namespace + ".list", vo);
	}
	@Override
	public HashMap<String, Object> read(int mpid) {
		return session.selectOne(namespace + ".read", mpid);
	}
	@Override
	public void insert(MentorPostVO vo) {
		System.out.println("dao" + vo.toString());
		session.insert(namespace + ".insert", vo);
	}
	@Override
	public void update(MentorPostVO vo) {
		session.update(namespace + ".update", vo);
	}
	@Override
	public void delete(int mpid) {
		session.delete(namespace + ".delete", mpid);
	}
	@Override
	public int total(QueryVO vo) {
		return session.selectOne(namespace + ".total", vo);
	}
}
