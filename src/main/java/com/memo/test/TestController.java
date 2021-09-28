package com.memo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.test.bo.TestBO;

@Controller
public class TestController {
	
	@Autowired
	private TestBO testbo;
	@ResponseBody
	@RequestMapping("/test1")
	public String helloWorld() {
		return "Hello spring!";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public int test() {
		return testbo.test();
	}
	
	@RequestMapping("/test3")
	public String test3() {
		return "test/test2";
	}

}
