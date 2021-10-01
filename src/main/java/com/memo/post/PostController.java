package com.memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memo.post.bo.PostBO;
import com.memo.post.model.Post;

@RequestMapping("/post")
@Controller
public class PostController {
	@Autowired
	private PostBO postbo;
	@RequestMapping("/post_list_view")
	public String postListview(Model model, HttpServletRequest request) {
		// 글 목록들을 가져온다.
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		List<Post> postList = postbo.getList(userId);
		// 모델에 담는다.
		model.addAttribute("postList", postList);
		model.addAttribute("viewName", "/post/post_list");
		return "template/layout";
	}
}
