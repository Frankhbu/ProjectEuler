package me.frank.hbu.sshe.service;

import java.util.List;

import me.frank.hbu.sshe.pageModel.Menu;

public interface MenuServiceI {

	public List<Menu> getTreeNode(String id);

	public List<Menu> getAllTreeNode();

}
