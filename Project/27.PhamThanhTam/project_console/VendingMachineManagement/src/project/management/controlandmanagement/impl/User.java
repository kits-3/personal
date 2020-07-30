package project.management.controlandmanagement.impl;

import project.management.controlandmanagement.IUser;
import project.management.task.IStatistics;
import project.management.task.impl.Statistic;

public class User implements IUser {
	private IStatistics statistics;
	public User() {
		this.statistics = new Statistic();
	}
	@Override
	public void statistics() {
		statistics.statistics();
		
	}

}
