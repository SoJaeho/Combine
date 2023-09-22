package com.myspring.combine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.combine.dao.CombineDAO;


@Service("combineService")
@Transactional(propagation = Propagation.REQUIRED)
public class CombineServiceImpl implements CombineService {
	@Autowired
	private CombineDAO combineDAO;

	@Override
	public List combineMembers() throws DataAccessException {
		List scoresList = null;
		scoresList = combineDAO.selectAllScoreList();
		return scoresList;
	}

	

}
