package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {
	
	// DB에서 연결고리를 만들어 놓고 가져다 쓸수 있게 sqlSession생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	// 회원가입기능구현
	public int insertMember(MemberVO joinMember) {
		// 실행된 레코드수 반환
		int cnt=0;
		// auto commit : 데이터베이스의 변화를 주는 구문(DML)
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// insert(어떤 sql문 실행시킬지 sql문태그의 id, 매개변수)
		// sql문 태그 id 중복없이 만들었다면 id만 작성
		// id가 속한 namespace도 작성
		cnt = sqlSession.insert("com.smhrd.db.MemberMapper.insertMember", joinMember);
		// DB연결고리 반납
		// 한페이지에서 DB여러번 쓰는 경우 close때문에 오류
		sqlSession.close();
		
		return cnt;
	}// insertMember 끝
	
	// 로그인 기능구현
	public MemberVO selectMember(MemberVO login) {
		MemberVO loginMember = null;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		loginMember = sqlSession.selectOne("com.smhrd.db.MemberMapper.selectMember", login);
		sqlSession.close();
		return loginMember;
	}// selectMember 끝
	
	// 회원정보수정 기능구현
	public int updateMember(MemberVO update) {
		int cnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		cnt = sqlSession.update("com.smhrd.db.MemberMapper.updateMember", update);
		sqlSession.close();		
		return cnt;
	}// updateMember 끝
	
	// 회원전체정보검색 기능구현
	public List<MemberVO> selectAll(){
		List<MemberVO> memberlist = null;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// sql문 실행할때 조건 넣어줄 값이 없으므로 id값만 적어줌
		memberlist = sqlSession.selectList("com.smhrd.db.MemberMapper.selectAll");
		sqlSession.close();
		return memberlist;
	}// selectAll 끝
	
	// 회원삭제 기능구현
	public int deleteMember(String email) {
		int cnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		cnt = sqlSession.delete("com.smhrd.db.MemberMapper.deleteMember", email);
		sqlSession.close();
		return cnt;
	}// deleteMember 끝
	
	
	// 회원검색 기능 구현(ajax통해서)
	public List<MemberVO> searchMember(String email){
		List<MemberVO> searchlist = null;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		searchlist = sqlSession.selectList("com.smhrd.db.MemberMapper.searchMember",email);
		sqlSession.close();
		return searchlist;
	}// searchMember 끝
	
	
	
	

}
