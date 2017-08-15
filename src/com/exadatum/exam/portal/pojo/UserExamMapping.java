package com.exadatum.exam.portal.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="TB_EXAM_USER_MAP")
public class UserExamMapping implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long tblId;
	private String userId;
	private String examId;
	private String questionnaireId;
	private String comment;
	private String allocatedLoginTime;
	private String userExamStartTime;
	private boolean expired;
	@Id
	@GeneratedValue
	@Column(name="TBL_ID")
	public long getTblId() {
		return tblId;
	}
	public void setTblId(long tblId) {
		this.tblId = tblId;
	}
	@Column(name="USER_ID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="EXAM_ID")
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	@Column(name="QUESTIONNAIRE_ID")
	public String getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	@Column(name="ALLOCATED_LOGIN_TIME")
	public String getAllocatedLoginTime() {
		return allocatedLoginTime;
	}
	public void setAllocatedLoginTime(String allocatedLoginTime) {
		this.allocatedLoginTime = allocatedLoginTime;
	}
	@Column(name="USER_EXAM_START_TIME")
	public String getUserExamStartTime() {
		return userExamStartTime;
	}
	public void setUserExamStartTime(String userExamStartTime) {
		this.userExamStartTime = userExamStartTime;
	}
	@Column(name="COMMENT")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name="IS_EXPIRED")
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	@Override
	public String toString() {
		return "UserExamMapping [tblId=" + tblId + ", userId=" + userId
				+ ", examId=" + examId + ", questionnaireId=" + questionnaireId
				+ ", comment=" + comment + ", allocatedLoginTime="
				+ allocatedLoginTime + ", userExamStartTime="
				+ userExamStartTime + ", expired=" + expired + "]";
	}
}
