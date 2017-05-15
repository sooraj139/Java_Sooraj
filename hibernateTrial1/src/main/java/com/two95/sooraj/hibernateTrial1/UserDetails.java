package com.two95.sooraj.hibernateTrial1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String userName;
	@OneToOne
	private Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	// @OneToMany
	// private List<Vehicle> vehicle=new ArrayList<Vehicle>();
	//
	// public List<Vehicle> getVehicle() {
	// return vehicle;
	// }
	// public void setVehicle(List<Vehicle> vehicle) {
	// this.vehicle = vehicle;
	// }
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
