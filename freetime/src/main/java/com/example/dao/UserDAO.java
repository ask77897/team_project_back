package com.example.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.domain.UserVO;

@Repository
public interface UserDAO {
    public HashMap<String, Object> read(String uid);

    public UserVO login(String uid);

    public void update(UserVO vo);

    public void image(UserVO vo);

    public void password(UserVO vo);

    public void insert(UserVO vo);
    
    
}

