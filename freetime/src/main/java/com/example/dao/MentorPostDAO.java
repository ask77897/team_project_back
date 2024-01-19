package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.MentorPostVO;
import com.example.domain.QueryVO;

public interface MentorPostDAO {
	public List<HashMap<String, Object>> list(QueryVO vo);
	public HashMap<String, Object> read(int mpid);
	public int total(QueryVO vo);
	public void insert(MentorPostVO vo);
	public void update(MentorPostVO vo);
	public void delete(int mpid);
}
