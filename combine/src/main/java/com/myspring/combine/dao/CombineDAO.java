package com.myspring.combine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface CombineDAO {
	public List selectAllScoreList() throws DataAccessException;
}
