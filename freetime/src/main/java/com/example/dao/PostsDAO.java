package com.example.dao;
import java.util.*;

import com.example.dao.PostsVO;

public interface PostsDAO {
	public List<HashMap<String,Object>> list();
	public void insert(PostsVO vo);
	public void delete(int pid);
	public void update(PostsVO vo);
}