package com.maofengqiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	@RequestMapping(value="helloworld")
	public String getPage(){
		return "success";
	}
	
	@RequestMapping(value="chat")
	public String startChat(){
		return "chat";
	}
	
	@RequestMapping(value="webChat")
	public String startWebChat(){
		return "webChat";
	}
	
	@RequestMapping(value="restful")
	public String restfulAPI(){
		return "restful";
	}
}
