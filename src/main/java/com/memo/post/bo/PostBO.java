package com.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.post.dao.PostDAO;
import com.memo.post.model.Post;

@Service
public class PostBO {
	@Autowired
	private PostDAO postdao;
	public List<Post> getList(Integer userId) {
		return postdao.selectPostList(userId);
	}
}
