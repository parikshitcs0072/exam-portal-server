package com.exadatum.exam.portal.service;



import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadatum.exam.portal.dao.UserDao;
import com.exadatum.exam.portal.pojo.AuthenticatedUser;
import com.exadatum.exam.portal.pojo.Question;
import com.exadatum.exam.portal.pojo.User;
import com.exadatum.exam.portal.pojo.UserQuestionMap;
@Service
@Transactional
public class UserService{
	@Autowired
	UserDao dao;
	
	public AuthenticatedUser authenticateUser(User user){
		System.out.println("in service layer");
		Date loginTime = new Date();
		AuthenticatedUser authenticatedUser = dao.authenticateUser(user,loginTime);
		System.out.println(user);
		if(authenticatedUser != null)
			return authenticatedUser;
		return null;
	}

	public void uploadAnswer(UserQuestionMap obj) {
		dao.uploadAnswer(obj);
		System.out.println("in service");
	}
	
	public Map<String,List<Question>> startExam(AuthenticatedUser currentUser,String examStartTime){
		boolean isAuthenticatedUser = dao.validateUser(currentUser);
		if(isAuthenticatedUser){	
			return dao.startExam(currentUser.getUserId(),examStartTime);
		}
		return null;
	}

}
