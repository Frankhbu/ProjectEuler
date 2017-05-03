package me.frank.hbu.sshe.action;

import me.frank.hbu.sshe.pageModel.Menu;
import me.frank.hbu.sshe.service.MenuServiceI;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

	private static final Logger logger = Logger.getLogger(MenuAction.class);

	private Menu menu = new Menu();

	private MenuServiceI menuService;

	public MenuServiceI getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	@Override
	public Menu getModel() {
		return menu;
	}

	/**
	 * 异步获取树节点
	 */
	public void getTreeNode() {
		logger.info("get menu :"+menu.getId()+"");
		super.writeJson(menuService.getTreeNode(menu.getId()));
	}

	/**
	 * 获取所有菜单
	 */
	public void getAllTreeNode() {
		logger.info("get all menus");
		super.writeJson(menuService.getAllTreeNode());
	}

}
