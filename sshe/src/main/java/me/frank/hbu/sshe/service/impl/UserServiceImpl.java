package me.frank.hbu.sshe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.frank.hbu.sshe.dao.BaseDaoI;
import me.frank.hbu.sshe.model.Tuser;
import me.frank.hbu.sshe.pageModel.DataGrid;
import me.frank.hbu.sshe.pageModel.User;
import me.frank.hbu.sshe.service.UserServiceI;
import me.frank.hbu.sshe.util.Encrypt;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private BaseDaoI<Tuser> userDao;

	public BaseDaoI<Tuser> getUserDao() {
		return userDao;
	}

	public void setUserDao(BaseDaoI<Tuser> userDao) {
		this.userDao = userDao;
	}

	@Override
	public User save(User user) {
		Tuser t = new Tuser();
		BeanUtils.copyProperties(user, t, new String[] { "pwd" });
		t.setId(UUID.randomUUID().toString());
		t.setCreatedatetime(new Date());
		t.setPwd(Encrypt.encrypt(user.getPwd()));
		userDao.save(t);
		BeanUtils.copyProperties(t, user);
		return user;
	}

	@Override
	public User login(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pwd", Encrypt.encrypt(user.getPwd()));
		params.put("name", user.getName());
		Tuser t = userDao.get("from Tuser t where t.name = :name and t.pwd = :pwd", params);
		if (t != null) {
			return user;
		}
		return null;
	}

	@Override
	public DataGrid<User> datagrid(User user) {
		DataGrid<User> dateGrid = new DataGrid<User>();
		String hql = "from Tuser t ";
		Map<String, Object> params = new HashMap<String, Object>();
		hql = addWhere(user, hql, params);
		String totalHql = "select count(*) " + hql;
		hql = addOrder(user, hql);
		List<Tuser> tusers = userDao.find(hql, params, user.getPage(), user.getRows());
		List<User> users = new ArrayList<User>();
		changeModel(tusers, users);
		dateGrid.setTotal(userDao.count(totalHql, params));
		dateGrid.setRows(users);
		return dateGrid;
	}

	private void changeModel(List<Tuser> tusers, List<User> users) {
		if (tusers != null && tusers.size() > 0) {
			for (Tuser tuser : tusers) {
				User user = new User();
				BeanUtils.copyProperties(tuser, user);
				users.add(user);
			}
		}
	}

	private String addOrder(User user, String hql) {
		if (user.getSort() != null) {
			hql += " order by " + user.getSort() + " " + user.getOrder();
		}
		return hql;
	}

	private String addWhere(User user, String hql, Map<String, Object> params) {
		if (user.getName() != null && !user.getName().trim().equals("")) {
			hql += " where t.name like :name";
			params.put("name", "%%" + user.getName().trim() + "%%");
		}
		return hql;
	}

	@Override
	public void remove(String ids) {
		String[] array = ids.split(",");
		String hql = "delete Tuser t where t.id in (";
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				hql += ",";
			}
			hql += "'" + array[i] + "'";
		}
		hql += ")";
		userDao.executeHql(hql);
	}
}
