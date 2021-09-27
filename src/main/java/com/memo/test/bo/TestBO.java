package com.memo.test.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.test.dao.TestDAO;

@Service
public class TestBO {
	@Autowired
	private TestDAO testdao;
	public int test() {
		return testdao.getId();
	}
}
