package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PCommentsVO;
import com.example.domain.PostsVO;
import com.example.domain.QueryVO;

@Repository
public class PostsDAOImpl implements PostsDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.PostsMapper";

	@Override
	public List<HashMap<String, Object>> list(QueryVO vo) {
		vo.setStart((vo.getPage()-1)*vo.getSize());
		System.out.println(vo.toString());
		return session.selectList(namespace + ".list", vo);
	}

	@Override
	public HashMap<String, Object> read(int pid) {
		return session.selectOne(namespace + ".read", pid);
	}

	@Override
	public void insert(PostsVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void update(PostsVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int pid) {
		session.delete(namespace + ".delete", pid);
	}

	@Override
	public int total(QueryVO vo) {
		return session.selectOne(namespace + ".total", vo);
	}

	@Override
	public List<HashMap<String, Object>> comment(int pid, int page, int size) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pid", map);
		map.put("start", (page-1)*size);
		map.put("size", size);
		return session.selectList(namespace + ".comment", map);
	}

	@Override
	public int commTotal(int pcid) {
		return session.selectOne(namespace + ".commTotal", pcid);
	}

	@Override
	public void commIn(PCommentsVO vo) {
		session.insert(namespace + ".commIn", vo);
	}

	@Override
	public void commUp(PCommentsVO vo) {
		session.update(namespace + ".commUp", vo);
	}

	@Override
	public void viewcnt(int pid) {
		session.update(namespace + ".viewcnt", pid);
	}

	@Override
	public void commcnt(int pid, int amount) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("amount", amount);
		session.update(namespace + ".commcnt", map);
	}

	@Override
	public void commDel(int pcid) {
		session.delete(namespace + ".commDel", pcid);
	}

	@Override
	public PCommentsVO commRead(int pcid) {
		return session.selectOne(namespace + ".read", pcid);
	}

	@Override
	public HashMap<String, Object> read(int pid, String writer) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("writer", writer);
		return session.selectOne(namespace + ".info", map);
	}
}