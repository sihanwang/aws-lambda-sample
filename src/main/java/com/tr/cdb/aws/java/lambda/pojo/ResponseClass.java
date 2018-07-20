package com.tr.cdb.aws.java.lambda.pojo;

import java.util.Date;

public class ResponseClass {

	public Date getExecdate() {
		return execdate;
	}
	public void setExecdate(Date execdate) {
		this.execdate = execdate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public int score;
	public boolean passed;
	public Date execdate;
	
}
