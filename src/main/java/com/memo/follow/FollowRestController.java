package com.memo.follow;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.follow.bo.FollowBO;

@RestController
public class FollowRestController {
	@Autowired
	private FollowBO followBO;

	@PostMapping("/follow")
	public Map<String, Object> postLike(@RequestParam("postUserId") int postUserId, HttpServletRequest request) {

		// 글 번호, 유저 번호
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		Map<String, Object> result = new HashMap<>();
		
		followBO.follow(postUserId, userId);
		result.put("result", "success");
		
		
		return result;
	}
}
