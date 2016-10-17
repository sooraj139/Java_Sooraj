package com.two95.sooraj.implementations;

import java.math.BigDecimal;

public class Developer implements Employees {
	private static BigDecimal allocation = new BigDecimal("1000");

	public Developer() {

	}

	public BigDecimal allocationEach() {

		return Developer.allocation;
	}

	public void addEmployee(Employees employee) {

	}

	public void removeEmployee(Employees employee) {

	}

}
