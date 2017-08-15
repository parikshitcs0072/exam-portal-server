package com.exadatum.exam.portal.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="TB_QUESTIONNAIRE")
public class Questionnaire implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCol;
	private String qId;
	private String qNo;
	private Date qSetDate;
	private String comment;
	
	@Id
	@GeneratedValue
	@Column(name="TB_ID")
	public int getIdCol() {
		return idCol;
	}
	public void setIdCol(int idCol) {
		this.idCol = idCol;
	}
	@Column(name="QUESTIONNAIRE_ID",nullable=false)
	public String getqId() {
		return qId;
	}
	public void setqId(String qId) {
		this.qId = qId;
	}
	@Column(name="QUESTION_NUMBER")
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	@Column(name="QUESTIONNAIRE_SET_DATE")
	public Date getqSetDate() {
		return qSetDate;
	}
	public void setqSetDate(Date qSetDate) {
		this.qSetDate = qSetDate;
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
		return "Questionnaire [qId=" + qId + ", qNo=" + qNo + ", qSetDate="
				+ qSetDate + ", comment=" + comment + "]";
	}
	
	

}
