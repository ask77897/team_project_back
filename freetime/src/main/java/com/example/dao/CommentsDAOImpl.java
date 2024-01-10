package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CommentsVO;

@Repository
public class CommentsDAOImpl implements CommentsDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CommentMapper";
	@Override
	public List<HashMap<String, Object>> list(int mpid, int page, int size) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("mpid", mpid);
		map.put("start", (page-1) * size);
		map.put("size", size);
		return session.selectList(namespace + ".list", map);
	}
	@Override
	public CommentsVO read(int cid) {
		return session.selectOne(namespace + ".read", cid);
	}
	@Override
	public void insert(CommentsVO vo) {
		session.insert(namespace + ".insert", vo);
	}
	@Override
	public void update(CommentsVO vo) {
		session.update(namespace + ".update", vo);
	}
	@Override
	public void delete(int cid) {
		session.delete(namespace + ".delete", cid);
	}
	@Override
	public int total(int mpid) {
		return session.selectOne(namespace + ".total", mpid);
	}
	@Override
	public void ccnt(int mpid, int amount) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("mpid", mpid);
		map.put("amount", amount);
		session.update(namespace + ".ccnt", map);
	}
}
