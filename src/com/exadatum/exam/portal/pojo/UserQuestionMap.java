package com.exadatum.exam.portal.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="TB_USER_QUESTION_MAPPING")
public class UserQuestionMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long tblId;
	private String userId;
	private String questionnaireId;
	private String questionId;
	private String questionSubmitTime;
	private String uploadFileLocation;
	private String comment;	
	public UserQuestionMap(String userId, String questionnaireId,
			String questionId, String questionSubmitTime,
			String uploadFileLocation) {
		super();
		this.userId = userId;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.questionSubmitTime = questionSubmitTime;
		this.uploadFileLocation = uploadFileLocation;
	}
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
	@Column(name="QUESTIONNAIRE_ID")
	public String getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	@Column(name="QUESTION_ID")
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	@Column(name="QUESTION_SUBMIT_TIME")
	public String getQuestionSubmitTime() {
		return questionSubmitTime;
	}
	public void setQuestionSubmitTime(String questionSubmitTime) {
		this.questionSubmitTime = questionSubmitTime;
	}
	@Column(name="ANSWER_LOCATION")
	public String getUploadFileLocation() {
		return uploadFileLocation;
	}
	public void setUploadFileLocation(String uploadFileLocation) {
		this.uploadFileLocation = uploadFileLocation;
	}
	@Column(name="COMMENT")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "User_Question_Map [tblId=" + tblId + ", userId=" + userId
				+ ", questionnaireId=" + questionnaireId + ", questionId="
				+ questionId + ", questionSubmitTime=" + questionSubmitTime
				+ ", uploadFileLocation=" + uploadFileLocation + ", comment="
				+ comment + "]";
	}

}
