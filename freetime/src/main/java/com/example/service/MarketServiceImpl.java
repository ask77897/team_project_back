package com.example.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MarketDAO;
import com.example.domain.MCommentsVO;
import com.example.domain.MarketVO;
import com.example.domain.QueryVO;

@Service
public class MarketServiceImpl implements MarketService{
	@Autowired
	MarketDAO dao;

	@Transactional
	@Override
	public void inComm(MCommentsVO vo) {
		dao.commIn(vo);
		dao.commcnt(vo.getSid(), 1);
	}

	@Transactional
	@Override
	public void delComm(int mcid) {
		MCommentsVO vo = dao.commRead(mcid);
		dao.delete(mcid);
		dao.commcnt(vo.getSid(), -1);
	}

	@Transactional
	@Override
	public HashMap<String, Object> list(QueryVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", dao.list(vo));
		map.put("total", dao.total(vo));
		return map;
	}

	@Transactional
	@Override
	public HashMap<String, Object> read(int sid) {
		dao.viewcnt(sid);
		return dao.read(sid);
	}

	@Transactional
	@Override
	public void photoIn(MarketVO vo) {
		vo.setPhotonum(UUID.randomUUID().toString().substring(0, 10));
		int result = dao.check(vo.getPhotonum());
		if(result == 0) {
			if(vo.getPhoto().equals("")) {
				vo.setPhoto(null);
			}
			if(vo.getPhoto()!=null) {
				String image = System.currentTimeMillis() + ".jpg";
				try {
					@SuppressWarnings("deprecation")
					URL url = new URL("file:" + vo.getPhoto());
					InputStream is = url.openStream();
					FileOutputStream fos = new FileOutputStream("c:/upload/project/" + image);
					int data;
					while((data = is.read()) != -1) {
						fos.write(data);
					}
					fos.close();
					vo.setPhoto("/upload/project/" + image);
					dao.insert(vo);
					System.out.println(vo.toString() + "22");
				} catch(Exception e) {
					System.out.println("이미지 업로드 오류 : " + e.toString());
				}
			}else {
				dao.insert(vo);
			}
		}
	}
}
