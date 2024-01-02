package com.example.dao;

import java.util.HashMap;
import java.util.List;

public interface TimetableDAO {
	
	public List<HashMap<String, Object>> list();
	public void insert(TimetableVO vo);
	public void delete(int pid);
	public void update(TimetableVO vo);

}
