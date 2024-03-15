package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MessageDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	// 메세지 전송 기능 구현
	public int insertMSG(MessageVO insertmsg) {
		int cnt = 0;
		SqlSession sqlsession = sqlSessionFactory.openSession(true);
		//com.smhrd.db.MessageMapper.insertMSG
		cnt = sqlsession.insert("insertMSG",insertmsg);
		sqlsession.close();
		return cnt;
	}// insertMSG 끝
	
	// 메세지 조회 기능 구현
	public List<MessageVO> selectMSG(String email){
		List<MessageVO> msglist = null;
		SqlSession sqlsession = sqlSessionFactory.openSession(true);
		msglist = sqlsession.selectList("msglist", email);
		sqlsession.close();
		return msglist;
	}
	
	
	
	
	
	
	
	
	

}
