package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MarketVO;

@Repository
public class MarketDAOImpl implements MarketDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MarketMapper";

	@Override
	public List<HashMap<String, Object>> list() {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list");
	}

	@Override
	public HashMap<String, Object> read(int sid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read" + sid);
	}

	@Override
	public void insert(MarketVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert" + vo);
	}

	@Override
	public void update(MarketVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update" + vo);
	}

	@Override
	public void delete(int sid) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete" + sid);
	}
}
