package com.example.service;

import java.util.HashMap;

import com.example.domain.PCommentsVO;
import com.example.domain.PostsVO;
import com.example.domain.QueryVO;

public interface PostsService {
	public void inComm(PCommentsVO vo);
	public void delComm(int pcid);
	public HashMap<String, Object> list(QueryVO vo);
	public HashMap<String, Object> read(int pid, String writer);
	public void photoIn(PostsVO vo);
}
