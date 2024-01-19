package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CommentsDAO;
import com.example.domain.CommentsVO;

@Service
public class CommentsServiceImpl implements CommentsService{
	@Autowired
	CommentsDAO dao;

	@Override
	public void inComm(CommentsVO vo) {
		dao.insert(vo);
		dao.ccnt(vo.getMpid(), 1);
	}

	@Override
	public void delComm(int cid) {
		CommentsVO vo = dao.read(cid);
		dao.delete(cid);
		dao.ccnt(vo.getMpid(), -1);		
	}
	
}
