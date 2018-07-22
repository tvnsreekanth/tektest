package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	private static final String COMMA_DELIMITER = ",";
	private static final String ACME = "Acme";
	private static final String OFFSHOREDRILLING = "Offshoredrilling";
	private static final String GREENENERGYRANDD = "GreenEnergyR&D";

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		int teamsForAcne = 0;
		int gerdBudget = 0;
		try {
			// Reading the csv file
			InputStream inputStream = Main.class.getResourceAsStream("/test.csv");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			// Create List for holding Team objects
			Set<Team> teamList = new HashSet<Team>();

			String line = "";
			// Read to get the header for adding on each Team printing
			String headers = bufferedReader.readLine();
			List<String> headersList = Arrays.asList(headers.split(","));

			// Reading from the second line
			while ((line = bufferedReader.readLine()) != null) {
				String[] teamDetails = line.split(COMMA_DELIMITER);

				if (teamDetails.length > 0) {
					Team team = new Team(teamDetails[0].replace("\"", ""), teamDetails[1].replace("\"", ""),
							teamDetails[3].replace("\"", ""), teamDetails[4].replace("\"", ""));
					teamList.add(team);
				}
			}
			for (Team team : teamList) {
				System.out.println("[" + headersList.get(0).replace("\"", "") + "= " + team.getCompany() + " ,  "
						+ headersList.get(1).replace("\"", "") + "= " + team.getProject() + " ,  "
						+ headersList.get(3).replace("\"", "") + "= " + team.getBudget() + "  , "
						+ headersList.get(4).replace("\"", "") + "= " + team.getTeam() + "]");
				if ((ACME.equalsIgnoreCase(team.getCompany())
						&& (OFFSHOREDRILLING.equalsIgnoreCase(team.getProject())))) {

					teamsForAcne++;
				}
				if (GREENENERGYRANDD.equalsIgnoreCase(team.getProject())) {

					gerdBudget = gerdBudget + Integer.parseInt(team.getBudget().replace("$", ""));

				}

			}
			System.out.println("Total number of teams in Acme working  on offshore drilling : " + teamsForAcne);
			System.out.println("Dev teams budget for GERD is: " + gerdBudget + "$");

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}
	}

}