package com.memo.follow.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.follow.dao.FollowDAO;
@Service
public class FollowBO {
	@Autowired
	private FollowDAO followDAO;
	public void follow(int postUserId, int userId) {


		followDAO.insertFollow(postUserId, userId);

	}
}
