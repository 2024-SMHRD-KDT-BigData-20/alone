package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 파라미터 담는 생성자
@RequiredArgsConstructor // 필요 파라미터 담는 생성자
@Getter
public class MemberVO {
	// 테이블 이름으로 VO이름을 만들면 제일 좋음
	// 테이블 하나 당 한개씩 객체를 생성
	
	// 객체의 필드명 == 테이블 컬럼명
	// 필드명 = 프로퍼티(property) = 속성
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;
	
	// toString : 객체에 담긴 정보를 출력하는 메소드
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pw=" + pw + ", tel=" + tel + ", address=" + address + "]";
	}
	

}
