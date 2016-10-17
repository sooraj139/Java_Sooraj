package com.two95.sooraj.test;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.two95.sooraj.implementations.QaTester;

public class QaTest {
	private QaTester qatester;
	
	@Test
	public void testNull(){
		qatester=new QaTester();
		Assert.assertNotNull(qatester);
		
		
	}
	@Test
	public void testAllocation(){
		BigDecimal expensealloc=new BigDecimal("500");
		qatester=new QaTester();
		BigDecimal resp=qatester.allocationEach();
		//Assert.assertEquals(qatester,500);
		Assert.assertThat(resp, Is.is(expensealloc));
		
	}

}
