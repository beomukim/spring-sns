package com.memo.follow.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowDAO {
	public void insertFollow(@Param("postUserId") int postUserId, @Param("userId") int userId);
}
