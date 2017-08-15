package com.exadatum.exam.portal.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TB_EXAM")
public class Exam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String examId;
	private String examStartTime;
	private String examEndTime;
	private Date examStartDate;
	private Date examEndDate;	
	private String comment;
	
	@Id
	@Column(name="EXAM_ID",nullable=false)
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	@Column(name="EXAM_START_TIME")
	public String getExamStartTime() {
		return examStartTime;
	}
	public void setExamStartTime(String examStartTime) {
		this.examStartTime = examStartTime;
	}
	@Column(name="EXAM_END_TIME")
	public String getExamEndTime() {
		return examEndTime;
	}
	public void setExamEndTime(String examEndTime) {
		this.examEndTime = examEndTime;
	}
	@Column(name="EXAM_START_DATE")
	public Date getExamStartDate() {
		return examStartDate;
	}
	public void setExamStartDate(Date examStartDate) {
		this.examStartDate = examStartDate;
	}
	@Column(name="EXAM_END_DATE")
	public Date getExamEndDate() {
		return examEndDate;
	}
	public void setExamEndDate(Date examEndDate) {
		this.examEndDate = examEndDate;
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
		return "Exam [examId=" + examId + ", examStartTime=" + examStartTime
				+ ", examEndTime=" + examEndTime + ", examStartDate="
				+ examStartDate + ", examEndDate=" + examEndDate + ", comment="
				+ comment + "]";
	}
	
}
