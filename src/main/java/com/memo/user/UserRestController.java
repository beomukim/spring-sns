package com.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.common.EncryptUtils;
import com.memo.user.bo.UserBO;

@RequestMapping("/user")
@RestController// @ResponseBody + @Controller: 데이터로 내려준다.
public class UserRestController {
	
	@Autowired
	private UserBO userbo;
	
	
	
	
	
	/**
	 * ID 중복 확인
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", userbo.existLoginId(loginId));
		
		return result;
	}
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @return
	 */
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		// 비밀번호 해싱 
		String encryptPassword = EncryptUtils.md5(password);
		
		// DB user insert
		Map<String, Object> result = new HashMap<>();
		int row = userbo.insertUser(loginId, encryptPassword, name, email);
		
		if (row == 1) {
			result.put("result", "success");
		} else {
			result.put("error", "실패");
		}
		
		return result;
		// 응답값 생성 후 리턴
		
	}
	
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		//파라미터로 받은 비번을 해싱
		String EncryptPassword = EncryptUtils.md5(password);
		
		//DB SELECT
		User user = userbo.getUserByLoginIdAndPassword(loginId, EncryptPassword);
		//있으면 로그인 성공 
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("result", "success");
			// 로그인 처리 - 세션에 저장(로그인 상태를 유지한다)
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getName());
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			
		} else {
			result.put("error", "존재하지 않는 사용자 입니다.");
		}
		//없으면 로그인 실패
		
		//결과 리턴
		return result;
	}
	
	
	
	
	
}
