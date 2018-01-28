package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.action.TestAction;
import test.entity.Person;
import test.service.TestService;

public class TestMerge {
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService testService=(TestService) ac.getBean("testService");
		testService.save(new Person("zuoci"));
	}
}
