package me.frank.hbu.sshe.service;

import me.frank.hbu.sshe.pageModel.DataGrid;
import me.frank.hbu.sshe.pageModel.User;

public interface UserServiceI {

	public User save(User user);

	public User login(User user);

	public DataGrid<User> datagrid(User user);

	public void remove(String ids);

}
