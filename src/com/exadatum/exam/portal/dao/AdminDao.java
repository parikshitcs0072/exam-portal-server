package com.exadatum.exam.portal.dao;

import com.exadatum.exam.portal.pojo.Admin;
import com.exadatum.exam.portal.pojo.Exam;
import com.exadatum.exam.portal.pojo.Question;
import com.exadatum.exam.portal.pojo.Questionnaire;

public interface AdminDao {
	
	public Admin authenticateAdmin(Admin admin);
	public void setQuestionnaire(Questionnaire ques);
	public void addQuestions (Question question);
	public void setExam (Exam exam);

}
