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
public class MessageVO {
	
	private int idx;
	@NonNull
	private String sendName;
	@NonNull
	private String receiveEmail;
	@NonNull
	private String msg;
	private String indate;
	
	
	@Override
	public String toString() {
		return "MessageVO [idx=" + idx + ", sendName=" + sendName + ", receiveEmail=" + receiveEmail + ", msg=" + msg
				+ ", indate=" + indate + "]";
	}
	
	
	
	
	
}
