package com.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.user.User;
import com.memo.user.dao.UserDAO;

@Service
public class UserBO {
	@Autowired
	private UserDAO userdao;
	
	public boolean existLoginId(String loginId) {
		return userdao.existLoginId(loginId);
	}
	
	public int insertUser(String loginId, String password, String name, String email) {
		return userdao.insertUser(loginId, password, name, email);
	}
	
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userdao.selectUserByLoginIdPassword(loginId, password);
	}

}
