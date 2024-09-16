package com.session.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.session.home.mapper.user.UserDAO;
import com.session.home.model.User;
import com.session.home.util.FileScrty;
import com.session.home.util.LoginVo;
import com.session.home.util.Result;



@Service
public class AuthService {

	private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserDAO userDAO;
	

    public Result insertUser(User user) {
		Result result = new Result();
		// Map<String, Object> query = new HashMap<>();
		// query.put("userId", user.getId());
		
		// User existingUser = userDAO.selectUserFirst(query);
		// if(existingUser != null) {
		// 	result.setError(true);
		// 	result.setMessage(user.getId() + "The User ID with " +"  has already exist!");
		// 	return result;
		// }
		// user.setRegisterationDate(new Date());

		// user.setPassword(FileScrty.encryptPassword(user.getPassword(), Integer.toString(user.getId())));
		user.setPassword(FileScrty.encryptPassword(user.getPassword(), "1"));
		userDAO.insertUser(user);
		return result;
	}

	public LoginVo login(LoginVo loginVo) {
		
		if (Integer.toString(loginVo.getId()).isEmpty() || loginVo.getPassword().isEmpty()) {
			loginVo.setMsg("Login Fail!");
			loginVo.setResultSuccess(false);
			return loginVo;
		}
		
		User user = userDAO.findUserByUsername(loginVo.getUsername());
		
		if(user == null) {
			loginVo.setMsg("Login Fail!");
			loginVo.setResultSuccess(false);
			return loginVo;
		}
		// String enpassword = FileScrty.encryptPassword(loginVo.getPassword(), Integer.toString(user.getId()));
		String enpassword = FileScrty.encryptPassword(loginVo.getPassword(), "1");
		if( !user.getPassword().equals(enpassword) ) {
			loginVo.setMsg("Login Fail!");
			loginVo.setResultSuccess(false);
			return loginVo;
		}
		loginVo = mapper.convertValue(user, LoginVo.class);
		return loginVo;
	}
}
