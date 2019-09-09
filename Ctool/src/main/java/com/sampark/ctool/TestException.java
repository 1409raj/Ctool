package com.sampark.ctool;

public class TestException {
	
	
	public static void main(String[] args) {
		TestException testException=new TestException();
	Integer c=	testException.add(10, 20);
		
	System.out.println(c);
	}
	
	
	@SuppressWarnings("finally")
	Integer add(int a,int b)
	{
		try {
			
			return a/0;
		} catch (Exception e) {
			return 20;
			// TODO: handle exception
		}
		finally {
			return null;
		}
	}
	
	
	
	

}
