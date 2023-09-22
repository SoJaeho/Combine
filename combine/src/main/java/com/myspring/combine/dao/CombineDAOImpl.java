package com.myspring.combine.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.combine.vo.ScoreVO;



@Repository("combineDAO")
public class CombineDAOImpl implements CombineDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllScoreList() throws DataAccessException {
		List<ScoreVO> scoresList = null;
		scoresList = sqlSession.selectList("mapper.score.selectAllMemberList");
		return scoresList;
	}

//	@Override
//	public int insertMember(MemberVO memberVO) throws DataAccessException {
//		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
//		return result;
//	}
//
//	@Override
//	public int deleteMember(String id) throws DataAccessException {
//		int result = sqlSession.delete("mapper.member.deleteMember", id);
//		return result;
//	}
//	@Override
//	public MemberVO loginById(MemberVO memberVO) throws DataAccessException{
//		  MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
//		return vo;
//	}

}
