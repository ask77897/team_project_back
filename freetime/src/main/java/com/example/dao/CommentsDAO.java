package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.CommentsVO;

public interface CommentsDAO {
	public List<HashMap<String, Object>> list(int mpid, int page, int size);
	public CommentsVO read(int cid);
	public int total(int mpid);
	public void insert(CommentsVO vo);
	public void update(CommentsVO vo);
	public void ccnt(int mpid, int amount);
	public void delete(int cid);
}
