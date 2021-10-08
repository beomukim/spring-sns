package com.memo.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memo.like.bo.LikeBO;

@RestController
public class LikeRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LikeBO likeBO;

	@PostMapping("/like/{postId}")
	public Map<String, Object> postLike(@PathVariable int postId, HttpServletRequest request) {

		// 글 번호, 유저 번호
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		Map<String, Object> result = new HashMap<>();
		if (userId == null) {
			result.put("result", "error");
			logger.error("[글쓰기] 로그인 세션이 없습니다.");
			return result;
		}
		
		likeBO.like(postId, userId);
		result.put("result", "success");
		return result;
	}
}
