package com.two95.sooraj.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.two95.sooraj.implementations.Department;
import com.two95.sooraj.implementations.Manager;

import junit.framework.Assert;

public class DepartmentTest {
private Department testClass;
private Manager manager;
	
	@Test
	public void testNull(){
		testClass=new Department();
		Assert.assertNotNull(testClass);
		
	}
	@Test
	public void getAllocation_whenDepartmentHasOneManager_shouldReturn_300() {
		testClass = new Department();
		BigDecimal expenseAllocation = new BigDecimal("300");
		testClass.addEmployee(new Manager());
		manager=new Manager();
		BigDecimal response = testClass.allocationEach();
		Assert.assertEquals(response,expenseAllocation );
	}}

