package com.memo.timeline.model;

import java.util.List;

import com.memo.comment.model.Comment;
import com.memo.post.model.Post;

public class Content {
	// 글 1개
	private Post post;
	// 댓글 n개
	private List<Comment> commentList;
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public boolean isLikeYn() {
		return likeYn;
	}

	public void setLikeYn(boolean likeYn) {
		this.likeYn = likeYn;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	// 내가 한 좋아요
	private boolean likeYn; // true면 좋아요 false면 해제
	
	// 좋아요 총 개수
	private int likeCount;
}
