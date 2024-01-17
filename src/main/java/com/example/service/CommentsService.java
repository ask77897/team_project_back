package com.example.service;

import com.example.domain.CommentsVO;

public interface CommentsService {
	public void inComm(CommentsVO vo);
	public void delComm(int cid);
}
