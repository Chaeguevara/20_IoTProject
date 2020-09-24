package com.dao;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.ContentsVO;

@Repository("cdao")
public interface ContentsDao extends Dao<Integer, ContentsVO> {
	
	public void setcnt(Integer k) throws Exception;
}




