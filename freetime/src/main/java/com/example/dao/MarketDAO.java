package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.MarketVO;

public interface MarketDAO {
	public List<HashMap<String, Object>> list();
	public HashMap<String, Object> read(int sid);
	public void insert(MarketVO vo);
	public void update(MarketVO vo);
	public void delete(int sid);
}
