package com.two95.sooraj.implementations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Employees{
	private static BigDecimal allocation=new BigDecimal("300");
	private List<Employees> list=new ArrayList<Employees>();
	public Manager(){
		super();
	}
	
	public BigDecimal allocationEach() {
		BigDecimal totalAllocation=Manager.allocation;
		for (Employees e:list){
			totalAllocation=totalAllocation.add(e.allocationEach());
		}
		return totalAllocation;
	}
	
	public void addEmployee(Employees employee) {
		list.add(employee);
		
	}
	public void removeEmployee(Employees employee) {
		list.add(employee);
		
	}
	
	

}
