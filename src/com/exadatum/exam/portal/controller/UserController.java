package com.exadatum.exam.portal.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exadatum.exam.portal.pojo.AuthenticatedUser;
import com.exadatum.exam.portal.pojo.LoginDetail;
import com.exadatum.exam.portal.pojo.Question;
import com.exadatum.exam.portal.pojo.User;
import com.exadatum.exam.portal.pojo.UserQuestionMap;
import com.exadatum.exam.portal.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	private String fileLocation = "/home/exa00026/Desktop/answers";

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthenticatedUser authenticateUser(@RequestBody String loginCredential) {
		LoginDetail loginDetail = null;
		User user = new User();
		ObjectMapper obj = new ObjectMapper();
		try {
			loginDetail = obj.readValue(loginCredential, LoginDetail.class);
			System.out.println(loginDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setEmailId(loginDetail.getUserId());
		user.setPassword(loginDetail.getPassword());
		AuthenticatedUser authenticatedUser = service.authenticateUser(user);
		System.out.println(authenticatedUser);
		if (authenticatedUser != null )
			return authenticatedUser;
		return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public String removeLoggedInUser(@RequestBody String logoutDetials) {
		System.out.println(logoutDetials);
		return null;
	}


	@RequestMapping(value = "/uploadanswer", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<String> uploadAnswer(
			@RequestParam("userId") String userId,
			@RequestParam("qId") String questionId,
			@RequestParam("questionnaireID") String questionnaireId,
			@RequestParam("file") MultipartFile inputFile) {
		HttpHeaders headers = new HttpHeaders();
		UserQuestionMap obj = null;
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				System.out.println(questionnaireId);
				String location = fileLocation +"/"+userId +"/"+questionnaireId+"/"+ questionId;
				File destinationFile = new File(location + File.separator
						+ originalFilename);
				destinationFile.mkdirs();
				inputFile.transferTo(destinationFile);
				Date time = new Date();
				String submitTime = time.getTime()+"";
				obj = new UserQuestionMap(userId,questionnaireId,questionId,submitTime,location);
				System.out.println(obj);
				service.uploadAnswer(obj);
				System.out.println("back to controller");
				headers.add("File Uploaded Successfully - ", originalFilename);
				return new ResponseEntity<String>("fileuploaded", headers,
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/startexam",method = RequestMethod.POST)
	public Map startExam(@RequestBody String currentUserJson) {
		AuthenticatedUser currentUser = null;
		User user = new User();
		ObjectMapper obj = new ObjectMapper();
		try {
			System.out.println(currentUserJson);
			currentUser = obj.readValue(currentUserJson, AuthenticatedUser.class);
			System.out.println(currentUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long examStartTime = new Date().getTime();
		
		Map<String,List<Question>> questionnaire = service.startExam(currentUser,String.valueOf(examStartTime));
		Question ques = (Question)((List)questionnaire.get("Q_ID_1")).get(0);
		System.out.println(ques);
		
		
		return questionnaire;
	}

	@RequestMapping(value = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
}
