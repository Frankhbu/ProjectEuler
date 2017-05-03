package me.frank.hbu.sshe.action;

import me.frank.hbu.sshe.service.RepairServiceI;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

@Action(value = "repairAction")
public class RepairAction extends BaseAction {

	@Autowired
	private RepairServiceI repairService;

	public RepairServiceI getRepairService() {
		return repairService;
	}

	public void setRepairService(RepairServiceI repairService) {
		this.repairService = repairService;
	}

	public void init() {
		repairService.repair();
	}

}
