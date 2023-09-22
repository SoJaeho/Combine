package com.myspring.combine.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class ScoreVO {
	private String id;
	private String score;

	public ScoreVO() {
		
	}

	public ScoreVO(String id, String score) {
		this.id = id;
		this.score = score;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}


}
