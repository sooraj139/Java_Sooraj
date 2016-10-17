package com.two95.sooraj.test;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.two95.sooraj.implementations.Developer;

import junit.framework.Assert;

public class DeveloperTest {
	public Developer testClass;

	@Test
	public void testDevelop() {
		testClass = new Developer();
		Assert.assertNotNull(testClass);
	}
	public void getAllocation(){
//		testClass=new Developer();
//		Assert.assertEquals(testClass.allocationEach(),1000);
		BigDecimal expenseAllocation = new BigDecimal("1000");
		testClass = new Developer();
		BigDecimal response = testClass.allocationEach();
		Assert.assertEquals(response, expenseAllocation);
	}
}
