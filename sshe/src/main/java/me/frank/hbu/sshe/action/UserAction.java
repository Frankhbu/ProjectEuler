package me.frank.hbu.sshe.action;

import me.frank.hbu.sshe.pageModel.Json;
import me.frank.hbu.sshe.pageModel.User;
import me.frank.hbu.sshe.service.UserServiceI;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {
	
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private User user = new User();

	@Autowired
	private UserServiceI userService;

	@Override
	public User getModel() {
		return user;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public void register() {
		logger.info("user registering :" + user.toString());
		Json json = new Json();
		try {
			userService.save(user);
			json.setSuccess(true);
			json.setMsg("注册成功！");
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
		
		super.writeJson(json);
	}

	public void add() {
		logger.info("user adding :" + user.toString());
		Json json = new Json();
		try {
			User u = userService.save(user);
			json.setSuccess(true);
			json.setMsg("添加成功！");
			json.setObj(u);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}

		super.writeJson(json);

	}

	public void login() {
		logger.info("user logining :" + user.toString());
		User u = userService.login(user);
		Json json = new Json();
		if (u != null) {
			json.setSuccess(true);
			json.setMsg("登陆成功！");
		} else {
			json.setMsg("登录失败，用户名或密码错误！");
		}

		super.writeJson(json);
	}

	public void datagrid() {
		logger.info("user getting datagrid :" + user.toString());
		super.writeJson(userService.datagrid(user));
	}

	public void remove() {
		logger.info("user removing :" + user.getIds());
		userService.remove(user.getIds());
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功！");
		super.writeJson(j);
	}
}
