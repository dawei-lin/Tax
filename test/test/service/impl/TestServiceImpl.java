package test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import test.dao.TestDao;
import test.entity.Person;
import test.service.TestService;
@Component("testService")
public class TestServiceImpl implements TestService{

	@Resource
	private TestDao testDao;
	@Override
	public void say() {
		System.out.println("struts和spring整合");	
	}

	@Override
	public void save(Person person) {
		testDao.save(person);
	}

}
