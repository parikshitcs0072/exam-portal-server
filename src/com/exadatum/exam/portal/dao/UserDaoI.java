package com.exadatum.exam.portal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exadatum.exam.portal.pojo.AuthenticatedUser;
import com.exadatum.exam.portal.pojo.Question;
import com.exadatum.exam.portal.pojo.User;
import com.exadatum.exam.portal.pojo.UserExamMapping;
import com.exadatum.exam.portal.pojo.UserQuestionMap;

@Repository
public class UserDaoI implements UserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public AuthenticatedUser authenticateUser(User user, Date loginTime) {
		System.out.println("in dao layer");
		User u = (User) sf
				.getCurrentSession()
				.createQuery(
						"select user from TB_EXAMINEE user where user.emailId=:aid")
				.setParameter("aid", user.getEmailId()).uniqueResult();
		System.out.println("User POJO" + u);
		if (u.getPassword().equals(user.getPassword())) {
			// TODO validate logintime
			AuthenticatedUser aUser = new AuthenticatedUser(u.getEmailId(),
					u.getUserName(), "azklj", true);
			System.out.println(aUser);
			sf.getCurrentSession().persist(aUser);
			return aUser;
		}
		return null;
	}

	@Override
	public void uploadAnswer(UserQuestionMap obj) {
		Session session = sf.getCurrentSession();
		/*
		 * Transaction txn = session.beginTransaction(); txn.begin();
		 */
		session.persist(obj);
		/*
		 * session.flush(); txn.commit();
		 */
	}

	@Override
	public Map<String, List<Question>> startExam(String userId,
			String startTime) {
		UserExamMapping usrExMp = (UserExamMapping) sf
				.getCurrentSession()
				.createQuery(
						"select c from TB_EXAM_USER_MAP c where c.userId=:aid and c.expired=false")
				.setParameter("aid", userId)
				.uniqueResult();
		// TODO update exam start time
		usrExMp.setUserExamStartTime(startTime);
		@SuppressWarnings("unchecked")
		List<String> questionNoList = (List<String>) sf
				.getCurrentSession()
				.createQuery(
						"select c.qNo from TB_QUESTIONNAIRE c where c.qId=:aid")
				.setParameter("aid", usrExMp.getQuestionnaireId()).list();
		System.out.println(questionNoList);
		List<Question> questionList = new ArrayList<Question>();
		for (String qno : questionNoList) {
			Question question = (Question) sf.getCurrentSession().load(
					Question.class, qno);
			questionList.add(question);
		}
		System.out.println(questionList);
		Map<String, List<Question>> questionnaire = new HashMap<String, List<Question>>();
		questionnaire.put(usrExMp.getQuestionnaireId(), questionList);
		return questionnaire;
	}

	@Override
	public boolean validateUser(AuthenticatedUser user) {
		AuthenticatedUser aUser = (AuthenticatedUser) sf
				.getCurrentSession()
				.createQuery(
						"select c from TB_LOGIN c where c.userId=:aid and c.token=:bid")
				.setParameter("aid", user.getUserId()).setParameter("bid", user.getToken()).uniqueResult();
		if(aUser != null)
			return true;
		return false;
	}
}
