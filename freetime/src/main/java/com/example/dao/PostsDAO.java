package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.PCommentsVO;
import com.example.domain.PostsVO;
import com.example.domain.QueryVO;

public interface PostsDAO {
	public List<HashMap<String, Object>> list(QueryVO vo);
	public HashMap<String, Object> read(int pid);
	public HashMap<String, Object> read(int pid, String writer);
	public int total(QueryVO vo);
	public List<HashMap<String, Object>> comment(int pid, int page, int size);
	public int commTotal(int pcid);
	public PCommentsVO commRead(int pcid);
	public void insert(PostsVO vo);
	public void commIn(PCommentsVO vo);
	public void update(PostsVO vo);
	public void delete(int pid);
	public void commUp(PCommentsVO vo);
	public void viewcnt(int pid);
	public void commcnt(int pid, int amount);
	public void commDel(int pcid);
	
}
