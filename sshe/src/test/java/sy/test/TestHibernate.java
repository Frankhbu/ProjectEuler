package sy.test;

import java.util.Date;
import java.util.UUID;

import me.frank.hbu.sshe.pageModel.User;
import me.frank.hbu.sshe.service.UserServiceI;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {

	@Test
	public void test() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						new String[] { "classpath*:context-*.xml"});
		UserServiceI userService = (UserServiceI) ac.getBean("userService");
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("孙宇1");
		user.setPwd("123465");
		user.setCreatedatetime(new Date());
		userService.save(user);
	}

}
