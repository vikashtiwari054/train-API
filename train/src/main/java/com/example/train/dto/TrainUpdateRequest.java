package com.example.train.dto;

import java.util.List;

public class TrainUpdateRequest {

	private String number;
	private String name;
	private List<String> stations;

	private String source;
	private String destination;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getStations() {
		return stations;
	}
	public void setStations(List<String> stations) {
		this.stations = stations;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
