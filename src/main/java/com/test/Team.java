package com.test;

public class Team {

	private String company;
	private String project;
	private String budget;
	private String teamName;

	public Team(String company, String project, String budget, String team) {
		super();
		this.company = company;
		this.project = project;
		this.budget = budget;
		this.teamName = team;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTeam() {
		return teamName;
	}

	public void setTeam(String team) {
		this.teamName = team;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team team = (Team) obj;
			return (team.company.equals(this.company) && team.project.equals(this.project)
					&& team.budget.equals(this.budget) && team.teamName.equals(this.teamName));
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode += company.hashCode();

		return hashcode;
	}

}
