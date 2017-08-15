package com.exadatum.exam.portal.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.exadatum.exam.portal.pojo.AuthenticatedUser;
import com.exadatum.exam.portal.pojo.Question;
import com.exadatum.exam.portal.pojo.User;
import com.exadatum.exam.portal.pojo.UserQuestionMap;

public interface UserDao {
	
	public Map<String,List<Question>> startExam(String userId,String startTime);
	public AuthenticatedUser authenticateUser(User user, Date loginTime);
	public void uploadAnswer(UserQuestionMap obj);
	public boolean validateUser(AuthenticatedUser user);
}
