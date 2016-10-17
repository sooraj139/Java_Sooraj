package com.two95.sooraj.test;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.two95.sooraj.implementations.Manager;

import junit.framework.Assert;

public class ManagerTest {
	private Manager testClass;
	
	@Test
	public void testNull(){
		testClass=new Manager();
		Assert.assertNotNull(testClass);
		
	}
	@Test
	public void allocationTest(){
		BigDecimal expenseAllocation = new BigDecimal("300");
		testClass = new Manager();
		BigDecimal response = testClass.allocationEach();
		Assert.assertEquals(response, expenseAllocation);
		
	}

}
