package com.example.Coronavirustracker.models;

public class locationState {
	
	
	private String state;
	private String Country;
	private int  latestTotalCases;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return Country;
	}
	@Override
	public String toString() {
		return "locationState [state=" + state + ", Country=" + Country + ", latestTotalCases=" + latestTotalCases
				+ "]";
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}
	

}
