package test.action;

import javax.annotation.Resource;

import test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;
public class TestAction extends ActionSupport{
	@Resource
	private TestService testService;
	public String execute(){
		System.out.println("struts和spring整合");
		return SUCCESS;
	}
}
