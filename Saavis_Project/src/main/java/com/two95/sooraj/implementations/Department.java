package com.two95.sooraj.implementations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Department implements Employees {
	public Department() {
		super();
	}
	private static List<Employees> list=new ArrayList<Employees>();
	public BigDecimal allocationEach() {
		BigDecimal totalAllocation=new BigDecimal("0");
		for (Employees e:list){
			totalAllocation=totalAllocation.add(e.allocationEach());
		}
		return totalAllocation;
	}
	public void addEmployee(Employees employee) {
		list.add(employee);
		
	}
	public void removeEmployee(Employees employee) {
		list.remove(employee);
		
	}
	

}
