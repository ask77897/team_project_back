package com.example.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PostsDAO;
import com.example.domain.PCommentsVO;
import com.example.domain.PostsVO;
import com.example.domain.QueryVO;

@Service
public class PostsServiceImpl implements PostsService{
	@Autowired
	PostsDAO dao;

	@Transactional
	@Override
	public void inComm(PCommentsVO vo) {
		dao.commIn(vo);
		dao.commcnt(vo.getPid(), 1);
	}

	@Transactional
	@Override
	public void delComm(int pcid) {
		PCommentsVO vo = dao.commRead(pcid);
		dao.delete(pcid);
		dao.commcnt(vo.getPcid(), -1);
	}

	@Transactional
	@Override
	public HashMap<String, Object> list(QueryVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", dao.list(vo));
		map.put("total", dao.total(vo));
		return map;
	}

	@Transactional
	@Override
	public HashMap<String, Object> read(int pid, String writer) {
		dao.viewcnt(pid);
		return dao.read(pid, writer);
	}

	@Override
	public void photoIn(PostsVO vo) {
		// TODO Auto-generated method stub
		
	}
}
