package com.myspring.combine.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface CombineService {
	public List combineMembers() throws DataAccessException;
}
